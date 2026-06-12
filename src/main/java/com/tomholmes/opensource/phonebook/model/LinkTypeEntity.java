package com.tomholmes.opensource.phonebook.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// CREATE TABLE `link_type` (
// `link_type_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `link_type_description` varchar(45) NOT NULL,
// `link_type_active` tinyint(1) NOT NULL DEFAULT '1',
// PRIMARY KEY (`link_type_id`),
// UNIQUE KEY `link_type_description_UNIQUE` (`link_type_description`)
// ) ENGINE=InnoDB IDENTITY_INCREMENT=4 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "link_type")
public class LinkTypeEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_type_id")
    private Long id;

    @Column(name = "link_type_description")
    private String description;

    @Column(name = "link_type_active")
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
