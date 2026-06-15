package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactEmailDTO;
import com.tomholmes.opensource.phonebook.model.ContactEmailEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface ContactEmailListMapper {

    List<ContactEmailDTO> entityListToDtoList(List<ContactEmailEntity> contactEmailEntityList);
    List<ContactEmailEntity> dtoListToEntityList(List<ContactEmailDTO> contactEmailDtoList);

}
