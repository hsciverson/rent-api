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
        apartment.put("address","非洲路");
        apartment.put("subDistrict","阳光沙滩小区");
        apartment.put("type","apartment");
                apartment.put("area","20.13");
                apartment.put("beds","2");
                apartment.put("halls","1");
                apartment.put("baths","1");
                apartment.put("price","2000");
//                apartment.put("createdAt","2019-04-13");
//                apartment.put("availableAt","2019-04-30");
                apartment.put("createdBy","中介007");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(apartment)
                .when()
                .post("/apartments")
                .then()
                .statusCode(201)
                .body("address", is("非洲路"));
    }
}
