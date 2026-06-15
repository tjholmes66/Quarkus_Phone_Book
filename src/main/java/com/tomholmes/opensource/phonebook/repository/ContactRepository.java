package com.tomholmes.opensource.phonebook.repository;

import java.util.List;

import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.model.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContactRepository implements PanacheRepository<ContactEntity>
{

    public List<ContactEntity> findByUser(UserEntity user) {
        return find("user", user).list();
    }

    public List<ContactEntity> findByUserUserId(Long userId) {
        return find("user.userId", userId).list();
    }

}
