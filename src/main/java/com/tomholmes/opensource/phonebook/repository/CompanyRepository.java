package com.tomholmes.opensource.phonebook.repository;

import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<CompanyEntity>
{
    public CompanyEntity findByCompanyId(long companyId) {
        return find("companyId", companyId).firstResult();
    }

    public List<CompanyEntity> findByCompanyCode(String companyCode) {
        return find("companyCode", companyCode).list();
    }

    public CompanyEntity create(CompanyEntity entity) {
        persistAndFlush(entity);
        return entity;
    }
}
