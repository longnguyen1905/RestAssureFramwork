package practice.day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
* Different ways to create Post request body
*
1. Hashmap
2. using org.json
3. using POJO (Plain Old Java Object)
4. using external json file
*
* */
public class WaysToCreatePostRequestBody {

//Post request body using Hashmap

    //@Test(priority = 1)
//    void testPostUsingHashMap(){
//        HashMap data = new HashMap();
//        //data.put("id", "Scott");
//        data.put("name", "Scott");
//        data.put("location", "France");
//        data.put("phone", "999999999");
//
//        String courseArr[] = {"C", "C++"};
//        data.put("courses", courseArr);
//
//        given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("name", equalTo("Scott"))
//                .body("location", equalTo("France"))
//                .body("phone", equalTo("999999999"))
//                .body("courses[0]", equalTo("C"))
//                .body("courses[1]", equalTo("C++"))
//                .header("Content-Type", "application/json; charset=utf-8")
//                .log().all();
//}


//    @Test(priority = 1)
//    void testPostUsingJsonLybary(){
//        JSONObject data = new JSONObject();
//        data.put("name", "Scott");
//        data.put("location", "France");
//        data.put("phone","999999999");
//        String coursesArr[] = {"C", "C++"};
//        data.put("courses", coursesArr);
//
//        given()
//                .contentType("application/json")
//                .body(data.toString())
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("name", equalTo("Scott"))
//                .body("location", equalTo("France"))
//                .body("phone", equalTo("999999999"))
//                .body("courses[0]", equalTo("C"))
//                .body("courses[1]", equalTo("C++"))
//                .header("Content-Type", "application/json; charset=utf-8")
//                .log().all();
//    }

//    @Test(priority = 1)
//    void testPostUsingPOJO(){
//
//        Pojo_PostRequest data = new Pojo_PostRequest();
//        data.setName("Scott");
//        data.setLocation("France");
//        data.setPhone("999999999");
//        String courseArr[] = {"C", "C++"};
//        data.setCourses(courseArr);
//
//        given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("name", equalTo("Scott"))
//                .body("location", equalTo("France"))
//                .body("phone", equalTo("999999999"))
//                .body("courses[0]", equalTo("C"))
//                .body("courses[1]", equalTo("C++"))
//                .header("Content-Type", "application/json; charset=utf-8")
//                .log().all();
//    }

    @Test(priority = 1)
    void testPostUsingExternalJsonFile() {
        File file = new File(".\\body.json");
        try {
            FileReader fr = new FileReader(file);
            JSONTokener jsonTokener = new JSONTokener(fr);
            JSONObject data = new JSONObject(jsonTokener);

            given()
                    .contentType("application/json")
                    .body(data.toString())
                    .when()
                    .post("http://localhost:3000/students")
                    .then()
                    .statusCode(201)
                    .body("name", equalTo("Scott"))
                    .body("location", equalTo("France"))
                    .body("phone", equalTo("999999999"))
                    .body("courses[0]", equalTo("C"))
                    .body("courses[1]", equalTo("C++"))
                    .header("Content-Type", "application/json; charset=utf-8")
                    .log().all();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

@Test(priority = 2)
void testDelete(){
        given()
                .when()
                .delete("http://localhost:3000/students/4")
                .then()
                .statusCode(200);
}

}
