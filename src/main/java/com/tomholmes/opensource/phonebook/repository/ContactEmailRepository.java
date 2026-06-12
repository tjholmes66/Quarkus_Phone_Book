package com.tomholmes.opensource.phonebook.repository;

import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import com.tomholmes.opensource.phonebook.model.ContactEmailEntity;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ContactEmailRepository implements PanacheRepository<ContactEmailEntity>
{

    List<ContactEmailEntity> findByContact(ContactEntity contact) {
        return find("contact", contact).list();
    }

    List<ContactEmailEntity> findByContactContactId(Long contactId) {
        return find("contact.contactId", contactId).list();
    }
}
