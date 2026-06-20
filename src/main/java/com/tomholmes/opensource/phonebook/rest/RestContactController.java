package com.tomholmes.opensource.phonebook.rest;

import com.tomholmes.opensource.phonebook.dto.ContactDTO;
import com.tomholmes.opensource.phonebook.dto.ContactDataResponseDTO;
import com.tomholmes.opensource.phonebook.model.ContactEntity;
import com.tomholmes.opensource.phonebook.service.ContactService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/rest/contacts")
public class RestContactController
{
    private ContactService contactService;

    public RestContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GET
    public List<ContactEntity> getContactList1()
    {
        List<ContactEntity> contactEntityList = contactService.getAllContacts();
        return contactEntityList;
    }

    @GET
    @Path(value = "/contactId/{contactId}")
    public ContactEntity getContactById(@PathParam("contactId") long contactId)
    {
        ContactEntity contactEntity = contactService.getContactById(contactId);
        System.out.println("ContactController: retrieveContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @GET
    @Path(value = "/data/{contactId}")
    public ContactDataResponseDTO getContactDataById(@PathParam("contactId") long contactId)
    {
        ContactDataResponseDTO contactDataResponseDTO = contactService.getContactDataById(contactId);
        System.out.println("ContactController: getContactDataById: contactEntity=" + contactDataResponseDTO);
        return contactDataResponseDTO;
    }

    @GET
    @Path(value = "/userId/{userId}")
    public List<ContactDTO> getContactsByUserId(@PathParam("userId") long userId)
    {
        List<ContactDTO> contactDTOList = contactService.getContactsByUserId(userId);
        return contactDTOList;
    }

    @POST
    @Path(value = "/create")
    public ContactEntity createContact(ContactEntity contact)
    {
        System.out.println("ContactController: createContact: contact=" + contact);
        ContactEntity contactEntity = contactService.add(contact);
        return contactEntity;
    }

    @PUT
    @Path(value = "/update")
    public ContactEntity updateContact(ContactEntity contact)
    {
        System.out.println("ContactController: START: updateContact: contact=" + contact);
        ContactEntity contactEntity = contactService.update(contact);
        System.out.println("ContactController: FINISH: updateContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @DELETE
    @Path(value = "/delete/{contactId}")
    public void deleteContact(@PathParam("contactId") long contactId)
    {
        System.out.println("ContactController: START: deleteContact: contactId=" + contactId);
        contactService.remove(contactId);
        System.out.println("ContactController: FINISH: deleteContact:");
    }

}
