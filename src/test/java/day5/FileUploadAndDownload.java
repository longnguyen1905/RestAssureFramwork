package day5;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class FileUploadAndDownload {

    @Test
    void singleFileUpload(){
        File myfile = new File("C:\\Users\\LongLaptop\\IdeaProjects\\RestAssuredTraning\\upload file.txt");
        given()
                .multiPart("file", myfile)
                .contentType("multipart/form-data")
                .when()
                .post("https://the-internet.herokuapp.com/upload")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void fileDownload(){

        given()

                .when()
                .get("https://the-internet.herokuapp.com/download/SQL Notes.txt")
                .then()
                .statusCode(200)
                .log().all();
    }
}
