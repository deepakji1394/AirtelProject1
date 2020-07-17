package com.airtel.orderservice.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Denotes an entity to be auditable
 * Audit entities have two primary columns created_at, updated_at
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class Auditable extends Identifiable {

    /**
     * Created UNIX time
     */
    @Column(name = "created_at", columnDefinition = "bigint", nullable = false)
    @CreatedDate
    private Long createdAt;

    /**
     * Last updated UNIX time
     */
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "bigint", nullable = false)
    private Long updatedAt;

    /**
     * Gets createdAt
     * returns the value of createdAt
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of createdAt
     *
     * @param createdAt the value of createdAt to be set
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updatedAt
     * returns the value of updatedAt
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the value of updatedAt
     *
     * @param updatedAt the value of updatedAt to be set
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}