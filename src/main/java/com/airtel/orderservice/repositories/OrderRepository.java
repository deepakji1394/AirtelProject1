package com.airtel.orderservice.repositories;

import com.airtel.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring JPA repository for {@link Order} entity
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
