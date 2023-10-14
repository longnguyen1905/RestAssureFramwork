package practice.day5;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ParsingXMLResponse {

//    @Test
//    void testXMLResponse(){
//        given()
//                .when()
//                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
//                .then()
//                .statusCode(200)
//                .header("Content-Type", "application/xml; charset=utf-8")
//                .body("TravelerinformationResponse.page", equalTo("1"))
//                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
//    }

//    @Test
//    void testXMLRespons2(){
//        Response response = given().get("http://restapi.adequateshop.com/api/Traveler?page=1");
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.header("Content-Type"), "application/xml; charset=utf-8");
//
//        String pageNumber = response.xmlPath().get("TravelerinformationResponse.page").toString();
//        Assert.assertEquals(pageNumber, "1");
//
//        String travelerName = response.xmlPath().get("" +
//                "TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
//        Assert.assertEquals(travelerName, "Developer");
//    }

    @Test
    void testXMLResponsBody(){
        Response response = given().get("http://restapi.adequateshop.com/api/Traveler?page=1");

        XmlPath xmlPath = new XmlPath(response.asString());
        List<String> travelers = xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
        Assert.assertEquals(travelers.size(), 10);

        List<String> travelerNames = xmlPath.getList("TravelerinformationResponse.travelers." +
                "Travelerinformation.name");
        boolean status = false;
        for (String travelerName: travelerNames){
            if (travelerName.equals("Developer")){
                status = true;
                break;
            }
        }
        Assert.assertTrue(status);
    }
}
