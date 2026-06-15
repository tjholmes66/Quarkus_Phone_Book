package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactLinkDTO;
import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface ContactLinkListMapper {

    List<ContactLinkDTO> entityListToDtoList(List<ContactLinkEntity> contactLinkEntityList);
    List<ContactLinkEntity> dtoListToEntityList(List<ContactLinkDTO> contactLinkDtoList);

}
