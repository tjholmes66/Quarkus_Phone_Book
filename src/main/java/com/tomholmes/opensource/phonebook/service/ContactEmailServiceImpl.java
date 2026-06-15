package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.ContactEmailEntity;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.repository.ContactEmailRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;


@Transactional
@ApplicationScoped
public class ContactEmailServiceImpl implements ContactEmailService
{
    private ContactEmailRepository contactEmailDao;

    public ContactEmailServiceImpl(ContactEmailRepository contactEmailDao)
    {
        this.contactEmailDao = contactEmailDao;
    }

    @Override
    public List<ContactEmailEntity> getAllEmailsByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactEmailEntity> contactEmailList = contactEmailDao.findByContact(contact);
        return contactEmailList;
    }

    @Override
    public List<ContactEmailEntity> getAllEmailsByContactId(ContactEntity contactEntity)
    {
        List<ContactEmailEntity> contactEmailList = contactEmailDao.findByContact(contactEntity);
        return contactEmailList;
    }

    @Override
    public ContactEmailEntity createContactEmail(ContactEmailEntity contactEmail) {
        contactEmailDao.persistAndFlush(contactEmail);
        return contactEmail;
    }

    @Override
    public ContactEmailEntity updateContactEmail(ContactEmailEntity contactEmail) {
        contactEmailDao.persistAndFlush(contactEmail);
        return contactEmail;
    }

    @Override
    public void deleteContactEmail(ContactEmailEntity contactEmail) {
        contactEmailDao.delete(contactEmail);
    }

    @Override
    public void deleteContactEmailById(Long contactEmailId)
    {
        ContactEmailEntity contactEmailEntity = contactEmailDao.findById(contactEmailId);
        contactEmailDao.delete(contactEmailEntity);
    }

    @Override
    public ContactEmailEntity getEmailContactById(long emailId)
    {
        ContactEmailEntity contactEmailEntity = contactEmailDao.findById(emailId);
        return contactEmailEntity;
    }
}
