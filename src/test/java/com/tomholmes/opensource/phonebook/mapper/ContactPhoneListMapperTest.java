package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactPhoneDTO;
import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import com.tomholmes.opensource.phonebook.repository.ContactPhoneRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ContactPhoneListMapperTest {

    @Inject
    private ContactPhoneRepository contactPhoneRepository; // repository

    @Inject
    private ContactPhoneListMapper contactPhoneListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long contactId = 5L;
        List<ContactPhoneEntity> contactPhoneEntityList = contactPhoneRepository.findByContactContactId(contactId);
        assertNotNull(contactPhoneEntityList);
        assertEquals(3, contactPhoneEntityList.size());

        List<ContactPhoneDTO> contactPhoneDTOList = contactPhoneListMapper.entityListToDtoList(contactPhoneEntityList);
        assertNotNull(contactPhoneDTOList);
        assertEquals(3, contactPhoneDTOList.size());

        contactPhoneEntityList = contactPhoneListMapper.dtoListToEntityList(contactPhoneDTOList);
        assertNotNull(contactPhoneDTOList);
        assertEquals(3, contactPhoneDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long contactId = 5L;
        List<ContactPhoneEntity> contactPhoneEntityList = contactPhoneRepository.findByContactContactId(contactId);
        assertNotNull(contactPhoneEntityList);
        assertEquals(3, contactPhoneEntityList.size());

        List<ContactPhoneDTO> contactPhoneDTOList = contactPhoneListMapper.entityListToDtoList(contactPhoneEntityList);
        assertNotNull(contactPhoneDTOList);
        assertEquals(3, contactPhoneDTOList.size());
    }

}
