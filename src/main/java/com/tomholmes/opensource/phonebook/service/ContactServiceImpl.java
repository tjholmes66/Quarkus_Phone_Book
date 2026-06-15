package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.dto.ContactDTO;
import com.tomholmes.opensource.phonebook.dto.ContactDataResponseDTO;
import com.tomholmes.opensource.phonebook.dto.ContactEmailDTO;
import com.tomholmes.opensource.phonebook.dto.ContactLinkDTO;
import com.tomholmes.opensource.phonebook.dto.ContactPhoneDTO;
import com.tomholmes.opensource.phonebook.mapper.ContactEmailListMapper;
import com.tomholmes.opensource.phonebook.mapper.ContactLinkListMapper;
import com.tomholmes.opensource.phonebook.mapper.ContactListMapper;
import com.tomholmes.opensource.phonebook.mapper.ContactPhoneListMapper;
import com.tomholmes.opensource.phonebook.model.ContactEmailEntity;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;
import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import com.tomholmes.opensource.phonebook.repository.ContactEmailRepository;
import com.tomholmes.opensource.phonebook.repository.ContactLinkRepository;
import com.tomholmes.opensource.phonebook.repository.ContactPhoneRepository;
import com.tomholmes.opensource.phonebook.repository.ContactRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@ApplicationScoped
public class ContactServiceImpl implements ContactService
{
    private ContactRepository contactDao;

    private ContactEmailRepository contactEmailDao;
    private ContactPhoneRepository contactPhoneDao;
    private ContactLinkRepository contactLinkDao;

    private ContactListMapper contactListMapper;

    private ContactEmailListMapper contactEmailListMapper;
    private ContactPhoneListMapper contactPhoneListMapper;
    private ContactLinkListMapper contactLinkListMapper;

    public ContactServiceImpl(ContactRepository contactDao,
                              ContactListMapper contactListMapper,
                              ContactEmailRepository contactEmailDao,
                              ContactPhoneRepository contactPhoneDao,
                              ContactLinkRepository contactLinkDao,
                              ContactEmailListMapper contactEmailListMapper,
                              ContactPhoneListMapper contactPhoneListMapper,
                              ContactLinkListMapper contactLinkListMapper
                              )
    {
        this.contactDao = contactDao;
        this.contactListMapper = contactListMapper;
        this.contactEmailDao = contactEmailDao;
        this.contactPhoneDao = contactPhoneDao;
        this.contactLinkDao = contactLinkDao;
        this.contactEmailListMapper = contactEmailListMapper;
        this.contactPhoneListMapper = contactPhoneListMapper;
        this.contactLinkListMapper = contactLinkListMapper;
    }

    @Override
    public List<ContactEntity> getAllContacts()
    {
        List<ContactEntity> contactList = contactDao.findAll().list();
        return contactList;
    }

    @Override
    public List<ContactDTO> getContactsByUserId(long userId)
    {
        List<ContactDTO> contactDTOList = new ArrayList<ContactDTO>();
        List<ContactEntity> contactEntityList = contactDao.findByUserUserId(userId);
        contactDTOList = contactListMapper.entityListToDtoList(contactEntityList);
        return contactDTOList;
    }

    @Override
    public ContactEntity getContactById(long contactId)
    {
        ContactEntity contactEntity = contactDao.findById(contactId);
        return contactEntity;
    }

    @Override
    public ContactEntity add(ContactEntity newContact)
    {
        contactDao.persistAndFlush(newContact);
        return newContact;
    }

    @Override
    public ContactEntity update(ContactEntity newContact)
    {
        contactDao.persistAndFlush(newContact);
        return newContact;
    }

    @Override
    public void remove(long contactId)
    {
        System.out.println("remove: contactId=" + contactId);
        contactDao.deleteById(contactId);
    }

    @Override
    public ContactDataResponseDTO getContactDataById(long contactId) {
        System.out.println("getContactDataById: contactId=" + contactId);
        ContactDataResponseDTO contactDataResponseDTO = new ContactDataResponseDTO();

        List<ContactEmailEntity> contactEmailEntityList = contactEmailDao.findByContactContactId(contactId);
        List<ContactEmailDTO> contactEmailDTOList = contactEmailListMapper.entityListToDtoList(contactEmailEntityList);
        contactDataResponseDTO.setEmailList(contactEmailDTOList);

        List<ContactPhoneEntity> contactPhoneEntityList = contactPhoneDao.findByContactContactId(contactId);
        List<ContactPhoneDTO> contactPhoneDTOList = contactPhoneListMapper.entityListToDtoList(contactPhoneEntityList);
        contactDataResponseDTO.setPhoneList(contactPhoneDTOList);

        List<ContactLinkEntity> contactLinkEntityList = contactLinkDao.findByContactContactId(contactId);
        List<ContactLinkDTO> contactLinkDTOList = contactLinkListMapper.entityListToDtoList(contactLinkEntityList);
        contactDataResponseDTO.setLinkList(contactLinkDTOList);

        return contactDataResponseDTO;
    }

}
