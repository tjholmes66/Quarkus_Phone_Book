package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;

import java.util.List;

public interface ContactPhoneService
{
    List<ContactPhoneEntity> getAllPhonesByContactId(long contactId);

    ContactPhoneEntity getPhoneContactById(long phoneId);

    List<ContactPhoneEntity> getAllPhonesByContactId(ContactEntity contactEntity);

    ContactPhoneEntity createContactPhone(ContactPhoneEntity contactPhone);

    ContactPhoneEntity updateContactPhone(ContactPhoneEntity contactPhone);

    void deleteContactPhone(ContactPhoneEntity contactPhone);

    void deleteContactPhoneById(long contactPhoneId);
}
