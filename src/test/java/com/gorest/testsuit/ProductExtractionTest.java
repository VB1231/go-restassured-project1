package com.gorest.testsuit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIT() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "25")
                .get("/posts")
                .then().statusCode(200);

    }
    //Extract the title
    @Test
    public void test001(){
        List<?> allTitle=  response.extract().path("title");
        System.out.println("The value of limit "+ allTitle);

    }
    //Extract the total number of record
    @Test
    public void test002(){
        int allTotal=  response.extract().path("title.size");
        System.out.println("The value of limit "+ allTotal);
    }
    //Extract the body of 15
    //th
    //record
    @Test
    public void test003(){
      String allData=  response.extract().path("[14].body");
        System.out.println("The value of limit "+ allData);

    }
    //Extract the user_id of all the records
    @Test
    public void test004(){
        List<?>allUserID=response.extract().path("user_id");
        System.out.println("All user id"+allUserID);
    }
    //Extract the title of all the records
    @Test
    public void test005(){
        List<?>allUserTitle=response.extract().path("title");
        System.out.println("All user title"+allUserTitle);
    }
    //Extract the title of all records whose user_id = 5456
    @Test
    public void test006(){
        List<?>titleAllRecord = response.extract().path("findAll{it.user_id==5559}.title");
        System.out.println("List of title"+titleAllRecord);
    }
    //Extract the body of all records whose id = 2671
    @Test
    public void test007(){
        List<?>titleAllBody = response.extract().path("findAll{it.id=2730}.body");
        System.out.println("List of title"+titleAllBody);
    }

}
