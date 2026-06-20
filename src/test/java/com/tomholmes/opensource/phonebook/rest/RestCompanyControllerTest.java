package com.tomholmes.opensource.phonebook.rest;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(RestCompanyController.class)
public class RestCompanyControllerTest
{

    @Test
    @TestTransaction
    public void testMockGetUserList1() throws Exception
    {
        given()
                .when().get("")
                .then()
                .statusCode(200)
                .body("size()", is(4));
    }

}
