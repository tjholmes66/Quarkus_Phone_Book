package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.PositionDTO;
import com.tomholmes.opensource.phonebook.model.PositionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface PositionMapper {
    PositionEntity dtoToEntity(PositionDTO source);
    PositionDTO entityToDTO(PositionEntity destination);
}
