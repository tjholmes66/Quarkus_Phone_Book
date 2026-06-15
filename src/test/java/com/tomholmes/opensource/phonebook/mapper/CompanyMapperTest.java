package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.CompanyDTO;
import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import com.tomholmes.opensource.phonebook.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class CompanyMapperTest
{
    @Inject
    private UserRepository userRepository; // repository

    @Inject
    private CompanyMapper companyMapper;
    
    private Long _companyId=  1L;
    private boolean _active = true;
    private String _companyCode = "ABC123";
    private String _companyName = "Test Company Name";
    private String _description = "Test Company Description";
    private String _address1 =  "test address 1";
    private String _address2 =  "test address 2";
    private String _city = "test city";
    private String _state = "MA";
    private String _zip = "12345-6789";

    @Test
    public void entity_To_DTO_whenMaps_thenCorrect() {
        CompanyEntity entity = new CompanyEntity();
        entity.setCompanyId(_companyId);
        entity.setAddress1(_address1);
        entity.setAddress2(_address2);
        entity.setActive(_active);
        entity.setCity(_city);
        entity.setCompanyCode(_companyCode);
        entity.setCompanyName(_companyName);
        entity.setDescription(_description);
        entity.setState(_state);
        entity.setZip(_zip);
        
        CompanyDTO companyDto = companyMapper.entityToDTO(entity);

        assertEquals(entity.getCity(), companyDto.getCity());
        assertEquals(entity.getCompanyName(), companyDto.getCompanyName());
    }

    @Test
    public void DTO_To_Entity_whenMaps_thenCorrect() {
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyId(_companyId);
        dto.setAddress1(_address1);
        dto.setAddress2(_address2);
        dto.setActive(_active);
        dto.setCity(_city);
        dto.setCompanyCode(_companyCode);
        dto.setCompanyName(_companyName);
        dto.setDescription(_description);
        dto.setState(_state);
        dto.setZip(_zip);

        CompanyEntity companyEntity = companyMapper.dtoToEntity(dto);

        assertEquals(dto.getCity(), companyEntity.getCity());
        assertEquals(dto.getCompanyName(), companyEntity.getCompanyName());
    }

}

