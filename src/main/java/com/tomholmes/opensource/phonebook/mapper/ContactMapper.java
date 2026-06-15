package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactDTO;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface ContactMapper {
    ContactEntity dtoToEntity(ContactDTO source);
    ContactDTO entityToDTO(ContactEntity destination);
}
