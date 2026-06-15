package com.tomholmes.opensource.phonebook.repository;

import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ContactPhoneRepository implements PanacheRepository<ContactPhoneEntity>
{

    public List<ContactPhoneEntity> findByContact(ContactEntity contact) {
        return find("contact", contact).list();
    }

    public List<ContactPhoneEntity> findByContactContactId(Long contactId) {
        return find("contact.contactId", contactId).list();
    }
}
