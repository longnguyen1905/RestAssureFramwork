package practice.day7;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Authentications {

    @Test(priority = 1)
    void testBasicAuthentication(){
        given()
                .auth().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    @Test(priority = 2)
    void testDigestAuthentication(){
        given()
                .auth().digest("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    @Test(priority = 3)
    void testPreemptiveAuthentication(){
        given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

    @Test(priority = 4)
    void testBearerTokenAuthentication(){
        String bearerToken = "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";
        given()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get("https://api.github.com/users/repos")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 5)
    void testOAuth1Authentication(){
        given()
                .auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")
                .when()
                .get("url")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 6)
    void testOAuth2Authentication(){
        given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/users")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 7)
    void testAPIKeyAuthentication(){
//        given()
//                .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c") //appid is API key
//                .when()
//                .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
//                .then()
//                .statusCode(200)
//                .log().all();

        given()
                .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
                .pathParam("myPath", "data/2.5/forecast/daily")
                .queryParam("q", "Delhi")
                .queryParam("units", "metric")
                .queryParam("cnt", "7")
                .when()
                .get("https://api.openweathermap.org/{myPath}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
