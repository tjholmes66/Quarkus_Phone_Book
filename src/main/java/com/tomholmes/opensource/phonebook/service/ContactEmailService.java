package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.ContactEmailEntity;
import com.tomholmes.opensource.phonebook.model.ContactEntity;

import java.util.List;


public interface ContactEmailService
{
    List<ContactEmailEntity> getAllEmailsByContactId(long contactId);

    ContactEmailEntity getEmailContactById(long emailId);

    List<ContactEmailEntity> getAllEmailsByContactId(ContactEntity contactEntity);

    ContactEmailEntity createContactEmail(ContactEmailEntity contactEmail);

    ContactEmailEntity updateContactEmail(ContactEmailEntity contactEmail);

    void deleteContactEmail(ContactEmailEntity contactEmail);

    void deleteContactEmailById(Long contactEmailId);

}
