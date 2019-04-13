package com.rent;

import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void add_new_apartment() {
        Map<String, Object> apartment = new HashMap<>();
        apartment.put("id", "11");
        apartment.put("address", "Xian Road");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(apartment)
                .when()
                .post("/apartments")
                .then()
                .statusCode(201)
                .body("id", is("11"))
                .body("address", is("Xian Road"));
    }
}
