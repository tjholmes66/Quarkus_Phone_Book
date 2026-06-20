package com.tomholmes.opensource.phonebook.rest;

import com.tomholmes.opensource.phonebook.model.ContactPhoneEntity;
import com.tomholmes.opensource.phonebook.service.ContactPhoneService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/rest/contact/phone")
public class RestContactPhoneController
{
    
    private ContactPhoneService contactPhoneService;

    public RestContactPhoneController(ContactPhoneService contactPhoneService)
    {
        this.contactPhoneService = contactPhoneService;
    }

    @GET
    @Path(value = "/contactId/{contactId}")
    public List<ContactPhoneEntity> getContactPhoneListByContactId(@PathParam("contactId") long contactId)
    {
        List<ContactPhoneEntity> contactEntityList = contactPhoneService.getAllPhonesByContactId(contactId);
        return contactEntityList;
    }

    @POST
    @Path(value = "/create")
    public ContactPhoneEntity createContactPhoneEntity(ContactPhoneEntity contactPhoneEntity)
    {
        System.out.println("RestContactPhoneController: createContactPhoneEntity: contactPhoneEntity=" + contactPhoneEntity);
        ContactPhoneEntity entity = contactPhoneService.createContactPhone(contactPhoneEntity);
        return entity;
    }

    @DELETE
    @Path(value = "/delete/{contactPhoneId}")
    public void deleteContactPhoneEntity(@PathParam("contactPhoneId") long contactPhoneId)
    {
        System.out.println("RestContactPhoneController: START: deleteContactPhoneEntity: contactPhoneId=" + contactPhoneId);
        contactPhoneService.deleteContactPhoneById(contactPhoneId);
        System.out.println("RestContactPhoneController: FINISH: deleteContactPhoneEntity:");
    }

}
