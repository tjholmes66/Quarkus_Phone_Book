package com.tomholmes.opensource.phonebook.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class ContactEmailDTO implements Serializable
{
    private Long emailId;
    private ContactDTO contact;
    private EmailTypeDTO emailType;
    private String email;
    private LocalDateTime enteredDate;

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }

    public EmailTypeDTO getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailTypeDTO emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }
}
