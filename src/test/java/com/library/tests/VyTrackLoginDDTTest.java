package com.library.tests;

import com.library.pages.VyTrackDashBoardPage;
import com.library.pages.VyTrackLoginPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.bs.A;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackLoginPage loginPage = new VyTrackDashBoardPage();
    VyTrackDashBoardPage dashBoardPage = new VyTrackDashBoardPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Before
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("track.site"));
    }

    @After
    public void teardown(){
        Driver.stopSession();
    }


    @Test
    public void login_ddt_testing_with_excel() throws IOException {

        String path= "VyTrackQa2Users.xlsx";

        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("data");


        for (int row = 1; row <= sheet.getLastRowNum(); row++) {

            String username = sheet.getRow(row).getCell(0).toString();
            String password = sheet.getRow(row).getCell(1).toString();
            String firstname = sheet.getRow(row).getCell(2).toString();
            String lastname = sheet.getRow(row).getCell(3).toString();

            loginPage.login(username, password);
            WebElement loadermask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loadermask));
            String actualfullname = dashBoardPage.userVisibility.getText();
            XSSFCell resultcell = sheet.getRow(row).getCell(4);

            if(actualfullname.contains(firstname) && actualfullname.contains(lastname)){
                //Assert.assertTrue(true);
                System.out.println("pass");
                resultcell.setCellValue("pass");
            }else{
                System.out.println("fail");
                resultcell.setCellValue("fail"+"Actual Full Name: "+ actualfullname);
            }

            dashBoardPage.logout();

        }


        FileOutputStream out = new FileOutputStream(path);
        workbook.write(out);

        file.close();
        workbook.close();
        out.close();





    }


}
