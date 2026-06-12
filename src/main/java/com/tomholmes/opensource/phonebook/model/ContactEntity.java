package com.tomholmes.opensource.phonebook.model;

//
// CREATE TABLE `contacts` (
// `contact_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `prefix` varchar(45) DEFAULT NULL,
// `first_name` varchar(45) NOT NULL,
// `middle_name` varchar(45) DEFAULT NULL,
// `last_name` varchar(45) NOT NULL,
// `suffix` varchar(45) DEFAULT NULL,
// `address1` varchar(45) DEFAULT NULL,
// `address2` varchar(45) DEFAULT NULL,
// `city` varchar(45) DEFAULT NULL,
// `state` varchar(2) DEFAULT NULL,
// `zip` varchar(45) DEFAULT NULL,
// `company_id` int(11) DEFAULT NULL,
// `entered_by` int(11) DEFAULT NULL,
// `entered_date` datetime DEFAULT NULL,
// `edited_by` int(11) DEFAULT NULL,
// `edited_date` datetime DEFAULT NULL,
// `birthdate` datetime DEFAULT NULL
// PRIMARY KEY (`contact_id`),
// UNIQUE KEY `username_UNIQUE` (`username`)
// ) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "contacts")
public class ContactEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    // bi-directional many-to-one association to UserEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "prefix")
    private String prefix;

// `first_name` varchar(45) NOT NULL,
    @Column(name = "first_name")
    private String firstName;

// `middle_name` varchar(45) DEFAULT NULL,
    @Column(name = "middle_name")
    private String middleName;

// `last_name` varchar(45) NOT NULL,
    @Column(name = "last_name")
    private String lastName;

// `suffix` varchar(45) DEFAULT NULL,
    @Column(name = "suffix")
    private String suffix;

// `address1` varchar(45) DEFAULT NULL,
    @Column(name = "address1")
    private String address1;

// `address2` varchar(45) DEFAULT NULL,
    @Column(name = "address2")
    private String address2;

// `city` varchar(45) DEFAULT NULL,
    @Column(name = "city")
    private String city;

// `state` varchar(2) DEFAULT NULL,
    @Column(name = "state")
    private String state;

// `zip` varchar(45) DEFAULT NULL,
    @Column(name = "zip")
    private String zip;

    // `company_id` int(11) DEFAULT NULL,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private CompanyEntity  company;

// `entered_by` int(11) DEFAULT NULL,
    @Column(name = "entered_by")
    private Long enteredBy;

// `entered_date` datetime DEFAULT NULL,
    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

// `edited_by` int(11) DEFAULT NULL,
    @Column(name = "edited_by")
    private Long editedBy;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public Long getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Long enteredBy) {
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }

    public Long getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(Long editedBy) {
        this.editedBy = editedBy;
    }

    public LocalDateTime getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(LocalDateTime editedDate) {
        this.editedDate = editedDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // `edited_date` datetime DEFAULT NULL,
    @Column(name = "edited_date")
    private LocalDateTime editedDate;

// `birthdate` datetime DEFAULT NULL,
    @Column(name = "birthdate")
    private LocalDate birthDate;

}
