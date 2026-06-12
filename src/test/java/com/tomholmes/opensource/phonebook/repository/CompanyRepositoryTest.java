package com.tomholmes.opensource.phonebook.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CompanyRepositoryTest
{
    @Inject
    private CompanyRepository companyRepository;

    @Test
    @Transactional
    public void testFindById()
    {
        long companyId = 1;
        CompanyEntity companyEntity = companyRepository.findById(companyId);
        assertNotNull(companyEntity);
    }

    @Test
    @Transactional
    public void testFindByCode()
    {
        String companyCode = "IBM";
        List<CompanyEntity> companyRecordList = companyRepository.findByCompanyCode(companyCode);
        assertNotNull(companyRecordList);
    }

    @Test
    @Transactional
    public void testFindAll_Entity()
    {
        List<CompanyEntity> companyEntityList = companyRepository.findAll().list();
        assertNotNull(companyEntityList);
    }

}
