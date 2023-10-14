package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.endpoints.UserEndPoints.*;

public class UserTests {
    Faker faker;
    User userPayload;



    @BeforeClass
    public void setupData(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }
    @Test(priority = 1)
    public void testPostUser(){
        Response response = createUser(userPayload);
        response.then().log().all().statusCode(200);
    }
    @Test(priority = 2)
    public void testGetUserByName(){
        Response response = readUser(userPayload.getUsername());
        response.then().log().all().statusCode(200);
    }
    @Test(priority = 3)
    public void testUpdateUser(){
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = updateUser(userPayload, userPayload.getUsername());
        response.then().log().all().statusCode(200);
        Response responseAfterUpdate = readUser(userPayload.getUsername());
        responseAfterUpdate.then().statusCode(200);
    }
    @Test(priority = 4)
    public void testDeleteUser(){
        Response response = deleteUser(userPayload.getUsername());
        response.then().log().all().statusCode(200);
    }
}
