package day2;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
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

    @Test
    void testPostUsingHashMap(){
        HashMap<String, String> data = new HashMap<>();
        data.put("Name", "Scott");
        data.put("Color", "black");
        data.put("Class", "3");
}

}
