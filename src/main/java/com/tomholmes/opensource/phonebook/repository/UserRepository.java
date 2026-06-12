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
    List<UserEntity> findUserByUsernameAndPassword(String username, String password) {
        return find("username = ?1 and password = ?2", username, password).list();
    }

    List<UserEntity> findUserByEmail(String email) {
        return find("email", email).list();
    }

    List<UserEntity> findUserByUsername(String username) {
        return find("username", username).list();
    }

}
