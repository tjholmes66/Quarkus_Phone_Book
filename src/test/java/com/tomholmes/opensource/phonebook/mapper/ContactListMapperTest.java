package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactDTO;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.repository.ContactRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ContactListMapperTest {

    @Inject
    private ContactRepository contactRepository; // repository

    @Inject
    private ContactListMapper contactListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long userId = 3L;
        List<ContactEntity> contactEntityList = contactRepository.findByUserUserId(userId);
        assertNotNull(contactEntityList);
        assertEquals(3, contactEntityList.size());

        List<ContactDTO> contactDTOList = contactListMapper.entityListToDtoList(contactEntityList);
        assertNotNull(contactDTOList);
        assertEquals(3, contactDTOList.size());

        contactEntityList = contactListMapper.dtoListToEntityList(contactDTOList);
        assertNotNull(contactDTOList);
        assertEquals(3, contactDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long userId = 3L;
        List<ContactEntity> contactEntityList = contactRepository.findByUserUserId(userId);
        assertNotNull(contactEntityList);
        assertEquals(3, contactEntityList.size());

        List<ContactDTO> contactDTOList = contactListMapper.entityListToDtoList(contactEntityList);
        assertNotNull(contactDTOList);
        assertEquals(3, contactDTOList.size());
    }

}
