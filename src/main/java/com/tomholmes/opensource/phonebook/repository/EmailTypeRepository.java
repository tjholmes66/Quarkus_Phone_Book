package com.tomholmes.opensource.phonebook.repository;

import com.tomholmes.opensource.phonebook.model.EmailTypeEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailTypeRepository implements PanacheRepository<EmailTypeEntity>
{

}
