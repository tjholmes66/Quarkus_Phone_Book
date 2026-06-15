package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.CompanyDTO;
import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import com.tomholmes.opensource.phonebook.repository.CompanyRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@QuarkusTest
public class CompanyListMapperTest {

    @Inject
    private CompanyRepository companyRepository; // repository

    @Inject
    private CompanyListMapper companyListMapper;

    @Test
    public void testDtoListToEntityList() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll().list();
        assertNotNull(companyEntityList);
        assertEquals(4, companyEntityList.size());

        List<CompanyDTO> companyDTOList = companyListMapper.entityListToDtoList(companyEntityList);
        assertNotNull(companyDTOList);
        assertEquals(4, companyDTOList.size());

        companyEntityList = companyListMapper.dtoListToEntityList(companyDTOList);
        assertNotNull(companyDTOList);
        assertEquals(4, companyDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll().list();
        assertNotNull(companyEntityList);
        assertEquals(4, companyEntityList.size());

        List<CompanyDTO> companyDTOList = companyListMapper.entityListToDtoList(companyEntityList);
        assertNotNull(companyDTOList);
        assertEquals(4, companyDTOList.size());
    }

}
