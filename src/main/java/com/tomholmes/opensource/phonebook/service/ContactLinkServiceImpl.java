package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;
import com.tomholmes.opensource.phonebook.repository.ContactLinkRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@ApplicationScoped
public class ContactLinkServiceImpl implements ContactLinkService
{
    private ContactLinkRepository contactLinkDao;

    public ContactLinkServiceImpl(ContactLinkRepository contactLinkDao)
    {
        this.contactLinkDao = contactLinkDao;
    }

    @Override
    public List<ContactLinkEntity> getAllLinksByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactLinkEntity> contactLinkList = contactLinkDao.findByContact(contact);
        return contactLinkList;
    }

    @Override
    public List<ContactLinkEntity> getAllLinksByContactId(ContactEntity contactEntity)
    {
        List<ContactLinkEntity> contactLinkList = contactLinkDao.findByContact(contactEntity);
        return contactLinkList;
    }

    @Override
    public ContactLinkEntity createContactLink(ContactLinkEntity contactLink) {
        contactLinkDao.persistAndFlush(contactLink);
        return contactLink;
    }

    @Override
    public ContactLinkEntity updateContactLink(ContactLinkEntity contactLink) {
        contactLinkDao.persistAndFlush(contactLink);
        return contactLink;
    }

    @Override
    public void deleteContactLink(ContactLinkEntity contactLink) {
        contactLinkDao.delete(contactLink);
    }

    @Override
    public void deleteContactLinkById(Long contactLinkId)
    {
        ContactLinkEntity contactLinkEntity = contactLinkDao.findById(contactLinkId);
        contactLinkDao.delete(contactLinkEntity);
    }
    
    @Override
    public ContactLinkEntity getLinkContactById(long linkId)
    {
        ContactLinkEntity contactLinkEntity = contactLinkDao.findById(linkId);
        return contactLinkEntity;
    }
}
