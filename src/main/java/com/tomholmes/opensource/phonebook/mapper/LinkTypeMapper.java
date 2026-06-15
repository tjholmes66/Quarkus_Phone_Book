package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.LinkTypeDTO;
import com.tomholmes.opensource.phonebook.model.LinkTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface LinkTypeMapper {
    LinkTypeEntity dtoToEntity(LinkTypeDTO source);
    LinkTypeDTO entityToDTO(LinkTypeEntity destination);
}
