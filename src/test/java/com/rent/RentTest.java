package com.rent;

import org.junit.Test;
import org.junit.runners.Parameterized;

import javax.ws.rs.core.MediaType;

import java.util.Collection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RentTest extends ApiTestBase {
    @Test
    public void one_plus_one_equls_two() {
        given()
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .get("/apartments")
                .then()
                .statusCode(200)
                .body("$", hasSize(10))
                .body("address", hasItem("Nan Jing Road1"));
    }

    @Test
    public void get_apartment_info() {
        given()
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .get("/apartments/1")
                .then()
                .statusCode(200)
                .body("address", is("Nan Jing Road1"));

        given()
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .get("/apartments/5")
                .then()
                .statusCode(200)
                .body("address", is("Nan Jing Road5"));
    }
}
