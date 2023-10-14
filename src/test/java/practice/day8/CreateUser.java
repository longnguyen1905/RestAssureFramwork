package practice.day8;
import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateUser {

    @Test
    void testCreateUser(ITestContext context){
        Faker faker = new Faker();
        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("gender", "Male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "inactive");

        String bearerToken = "f0d81fb310bab363b581af72da3d1e2528d1265bef816291490811bfabece65d";

        int id = given()
                .header("Authorization","Bearer " + bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");

        System.out.println("General id is: " + id);
        context.setAttribute("userId", id);
    }
}
