package api.test;

import org.testng.annotations.Test;
import petstore.helpers.ExcelHelpers;

import java.util.Arrays;

public class UserTests2 {

    @Test
    public void test(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/testdata/Userdata.xlsx", "User");
        int rowNum = excelHelpers.getPhysicalNumberOfRows();
        int rowNum2 = excelHelpers.getLastRowNum();
        System.out.println("number of rows: " + rowNum);
        System.out.println("number of rows2: " + rowNum2);
        Object[][] apidata = excelHelpers.getExcelData("src/test/resources/testdata/Userdata.xlsx", "User");


        for (int i = 0; i < rowNum -1 ; i++){
            System.out.println(Arrays.toString(apidata[i]));
        }

    }

    @Test
    public void test2(){
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/testdata/Userdata.xlsx", "User");
        int rowNum = excelHelpers.getLastRowNum();
        String apidata[] = new String[rowNum];
        for (int i = 0; i < rowNum; i++){
            apidata[i] = excelHelpers.getCellData("UserName", i +1);
        }
        System.out.println(Arrays.toString(apidata));;
    }
}
