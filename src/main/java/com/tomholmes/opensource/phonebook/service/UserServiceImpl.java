package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.model.UserEntity;
import com.tomholmes.opensource.phonebook.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@ApplicationScoped
public class UserServiceImpl implements UserService
{
    private UserRepository userDao;

    public UserServiceImpl(UserRepository userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> userList = (List<UserEntity>) userDao.findAll();
        return userList;
    }

    @Override
    public UserEntity getUserById(long userId)
    {
        UserEntity userEntity = userDao.findById(userId);
        return userEntity;
    }

    @Override
    public UserEntity add(UserEntity newUser)
    {
        userDao.persistAndFlush(newUser);
        return newUser;
    }

    @Override
    public void remove(UserEntity userEntity)
    {
        userDao.deleteById(userEntity.getUserId());
    }

    @Override
    public void remove(long userId)
    {
        userDao.deleteById(userId);
    }

    @Override
    public UserEntity update(UserEntity newUser)
    {
        userDao.persistAndFlush(newUser);
        return newUser;
    }
}
