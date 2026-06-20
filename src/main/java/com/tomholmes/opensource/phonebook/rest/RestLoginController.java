package com.tomholmes.opensource.phonebook.rest;


import com.tomholmes.opensource.phonebook.dto.LoginDTO;
import com.tomholmes.opensource.phonebook.model.UserEntity;
import com.tomholmes.opensource.phonebook.service.LoginService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/rest/login")
public class RestLoginController
{

    private LoginService service;

    public RestLoginController(LoginService service)
    {
        this.service = service;
    }

    @POST
    public UserEntity login(LoginDTO loginDto)
    {
        System.out.println("RestLoginController: login: loginDto=" + loginDto);
        UserEntity userEntity = service.login(loginDto);
        System.out.println("RestLoginController: login: user=" + userEntity);
        return (userEntity == null ? new UserEntity() : userEntity);
    }

}
