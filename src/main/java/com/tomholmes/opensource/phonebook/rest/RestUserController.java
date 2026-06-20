package com.tomholmes.opensource.phonebook.rest;

import com.tomholmes.opensource.phonebook.model.UserEntity;
import com.tomholmes.opensource.phonebook.service.UserService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/rest/users")
public class RestUserController
{
    private UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public List<UserEntity> getUserList1()
    {
        List<UserEntity> userEntityList = userService.getAllUsers();
        return userEntityList;
    }

    @GET
    @Path(value = "/userId/{userId}")
    public UserEntity getUserById(@PathParam("userId") long userId)
    {
        UserEntity userEntity = userService.getUserById(userId);
        System.out.println("UserController: retrieveUser: userEntity=" + userEntity);
        return userEntity;
    }

    @POST
    @Path(value = "/create")
    public UserEntity createUser(UserEntity user)
    {
        System.out.println("UserController: createUser: user=" + user);
        UserEntity userEntity = userService.add(user);
        return userEntity;
    }

    @PUT
    @Path(value = "/update")
    public UserEntity updateUser(UserEntity user)
    {
        System.out.println("UserController: START: updateUser: user=" + user);
        UserEntity userEntity = userService.update(user);
        System.out.println("UserController: FINISH: updateUser: userEntity=" + userEntity);
        return userEntity;
    }

    @DELETE
    @Path(value = "/delete/{userId}")
    public void deleteUser(@PathParam("userId") long userId)
    {
        System.out.println("UserController: START: deleteUser: userId=" + userId);
        userService.remove(userId);
        System.out.println("UserController: FINISH: deleteUser:");
    }
}
