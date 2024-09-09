package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadContentTest extends BaseTest{

    @Test
    public void downloadContentTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.clickOnMeetingLink();
        Assert.assertTrue(meetingsPage.isMeetingsPageDisplayed());
        meetingsPage.clickOnExportBtn();
        Assert.assertTrue(meetingsPage.isFileDownloaded());
    }

}
