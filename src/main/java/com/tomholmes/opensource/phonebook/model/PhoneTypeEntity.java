package com.tomholmes.opensource.phonebook.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// CREATE TABLE `phone_type` (
// `phone_type_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `phone_type_description` varchar(45) NOT NULL,
// `phone_type_active` tinyint(1) NOT NULL DEFAULT '1',
// PRIMARY KEY (`phone_type_id`),
// UNIQUE KEY `phone_type_description_UNIQUE` (`phone_type_description`)
// ) ENGINE=InnoDB IDENTITY_INCREMENT=4 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */


@SuppressWarnings("serial")
@Entity
@Table(name = "phone_type")
public class PhoneTypeEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_type_id")
    private Long id;

    @Column(name = "phone_type_description")
    private String description;

    @Column(name = "phone_type_active")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
