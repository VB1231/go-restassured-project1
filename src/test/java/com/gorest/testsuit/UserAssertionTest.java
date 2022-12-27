package com.gorest.testsuit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class UserAssertionTest {
   static ValidatableResponse response;

    @BeforeClass
    public static void inIT() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);

    }
    //Verify the if the total record is 20
    @Test
    public void test001(){
        response.body("total.size", equalTo(20));
    }
    //Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi”
    @Test
    public void test002(){
        response.body("[0].name",equalTo("Rameshwar Varman"));
    }
    //Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void test003(){
        response.body("name",hasItem("Rameshwar Varman"));
    }
    //Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan
    //Guha, Karthik Dubashi IV)
    @Test
    public void test004(){
        response.body("name",hasItems("Rameshwar Varman","Raj Patil"));
    }
    //Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005(){
        response.body("find{it.id == 5314}.email",equalTo("chandak_deshpande@hilpert.biz"));
    }
    //Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006(){
       response.body("find{it.name == 'Goswamee Tandon'}.status",equalTo("active"));
    }
    //Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007(){
        response.body("find{it.name == 'Nagabhushanam Johar'}.gender",equalTo("male"));

    }
}
