package com.tomholmes.opensource.phonebook.mapper;

import com.tomholmes.opensource.phonebook.dto.UserDTO;
import com.tomholmes.opensource.phonebook.model.UserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface UserMapper {
    UserEntity dtoToEntity(UserDTO source);
    @BeanMapping(ignoreUnmappedSourceProperties = {"password", "securityAnswer1","securityAnswer2"})
    UserDTO entityToDTO(UserEntity destination);
}
