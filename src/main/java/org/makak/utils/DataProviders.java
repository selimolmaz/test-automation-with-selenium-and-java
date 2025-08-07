package org.makak.utils;

import org.testng.annotations.DataProvider;


import java.util.List;

public class DataProviders {
    private static final String sourcePath = System.getProperty("user.dir") + "/src/main/resources";

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {

        List<String[]> excelData = ExcelUtil.getData(sourcePath + "/loginData.xlsx", "sheet1");

        Object[][] data = new Object[excelData.size()][3];

        for (int i = 0; i < excelData.size(); i++) {
            data[i][0] = excelData.get(i)[0]; // username
            data[i][1] = excelData.get(i)[1]; // password
            data[i][2] = Boolean.parseBoolean(excelData.get(i)[2]); // shouldLogin
        }
        return data;
    }
}
