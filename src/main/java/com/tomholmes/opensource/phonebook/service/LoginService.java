package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.dto.LoginDTO;
import com.tomholmes.opensource.phonebook.model.UserEntity;

public interface LoginService
{
    UserEntity login(String username, String password);

    UserEntity loginByEmail(String email);

    UserEntity loginByUsername(String username);

    UserEntity login(LoginDTO loginDto);
}
