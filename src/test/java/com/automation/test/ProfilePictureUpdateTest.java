package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePictureUpdateTest extends BaseTest{

    @Test
    public void profilePictureUpdate(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.clickOnProfileIcon();
        homePage.clickOnProfileLink();
        Assert.assertTrue(profilePage.isProfilePageDisplayed());
        profilePage.clickOnUploadBtn(ConfigReader.getConfigValue("gorilla.profileImg"));
        Assert.assertTrue(profilePage.isProfileChanged());
        profilePage.clickOnSaveChangesButton();
        Assert.assertTrue(profilePage.isChangesSaved());
    }
}
