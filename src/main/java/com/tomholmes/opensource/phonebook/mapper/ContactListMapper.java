package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactDTO;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface ContactListMapper {

    List<ContactDTO> entityListToDtoList(List<ContactEntity> contactEntityList);
    List<ContactEntity> dtoListToEntityList(List<ContactDTO> contactDtoList);

}
