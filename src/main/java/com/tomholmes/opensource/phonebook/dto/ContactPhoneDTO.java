package com.tomholmes.opensource.phonebook.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class ContactPhoneDTO  implements Serializable
{
    private Long phoneId;
    private ContactDTO contact;
    private PhoneTypeDTO phoneType;
    private String phone;
    private LocalDateTime enteredDate;

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }

    public PhoneTypeDTO getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneTypeDTO phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }
}
