package day3;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class CookiesDemo {

    @Test(priority = 1)
    void testCookies(){
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC", "")
                .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo(){
        Response response = given()

                .when()
                .get("https://www.google.com/");

             String cookie_value = response.getCookie("AEC");
        System.out.println("value of cookie is ==========> "+ cookie_value);
        Map<String, String> cookies_values = response.getCookies();

        System.out.println(cookies_values.keySet());
        for (String key : cookies_values.keySet()){
            System.out.println("Key: " + key + " ;value: " + cookies_values.get(key));
        }
    }

}
