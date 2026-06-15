package com.tomholmes.opensource.phonebook.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ContactDataResponseDTO implements Serializable
{
    List<ContactEmailDTO> emailList;
    List<ContactPhoneDTO> phoneList;
    List<ContactLinkDTO> linkList;

    public List<ContactEmailDTO> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<ContactEmailDTO> emailList) {
        this.emailList = emailList;
    }

    public List<ContactPhoneDTO> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<ContactPhoneDTO> phoneList) {
        this.phoneList = phoneList;
    }

    public List<ContactLinkDTO> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<ContactLinkDTO> linkList) {
        this.linkList = linkList;
    }
}
