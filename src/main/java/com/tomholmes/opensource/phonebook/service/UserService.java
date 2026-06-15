package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.UserEntity;

import java.util.List;

public interface UserService
{

    // CREATE ==============================================================

    UserEntity add(UserEntity userEntity);

    // RETRIEVE ============================================================

    public List<UserEntity> getAllUsers();

    UserEntity getUserById(long userId);

    // UPDATE ==============================================================

    UserEntity update(UserEntity userEntity);

    // DELETE ==============================================================

    void remove(UserEntity record);

    void remove(long userId);
}
