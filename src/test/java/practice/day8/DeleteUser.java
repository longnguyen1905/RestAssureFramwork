package practice.day8;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteUser {

    @Test
    void testDeleteUser(ITestContext context){
        String bearerToken = "f0d81fb310bab363b581af72da3d1e2528d1265bef816291490811bfabece65d";
        int id = (int) context.getAttribute("userId");

        given()
                .header("Authorization" , "Bearer " + bearerToken)
                .pathParam("id" , id)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(204)
                .log().all();
    }
}
