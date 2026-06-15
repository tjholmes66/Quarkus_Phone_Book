package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;

import java.util.List;

public interface ContactLinkService
{
    List<ContactLinkEntity> getAllLinksByContactId(long contactId);

    ContactLinkEntity getLinkContactById(long linkId);

    List<ContactLinkEntity> getAllLinksByContactId(ContactEntity contactEntity);

    ContactLinkEntity createContactLink(ContactLinkEntity contactLink);

    ContactLinkEntity updateContactLink(ContactLinkEntity contactLink);

    void deleteContactLink(ContactLinkEntity contactLink);

    void deleteContactLinkById(Long contactLinkId);
}
