package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.dto.ContactDTO;
import com.tomholmes.opensource.phonebook.dto.ContactDataResponseDTO;
import com.tomholmes.opensource.phonebook.model.ContactEntity;

import java.util.List;

public interface ContactService
{
    List<ContactEntity> getAllContacts();

    List<ContactDTO> getContactsByUserId(long userId);

    ContactEntity getContactById(long contactId);

    ContactEntity add(ContactEntity newContact);

    ContactEntity update(ContactEntity newContact);

    void remove(long contactId);

    ContactDataResponseDTO getContactDataById(long contactId);
}
