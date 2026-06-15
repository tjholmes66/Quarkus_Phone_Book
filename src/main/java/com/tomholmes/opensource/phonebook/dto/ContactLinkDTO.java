package com.tomholmes.opensource.phonebook.dto;

import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.LinkTypeEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.time.LocalDateTime;


@SuppressWarnings("serial")
@ApplicationScoped
public class ContactLinkDTO implements Serializable
{
    private Long linkId;
    private ContactEntity contact;
    private LinkTypeEntity linkType;
    private String link;
    private String linkDescription;
    private LocalDateTime enteredDate;

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public LinkTypeEntity getLinkType() {
        return linkType;
    }

    public void setLinkType(LinkTypeEntity linkType) {
        this.linkType = linkType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }
}
