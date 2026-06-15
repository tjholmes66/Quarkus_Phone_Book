package com.tomholmes.opensource.phonebook.service;

import com.tomholmes.opensource.phonebook.dto.CompanyDTO;
import com.tomholmes.opensource.phonebook.mapper.CompanyListMapper;
import com.tomholmes.opensource.phonebook.mapper.CompanyMapper;
import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import com.tomholmes.opensource.phonebook.repository.CompanyRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CompanyServiceImpl implements CompanyService
{
    private CompanyRepository companyRepo;
    private CompanyMapper companyMapper;
    private CompanyListMapper companyListMapper;

    public CompanyServiceImpl(CompanyRepository companyRepo, CompanyMapper companyMapper, CompanyListMapper companyListMapper)
    {
        this.companyRepo = companyRepo;
        this.companyMapper = companyMapper;
        this.companyListMapper = companyListMapper;
    }

    // CREATE ==============================================================================

    @Override
    @Transactional
    public CompanyEntity ceateNewCompany(CompanyEntity company)
    {
        companyRepo.persist(company);
        return company;
    }

    @Override
    @Transactional
    public CompanyEntity add(CompanyEntity company)
    {
        companyRepo.persist(company);
        return company;
    }

    // RETRIEVE ============================================================================

    @Override
    @Transactional
    public CompanyEntity findById(long companyId)
    {
        CompanyEntity companyEntity = companyRepo.findById(companyId);
        return companyEntity;
    }

    @Override
    @Transactional
    public CompanyDTO findDtoById(long companyId)
    {
        CompanyEntity companyEntity = companyRepo.findById(companyId);
        CompanyDTO companyDto = companyMapper.entityToDTO(companyEntity);
        return companyDto;
    }

    @Override
    @Transactional
    public List<CompanyEntity> findAllCompanies()
    {
        return companyRepo.findAll().list();
    }

    @Override
    @Transactional
    public List<CompanyDTO> getAllCompanys()
    {
        List<CompanyEntity> companyEntityList = companyRepo.findAll().list();
        List<CompanyDTO> companyDtoList = companyListMapper.entityListToDtoList(companyEntityList);
        return companyDtoList;
    }

    @Override
    @Transactional
    public CompanyEntity getCompanyById(long companyId)
    {
        CompanyEntity companyEntity = companyRepo.findById(companyId);
        return companyEntity;
    }

    // UPDATE ==============================================================================

    @Override
    @Transactional
    public CompanyEntity save(CompanyEntity companyEntity)
    {
        companyRepo.persistAndFlush(companyEntity);
        return companyEntity;
    }

    @Override
    @Transactional
    public CompanyEntity update(CompanyEntity companyEntity)
    {
        companyRepo.persistAndFlush(companyEntity);
        return companyEntity;
    }

    // DELETE ==============================================================================

    @Override
    @Transactional
    public void deleteById(long companyId)
    {
        companyRepo.deleteById(companyId);
    }

    @Override
    @Transactional
    public void remove(long companyId)
    {
        companyRepo.deleteById(companyId);
    }

}
