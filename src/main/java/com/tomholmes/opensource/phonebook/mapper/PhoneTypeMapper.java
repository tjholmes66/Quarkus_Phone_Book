package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.PhoneTypeDTO;
import com.tomholmes.opensource.phonebook.model.PhoneTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface PhoneTypeMapper {
    PhoneTypeEntity dtoToEntity(PhoneTypeDTO source);
    PhoneTypeDTO entityToDTO(PhoneTypeEntity destination);
}
