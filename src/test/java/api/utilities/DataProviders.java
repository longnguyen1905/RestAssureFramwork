package api.utilities;

import org.testng.annotations.DataProvider;
import petstore.helpers.ExcelHelpers;

public class DataProviders {
    private ExcelHelpers excelHelpers;


    @DataProvider(name = "Data")
    public Object[][] getAllData(){
        excelHelpers = new ExcelHelpers();
        Object[][] apidata = excelHelpers.getExcelData("src/test/resources/testdata/Userdata.xlsx", "User");
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public Object[] getUserNames(){
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/testdata/Userdata.xlsx", "User");
        int rowNum = excelHelpers.getLastRowNum();
        String apidata[] = new String[rowNum];
        for (int i = 0; i < rowNum; i++){
            apidata[i] = excelHelpers.getCellData("UserName", i + 1);
        }
        return apidata;
    }
}
