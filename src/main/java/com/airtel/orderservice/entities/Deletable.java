package com.airtel.orderservice.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Whether the entity is deletable or not
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@MappedSuperclass
public class Deletable extends Auditable {

    /**
     * user deleted
     */
    @Column(name = "deleted", columnDefinition = "tinyint")
    private Integer deleted;

    /**
     * Gets deleted
     *
     * @return value of deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * Sets the value of deleted
     *
     * @return The value of deleted to be set
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
