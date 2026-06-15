package com.tomholmes.opensource.phonebook.mapper;


import com.tomholmes.opensource.phonebook.dto.CompanyDTO;
import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface CompanyMapper {
    CompanyEntity dtoToEntity(CompanyDTO source);
    CompanyDTO entityToDTO(CompanyEntity destination);
}
