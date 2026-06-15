package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactEmailDTO;
import com.tomholmes.opensource.phonebook.model.ContactEmailEntity;
import com.tomholmes.opensource.phonebook.repository.ContactEmailRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ContactEmailListMapperTest {

    @Inject
    private ContactEmailRepository contactEmailRepository; // repository

    @Inject
    private ContactEmailListMapper contactEmailListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long contactId = 5L;
        List<ContactEmailEntity> contactEmailEntityList = contactEmailRepository.findByContactContactId(contactId);
        assertNotNull(contactEmailEntityList);
        assertEquals(3, contactEmailEntityList.size());

        List<ContactEmailDTO> contactEmailDTOList = contactEmailListMapper.entityListToDtoList(contactEmailEntityList);
        assertNotNull(contactEmailDTOList);
        assertEquals(3, contactEmailDTOList.size());

        contactEmailEntityList = contactEmailListMapper.dtoListToEntityList(contactEmailDTOList);
        assertNotNull(contactEmailDTOList);
        assertEquals(3, contactEmailDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long contactId = 5L;
        List<ContactEmailEntity> contactEmailEntityList = contactEmailRepository.findByContactContactId(contactId);
        assertNotNull(contactEmailEntityList);
        assertEquals(3, contactEmailEntityList.size());

        List<ContactEmailDTO> contactEmailDTOList = contactEmailListMapper.entityListToDtoList(contactEmailEntityList);
        assertNotNull(contactEmailDTOList);
        assertEquals(3, contactEmailDTOList.size());
    }

}
