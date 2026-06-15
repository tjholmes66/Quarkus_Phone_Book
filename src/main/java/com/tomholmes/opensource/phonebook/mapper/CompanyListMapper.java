package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.CompanyDTO;
import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface CompanyListMapper {

    List<CompanyDTO> entityListToDtoList(List<CompanyEntity> CompanyEntityList);
    List<CompanyEntity> dtoListToEntityList(List<CompanyDTO> CompanyDtoList);

}
