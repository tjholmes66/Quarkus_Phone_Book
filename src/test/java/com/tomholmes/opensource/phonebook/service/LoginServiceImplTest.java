package com.tomholmes.opensource.phonebook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.tomholmes.opensource.phonebook.dto.LoginDTO;
import com.tomholmes.opensource.phonebook.model.UserEntity;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class LoginServiceImplTest
{
    @Inject
    private LoginService service;

    @Test
    @TestTransaction
    public void testFetchByLogin() throws Exception
    {
        String username = "demo";
        String password = "demo";
        // ==================================================
        UserEntity user = service.login(username, password);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    @TestTransaction
    public void testFetchByLoginByDto() throws Exception
    {
        String username = "demo";
        String password = "demo";
        LoginDTO loginDto = new LoginDTO();
        loginDto.setUsername(username);
        loginDto.setPassword(password);
        // ==================================================
        UserEntity user = service.login(loginDto);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    @TestTransaction
    public void testFetchByEmail() throws Exception
    {
        String email = "tom@tomholmes.net";
        // ==================================================
        UserEntity user = service.loginByEmail(email);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    @TestTransaction
    public void testFetchByUsername() throws Exception
    {
        String username = "demo";
        // ==================================================
        UserEntity user = service.loginByUsername(username);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }
}
