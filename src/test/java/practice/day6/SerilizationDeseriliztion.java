package practice.day6;

import org.testng.annotations.Test;

//POJO   ----------> Json object
public class SerilizationDeseriliztion {


    @Test
    void convertPojo2Json(){
        Student StudentPojo = new Student();

        StudentPojo.setName("Scott");
        StudentPojo.setLocation("France");
        StudentPojo.setPhone("999999999");
        String courseArr[] = {"C", "C++"};
        StudentPojo.setCourses(courseArr);
    }
}
