package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.endpoints.Routes.*;
import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response createUser(User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(postUrl);
        return response;
    }

    public static Response readUser(String userName){
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(getUrl);
        return response;
    }

    public static Response updateUser(User payload, String userName){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(putUrl);
        return response;
    }
    public static Response deleteUser(String userName){
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(deleteUrl);
        return response;
    }
}
