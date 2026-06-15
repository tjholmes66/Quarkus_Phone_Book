package com.tomholmes.opensource.phonebook.repository;

import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity>
{
    public List<UserEntity> findUserByUsernameAndPassword(String username, String password) {
        return find("username = ?1 and password = ?2", username, password).list();
    }

    public List<UserEntity> findUserByEmail(String email) {
        return find("email", email).list();
    }

    public List<UserEntity> findUserByUsername(String username) {
        return find("username", username).list();
    }

}
