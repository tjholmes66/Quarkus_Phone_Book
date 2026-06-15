package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactLinkDTO;
import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;
import com.tomholmes.opensource.phonebook.repository.ContactLinkRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ContactLinkListMapperTest {

    @Inject
    private ContactLinkRepository contactLinkRepository; // repository

    @Inject
    private ContactLinkListMapper contactLinkListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long contactId = 5L;
        List<ContactLinkEntity> contactLinkEntityList = contactLinkRepository.findByContactContactId(contactId);
        assertNotNull(contactLinkEntityList);
        assertEquals(1, contactLinkEntityList.size());

        List<ContactLinkDTO> contactLinkDTOList = contactLinkListMapper.entityListToDtoList(contactLinkEntityList);
        assertNotNull(contactLinkDTOList);
        assertEquals(1, contactLinkDTOList.size());

        contactLinkEntityList = contactLinkListMapper.dtoListToEntityList(contactLinkDTOList);
        assertNotNull(contactLinkDTOList);
        assertEquals(1, contactLinkDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long contactId = 5L;
        List<ContactLinkEntity> contactLinkEntityList = contactLinkRepository.findByContactContactId(contactId);
        assertNotNull(contactLinkEntityList);
        assertEquals(1, contactLinkEntityList.size());

        List<ContactLinkDTO> contactLinkDTOList = contactLinkListMapper.entityListToDtoList(contactLinkEntityList);
        assertNotNull(contactLinkDTOList);
        assertEquals(1, contactLinkDTOList.size());
    }

}
