package practice.day1;


import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
* give()
*   content type, set cookies, add auth, add param, set headers info etc...
*
* when()
*   get, post, put, delete
*
* then()
*   validate status code, extract response, extract headers cookies & response body ...
*
* */

public class HTTPRequests {
    int id;

    @Test(priority = 1)
    public void getUsers(){
        given()

                .when()
                    .get("https://reqres.in/api/users?page=2")

                .then()
                    .statusCode(200)
                    .body("page", equalTo(2))
                    .log().all();

    }

    @Test(priority = 2)
    void createUser(){
        HashMap<String , String> data = new HashMap<>();
            data.put("name", "pavan");
            data.put("job", "trainer");

        id = given()
                .contentType("application/json")
                .body(data)

                .when()
                    .post("https://reqres.in/api/users/" )
                    .jsonPath().getInt("id");

//                .then()
//                    .statusCode(201)
//                    .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser(){
        HashMap<String , String> data = new HashMap<>();
        data.put("name", "john");
        data.put("job", "teacher");

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .put("https://reqres.in/api/users/" +id)

                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test(priority = 4)
    void deleteUser(){
        given()

                .when()
                .delete("https://reqres.in/api/users/" +id)

                .then()
                .statusCode(204)
                .log().all();
    }

    @Test()
    public void createEmail(){
        given()

                .when()
                .get(" https://getnada.cc/api/email/test123@getnede.com/GwNvKEofrdyS7JTXCzHQ")

                .then()
                .statusCode(200)
//                .body("page", equalTo(2))
                .log().all();

    }
    @Test()
    void getEmail(){
        given()

                .when()
                .get(" https://getnada.cc/api/messages/test123@getnede.com/GwNvKEofrdyS7JTXCzHQ")

                .then()
                .statusCode(200)
//                .body("page", equalTo(2))
                .log().all();
    }

}
