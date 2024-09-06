package com.automation.test;


import com.automation.pages.HomePage;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class BaseTest {


    HomePage homePage;



    @BeforeMethod
    public void setUp(ITestContext context) {


        ConfigReader.initConfig();
        DriverManager.createDriver();

        homePage = new HomePage();


    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.getDriver().quit();

    }

    public void takeScreenShot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        int a = random.nextInt(1000);
        String filePath = "src/test/resources" + "/screenshot"+a+".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.getProperty("user.dir");
    }
}
