package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteExistingEventTest extends BaseTest{

    @Test
    public void deleteExistingEventTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.deleteEventsOfName(ConfigReader.getConfigValue("delete.eventName"));
        Assert.assertTrue(homePage.isEventDeleted(ConfigReader.getConfigValue("delete.eventName")));
    }

}
