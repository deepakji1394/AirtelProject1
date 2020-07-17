package com.airtel.orderservice.config;

import com.airtel.orderservice.properties.OrderServiceProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;

/**
 * application level datasource configuration
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@Configuration
@EntityScan(basePackages = {"com.monster.orderservice.entities"})
@EnableJpaRepositories(basePackages = {"com.monster.orderservice.repositories"},
        entityManagerFactoryRef = "orderServiceEntityManager",
        transactionManagerRef = "orderServiceTransactionManager")
@EnableTransactionManagement
public class DataSourceConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    /**
     * private static class level logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);

    /**
     * The name of the property to access the database name
     */
    private static final String DATABASE_NAME_PROPERTY = "DB_NAME";

    /**
     * Global environment variable
     */
    @Autowired
    private Environment environment;

    /**
     * application level properties
     */
    @Autowired
    private OrderServiceProperties properties;

    /**
     * The application context in which this object runs
     */
    private ApplicationContext applicationContext;

    /**
     * Return a custom configured {@link HikariDataSource} instance
     *
     * @return {@link HikariDataSource} implementation
     */
    @Bean(name = "orderServiceDataSource")
    @ConfigurationProperties("orderService.data-source")
    @Primary
    public HikariDataSource orderServiceDataSource() {
        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        // NOTE: Do we have to do this ? Find out how to configure this from properties file
        final String databaseName = environment.getProperty(DATABASE_NAME_PROPERTY);
        if (StringUtils.isBlank(databaseName)) {
            throw new IllegalStateException("databaseName cannot be empty/null");
        }
        LOGGER.info("initializing custom primary data source with database name {}", databaseName);
        dataSource.addDataSourceProperty("databaseName", databaseName);
        return dataSource;
    }

    /**
     * creates entity manager bean
     *
     * @return entity manager bean
     */
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean orderServiceEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(orderServiceDataSource());
        em.setPackagesToScan(new String[]{"com.monster.orderservice.entities","com.monster.orderservice.repositories"});
        em.getJpaPropertyMap().put("jadira.usertype.autoRegisterUserTypes", "true");
        em.setPersistenceUnitName("orderServiceEntityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect",
                environment.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }


    /**
     * creates orderService transaction manager
     *
     * @return orderService transaction manager bean
     */
    @Bean
    @Primary
    public PlatformTransactionManager orderServiceTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                orderServiceEntityManager().getObject());
        return transactionManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
