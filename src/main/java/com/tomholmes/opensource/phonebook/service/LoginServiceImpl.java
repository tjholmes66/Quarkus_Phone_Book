package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.dto.LoginDTO;
import com.tomholmes.opensource.phonebook.model.UserEntity;
import com.tomholmes.opensource.phonebook.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LoginServiceImpl implements LoginService
{
    @Inject
    private UserRepository userDao;

    @Override
    @Transactional
    public UserEntity login(String username, String password)
    {
        List<UserEntity> userEntitys = userDao.findUserByUsernameAndPassword(username, password);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity login(LoginDTO loginDto)
    {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        List<UserEntity> userEntitys = userDao.findUserByUsernameAndPassword(username, password);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity loginByEmail(String email)
    {
        List<UserEntity> userEntitys = userDao.findUserByEmail(email);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    @Transactional
    public UserEntity loginByUsername(String username)
    {
        List<UserEntity> userEntitys = userDao.findUserByUsername(username);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

}