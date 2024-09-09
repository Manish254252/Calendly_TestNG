package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @Test(dataProvider = "invalid email")
    public void invalidLoginTest(String invalidEmail){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(invalidEmail);
        loginPage.clickOnLoginBtn();
        loginPage.clickOnContinue();
        Assert.assertTrue(loginPage.isNoSuchAccountDisplayed());
    }

    @DataProvider(name = "invalid email")
    public Object[] invalidEmails(){
        return new Object[]{
                "john.doe123@example.com ",
                "jane.smith456@testmail.com"
        };
    }
}
