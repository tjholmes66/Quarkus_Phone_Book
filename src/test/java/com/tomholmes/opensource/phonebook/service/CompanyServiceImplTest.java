package com.tomholmes.opensource.phonebook.service;


import com.tomholmes.opensource.phonebook.dto.CompanyDTO;
import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class CompanyServiceImplTest
{
    @Inject
    private CompanyService service;

    // CREATE ==================================================================================

    @Test
    @TestTransaction
    // CompanyEntity add(CompanyEntity newCompany);
    public void testAdd()
    {
        long id = 0;
        Boolean active = true;
        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);
        companyEntity.setActive(active);

        CompanyEntity newCompany = service.add(companyEntity);
        assertNotNull(newCompany);
        assertEquals(true, newCompany.getCompanyId() > 1);
        assertNotEquals(0, newCompany.getCompanyId());
        assertEquals(city, newCompany.getCity());
    }

    @Test
    @TestTransaction
    // CompanyEntity ceateNewCompany(CompanyEntity company);
    public void testCeateNewCompany()
    {
        long id = 0;
        Boolean active = true;
        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);
        companyEntity.setActive(active);

        CompanyEntity newCompany = service.add(companyEntity);
        assertNotNull(newCompany);
        assertEquals(true, newCompany.getCompanyId() > 1);
        assertNotEquals(0, newCompany.getCompanyId());
        assertEquals(city, newCompany.getCity());
        assertEquals(active, newCompany.getActive());
    }

    // RETRIEVE ================================================================================

    @Test
    @TestTransaction
    // CompanyEntity testGetCompanyById(long contactId);
    public void getCompanyById()
    {
        long companyId = 1;
        CompanyEntity entity = service.findById(companyId);
        assertNotNull(entity);
        assertEquals(companyId, entity.getCompanyId());
    }

    @Test
    @TestTransaction
    // CompanyEntity findById(long companyId);
    public void testFindById()
    {
        long companyId = 1;
        CompanyEntity entity = service.findById(companyId);
        assertNotNull(entity);
        assertEquals(companyId, entity.getCompanyId());
    }

    @Test
    @TestTransaction
    // List<CompanyEntity> findAllCompanies();
    public void findAllCompanies()
    {
        List<CompanyEntity> companyEntityList = service.findAllCompanies();
        assertNotNull(companyEntityList);
        assertEquals(true, companyEntityList.size() >= 1);
    }

    @Test
    @TestTransaction
    // List<CompanyDTO> getAllCompanys();
    public void testGetAllCompanys()
    {
        List<CompanyDTO> companyDtoList = service.getAllCompanys();
        assertNotNull(companyDtoList);
        assertEquals(true, companyDtoList.size() >= 1);
    }

    // UPDATE ==================================================================================

    @Test
    @TestTransaction
    // CompanyEntity update(CompanyEntity oldCompany);
    public void testUpdate()
    {
        long companyId = 1;
        CompanyEntity companyEntity = service.findById(companyId);
        assertNotNull(companyEntity);
        assertEquals(companyId, companyEntity.getCompanyId());

        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);

        CompanyEntity company = service.update(companyEntity);
        assertNotNull(company);
        assertEquals(1L, company.getCompanyId());
        assertEquals(city, company.getCity());
    }

    @Test
    @TestTransaction
    // CompanyEntity save(CompanyEntity companyEntity);
    public void testSave()
    {
        long companyId = 1;
        CompanyEntity companyEntity = service.findById(companyId);
        assertNotNull(companyEntity);
        assertEquals(companyId, companyEntity.getCompanyId());

        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);

        CompanyEntity company = service.update(companyEntity);
        assertNotNull(company);
        assertEquals(1L, company.getCompanyId());
        assertEquals(city, company.getCity());
    }

    // DELETED =================================================================================

    @Test
    @TestTransaction
    // void remove(long contactId);
    public void testRemove()
    {
        long companyId = 1;
        service.remove(companyId);
        CompanyEntity companyEntity = service.findById(companyId);
        assertNull(companyEntity);
    }

    @Test
    @TestTransaction
    // void deleteById(long companyId);
    public void testDeleteById()
    {
        long companyId = 1;
        service.deleteById(companyId);
        CompanyEntity companyEntity = service.findById(companyId);
        assertNull(companyEntity);
    }

}
