package com.tomholmes.opensource.phonebook.rest;

import com.tomholmes.opensource.phonebook.model.ContactEmailEntity;
import com.tomholmes.opensource.phonebook.service.ContactEmailService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/rest/contact/email")
public class RestContactEmailController
{
    private ContactEmailService contactEmailService;

    public RestContactEmailController(ContactEmailService contactEmailService)
    {
        this.contactEmailService = contactEmailService;
    }

    @GET
    @Path(value = "/contactId/{contactId}")
    public List<ContactEmailEntity> getContactEmailListByContactId(@PathParam("contactId") long contactId)
    {
        List<ContactEmailEntity> contactEntityList = contactEmailService.getAllEmailsByContactId(contactId);
        return contactEntityList;
    }

    @POST
    @Path(value = "/create")
    public ContactEmailEntity createContactEmailEntity(ContactEmailEntity contactEmailEntity)
    {
        System.out.println("RestContactEmailController: createContactEmailEntity: contactEmailEntity=" + contactEmailEntity);
        ContactEmailEntity entity = contactEmailService.createContactEmail(contactEmailEntity);
        return entity;
    }

    @DELETE
    @Path(value = "/delete/{contactEmailId}")
    public void deleteContactEmailEntity(@PathParam("contactEmailId") long contactEmailId)
    {
        System.out.println("RestContactEmailController: START: deleteContactEmailEntity: contactEmailId=" + contactEmailId);
        contactEmailService.deleteContactEmailById(contactEmailId);
        System.out.println("RestContactEmailController: FINISH: deleteContactEmailEntity:");
    }
}
