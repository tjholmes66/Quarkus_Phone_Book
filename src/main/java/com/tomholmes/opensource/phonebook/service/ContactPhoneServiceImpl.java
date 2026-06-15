package com.tomholmes.opensource.phonebook.service;



import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import com.tomholmes.opensource.phonebook.repository.ContactPhoneRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@ApplicationScoped
public class ContactPhoneServiceImpl implements ContactPhoneService
{
    private ContactPhoneRepository contactPhoneDao;

    public ContactPhoneServiceImpl(ContactPhoneRepository contactPhoneDao)
    {
        this.contactPhoneDao = contactPhoneDao;
    }

    @Override
    public List<ContactPhoneEntity> getAllPhonesByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactPhoneEntity> contactPhoneList = contactPhoneDao.findByContact(contact);
        return contactPhoneList;
    }

    @Override
    public List<ContactPhoneEntity> getAllPhonesByContactId(ContactEntity contactEntity)
    {
        List<ContactPhoneEntity> contactPhoneList = contactPhoneDao.findByContact(contactEntity);
        return contactPhoneList;
    }

    @Override
    public ContactPhoneEntity createContactPhone(ContactPhoneEntity contactPhone) {
        contactPhoneDao.persistAndFlush(contactPhone);
        return contactPhone;
    }

    @Override
    public ContactPhoneEntity updateContactPhone(ContactPhoneEntity contactPhone) {
        contactPhoneDao.persistAndFlush(contactPhone);
        return contactPhone;
    }

    @Override
    public void deleteContactPhone(ContactPhoneEntity contactPhone) {
        contactPhoneDao.delete(contactPhone);
    }

    @Override
    public void deleteContactPhoneById(long contactPhoneId) {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.findById(contactPhoneId);
        contactPhoneDao.delete(contactPhoneEntity);
    }

    @Override
    public ContactPhoneEntity getPhoneContactById(long phoneId)
    {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.findById(phoneId);
        return contactPhoneEntity;
    }
}
