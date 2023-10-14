package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.endpoints.UserEndPoints.*;

public class DDTests {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userId, String userName, String firstName, String lastName, String email, String password, String phone){
        User userPayload = new User();
        userPayload.setId((int) Double.parseDouble(userId));
        userPayload.setUsername(userName);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = createUser(userPayload);
        response.then().log().all().statusCode(200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testReadUser(String userName){
        Response response = readUser(userName);
        response.then().log().body().statusCode(200);
    }

    @Test(priority = 2, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testUpdateUser(String userId, String userName, String firstName, String lastName, String email, String password, String phone){
        User userPayload = new User();
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);

        Response response = updateUser(userPayload, userName);
        response.then().log().body().statusCode(200);
    }

    @Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName){
        Response response = deleteUser(userName);
        response.then().log().body().statusCode(200);
    }
}
