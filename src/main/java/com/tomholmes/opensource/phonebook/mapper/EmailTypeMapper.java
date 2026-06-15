package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.EmailTypeDTO;
import com.tomholmes.opensource.phonebook.model.EmailTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface EmailTypeMapper {
    EmailTypeEntity dtoToEntity(EmailTypeDTO source);
    EmailTypeDTO entityToDTO(EmailTypeEntity destination);
}