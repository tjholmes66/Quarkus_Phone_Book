package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;
import com.tomholmes.opensource.phonebook.repository.ContactLinkRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ContactLinkServiceImpl implements ContactLinkService
{
    private ContactLinkRepository contactLinkDao;

    public ContactLinkServiceImpl(ContactLinkRepository contactLinkDao)
    {
        this.contactLinkDao = contactLinkDao;
    }

    @Override
    @Transactional
    public List<ContactLinkEntity> getAllLinksByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactLinkEntity> contactLinkList = contactLinkDao.findByContact(contact);
        return contactLinkList;
    }

    @Override
    @Transactional
    public List<ContactLinkEntity> getAllLinksByContactId(ContactEntity contactEntity)
    {
        List<ContactLinkEntity> contactLinkList = contactLinkDao.findByContact(contactEntity);
        return contactLinkList;
    }

    @Override
    @Transactional
    public ContactLinkEntity createContactLink(ContactLinkEntity contactLink) {
        contactLinkDao.persistAndFlush(contactLink);
        return contactLink;
    }

    @Override
    @Transactional
    public ContactLinkEntity updateContactLink(ContactLinkEntity contactLink) {
        contactLinkDao.persistAndFlush(contactLink);
        return contactLink;
    }

    @Override
    @Transactional
    public void deleteContactLink(ContactLinkEntity contactLink) {
        contactLinkDao.delete(contactLink);
    }

    @Override
    @Transactional
    public void deleteContactLinkById(Long contactLinkId)
    {
        ContactLinkEntity contactLinkEntity = contactLinkDao.findById(contactLinkId);
        contactLinkDao.delete(contactLinkEntity);
    }
    
    @Override
    @Transactional
    public ContactLinkEntity getLinkContactById(long linkId)
    {
        ContactLinkEntity contactLinkEntity = contactLinkDao.findById(linkId);
        return contactLinkEntity;
    }
}
