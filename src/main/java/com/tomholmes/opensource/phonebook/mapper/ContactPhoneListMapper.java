package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.ContactPhoneDTO;
import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface ContactPhoneListMapper {
    
    List<ContactPhoneDTO> entityListToDtoList(List<ContactPhoneEntity> contactPhoneEntityList);
    List<ContactPhoneEntity> dtoListToEntityList(List<ContactPhoneDTO> contactPhoneDtoList);
        
}
