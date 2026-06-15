package com.tomholmes.opensource.phonebook.service;



import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import com.tomholmes.opensource.phonebook.repository.ContactPhoneRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ContactPhoneServiceImpl implements ContactPhoneService
{
    private ContactPhoneRepository contactPhoneDao;

    public ContactPhoneServiceImpl(ContactPhoneRepository contactPhoneDao)
    {
        this.contactPhoneDao = contactPhoneDao;
    }

    @Override
    @Transactional
    public List<ContactPhoneEntity> getAllPhonesByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactPhoneEntity> contactPhoneList = contactPhoneDao.findByContact(contact);
        return contactPhoneList;
    }

    @Override
    @Transactional
    public List<ContactPhoneEntity> getAllPhonesByContactId(ContactEntity contactEntity)
    {
        List<ContactPhoneEntity> contactPhoneList = contactPhoneDao.findByContact(contactEntity);
        return contactPhoneList;
    }

    @Override
    @Transactional
    public ContactPhoneEntity createContactPhone(ContactPhoneEntity contactPhone) {
        contactPhoneDao.persistAndFlush(contactPhone);
        return contactPhone;
    }

    @Override
    @Transactional
    public ContactPhoneEntity updateContactPhone(ContactPhoneEntity contactPhone) {
        contactPhoneDao.persistAndFlush(contactPhone);
        return contactPhone;
    }

    @Override
    @Transactional
    public void deleteContactPhone(ContactPhoneEntity contactPhone) {
        contactPhoneDao.delete(contactPhone);
    }

    @Override
    @Transactional
    public void deleteContactPhoneById(long contactPhoneId) {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.findById(contactPhoneId);
        contactPhoneDao.delete(contactPhoneEntity);
    }

    @Override
    @Transactional
    public ContactPhoneEntity getPhoneContactById(long phoneId)
    {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.findById(phoneId);
        return contactPhoneEntity;
    }
}
