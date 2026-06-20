package com.tomholmes.opensource.phonebook.rest;

import com.tomholmes.opensource.phonebook.model.ContactLinkEntity;
import com.tomholmes.opensource.phonebook.service.ContactLinkService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/rest/contact/link")
public class RestContactLinkController
{
    private ContactLinkService contactLinkService;

    public RestContactLinkController(ContactLinkService contactLinkService)
    {
        this.contactLinkService = contactLinkService;
    }

    @GET
    @Path(value = "/contactId/{contactId}")
    public List<ContactLinkEntity> getContactLinkListByContactId(@PathParam("contactId") long contactId)
    {
        List<ContactLinkEntity> contactEntityList = contactLinkService.getAllLinksByContactId(contactId);
        return contactEntityList;
    }

    @POST
    @Path(value = "/create")
    public ContactLinkEntity createContactLinkEntity(ContactLinkEntity contactLinkEntity)
    {
        System.out.println("RestContactLinkController: createContactLinkEntity: contactLinkEntity=" + contactLinkEntity);
        ContactLinkEntity entity = contactLinkService.createContactLink(contactLinkEntity);
        return entity;
    }

    @DELETE
    @Path(value = "/delete/{contactLinkId}")
    public void deleteContactLinkEntity(@PathParam("contactLinkId") long contactLinkId)
    {
        System.out.println("RestContactLinkController: START: deleteContactLinkEntity: contactLinkId=" + contactLinkId);
        contactLinkService.deleteContactLinkById(contactLinkId);
        System.out.println("RestContactLinkController: FINISH: deleteContactLinkEntity:");
    }
}
