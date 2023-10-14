package practice.day3;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class HeadersDemo {

    @Test(priority = 1)
    void testHeader(){
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("Server", "gws")
                .and()
                .contentType("text/html; charset=ISO-8859-1");

    }

    @Test(priority = 2)
    void getHeaders(){
        Response response = given().get("https://www.google.com/");
        String headerContentType = response.header("Content-Type");

        System.out.println("The value of content-type is: " + headerContentType);

        Headers myHeaders = response.getHeaders();
        for (Header header: myHeaders){
            System.out.println(header.getName() + ": " + header.getValue());
        }

    }
}
