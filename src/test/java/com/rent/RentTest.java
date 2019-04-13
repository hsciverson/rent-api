package com.rent;

import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class RentTest extends ApiTestBase {
    @Test
    public void one_plus_one_equls_two() {
        given()
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .get("/apartments")
                .then()
                .statusCode(200)
                .body("$", hasSize(1))
                .body("address", hasItem("Nan Jing Road"));
    }
}
