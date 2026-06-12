package com.tomholmes.opensource.phonebook.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// CREATE TABLE `position` (
// `position_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `active` tinyint(1) NOT NULL DEFAULT '1',
// `code` varchar(45) NOT NULL,
// `description` varchar(45) DEFAULT NULL,
// PRIMARY KEY (`position_id`),
// UNIQUE KEY `code_unq` (`code`)
// ) ENGINE=InnoDB IDENTITY_INCREMENT=4 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "position")
public class PositionEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "code")
    private String positionCode;

    @Column(name = "description")
    private String description;


    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
