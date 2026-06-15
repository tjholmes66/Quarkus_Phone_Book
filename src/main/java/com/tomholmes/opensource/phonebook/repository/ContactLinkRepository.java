package com.tomholmes.opensource.phonebook.repository;

import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ContactLinkRepository implements PanacheRepository<ContactLinkEntity>
{

    public List<ContactLinkEntity> findByContact(ContactEntity contact) {
        return find("contact", contact).list();
    }

    public List<ContactLinkEntity> findByContactContactId(Long contactId) {
        return find("contact.contactId", contactId).list();
    }
}

