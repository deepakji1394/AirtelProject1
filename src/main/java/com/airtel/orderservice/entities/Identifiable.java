package com.airtel.orderservice.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Denotes an entity to be identifiable
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@MappedSuperclass
public class Identifiable implements Serializable {

    /**
     * Serializable identifier
     */
    private static final long serialVersionUID = -5779695865916191496L;

    /**
     * The primary key of a table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Gets id
     *
     * @return value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of id
     *
     * @return The value of id to be set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
