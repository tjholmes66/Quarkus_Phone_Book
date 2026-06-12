package com.tomholmes.opensource.phonebook.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * CREATE TABLE `company` (
 * `company_id` int NOT NULL AUTO_INCREMENT,
 * `active` tinyint(1) NOT NULL,
 * `code` varchar(10) NOT NULL,
 * `name` varchar(45) NOT NULL,
 * `description` varchar(345) DEFAULT NULL,
 * `address1` varchar(45) DEFAULT NULL,
 * `address2` varchar(45) DEFAULT NULL,
 * `city` varchar(45) DEFAULT NULL,
 * `state` varchar(45) DEFAULT NULL,
 * `zip` varchar(45) DEFAULT NULL,
 * PRIMARY KEY (`company_id`),
 * KEY `code` (`code`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * 
 */

@Entity
@Table(name = "company")
public class CompanyEntity implements Serializable
{
    // `company_id` int NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    // `active` tinyint(1) NOT NULL,
    @Column(name = "active")
    private Boolean active;

    // `code` varchar(10) NOT NULL,
    @Column(name = "code")
    private String companyCode;

    // `name` varchar(45) NOT NULL,
    @Column(name = "name")
    private String companyName;

    // `description` varchar(345) DEFAULT NULL,
    @Column(name = "description")
    private String description;

    // `address1` varchar(45) DEFAULT NULL,
    @Column(name = "address1")
    private String address1;

    // `address2` varchar(45) DEFAULT NULL,
    @Column(name = "address2")
    private String address2;

    // `city` varchar(45) DEFAULT NULL,
    @Column(name = "city")
    private String city;

    // `state` varchar(45) DEFAULT NULL,
    @Column(name = "state")
    private String state;

    // `zip` varchar(45) DEFAULT NULL,
    @Column(name = "zip")
    private String zip;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
