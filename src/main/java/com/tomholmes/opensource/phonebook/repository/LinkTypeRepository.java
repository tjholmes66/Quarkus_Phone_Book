package com.tomholmes.opensource.phonebook.repository;

import com.tomholmes.opensource.phonebook.model.LinkTypeEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LinkTypeRepository implements PanacheRepository<LinkTypeEntity>
{

}