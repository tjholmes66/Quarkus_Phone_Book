package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.dto.CompanyDTO;
import com.tomholmes.opensource.phonebook.model.CompanyEntity;

import java.util.List;


public interface CompanyService
{

    List<CompanyDTO> getAllCompanys();

    CompanyEntity getCompanyById(long contactId);

    CompanyEntity add(CompanyEntity newCompany);

    CompanyEntity update(CompanyEntity newCompany);

    void remove(long contactId);

    void deleteById(long companyId);

    CompanyEntity ceateNewCompany(CompanyEntity company);

    CompanyEntity findById(long companyId);

    CompanyDTO findDtoById(long companyId);

    List<CompanyEntity> findAllCompanies();

    CompanyEntity save(CompanyEntity companyEntity);

}
