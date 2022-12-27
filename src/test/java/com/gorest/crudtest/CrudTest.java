package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CrudTest extends TestBase {

 @Test
 public void verifyUserCreatedSuccessfully() {

     UserPojo userPojo = new UserPojo();
     userPojo.setName("Albcd");
     userPojo.setEmail("viral"+getRandomValue()+"@gmail.com");
     userPojo.setGender("female");
     userPojo.setStatus("active");
     Response response = given()
             .header("Content-Type", "application/json")
             .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
             .when()
             .body(userPojo)
             .post("");
     response.then().statusCode(201);
     response.prettyPrint();
 }

    @Test

    public void verifyUserUpdatedSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("ed");
        userPojo.setEmail("Rgg345ghh6555@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .body(userPojo)
                .pathParam("id","11605")
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getAllCustomerInfo() {
        Response response = given()
                .when()
                .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .pathParam("id","11526")
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }

}
