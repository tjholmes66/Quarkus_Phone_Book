package com.tomholmes.opensource.phonebook.rest;

import java.util.List;

import com.tomholmes.opensource.phonebook.model.CompanyEntity;
import com.tomholmes.opensource.phonebook.service.CompanyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(value = "/rest/companys")
public class RestCompanyController
{
    private CompanyService companyService;

    public RestCompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GET
    public List<CompanyEntity> getCompanyList1()
    {
        List<CompanyEntity> companyEntityList = companyService.findAllCompanies();
        return companyEntityList;
    }

    @GET
    @Path(value = "/companyId/{companyId}")
    public CompanyEntity getCompanyById(@PathParam("companyId") Long companyId)
    {
        CompanyEntity companyEntity = companyService.getCompanyById(companyId);
        System.out.println("CompanyController: retrieveCompany: companyEntity=" + companyEntity);
        return companyEntity;
    }

    @POST
    @Path(value = "/create")
    public CompanyEntity createCompany(CompanyEntity company)
    {
        System.out.println("CompanyController: createCompany: company=" + company);
        CompanyEntity companyEntity = companyService.add(company);
        return companyEntity;
    }

    @PUT
    @Path(value = "/update")
    public CompanyEntity updateCompany(CompanyEntity company)
    {
        System.out.println("CompanyController: START: updateCompany: company=" + company);
        CompanyEntity companyEntity = companyService.update(company);
        System.out.println("CompanyController: FINISH: updateCompany: companyEntity=" + companyEntity);
        return companyEntity;
    }

    @DELETE
    @Path(value = "/delete/{companyId}")
    public void deleteCompany(@PathParam("companyId") long companyId)
    {
        System.out.println("CompanyController: START: deleteCompany: companyId=" + companyId);
        companyService.deleteById(companyId);
        System.out.println("CompanyController: FINISH: deleteCompany:");
    }
}
