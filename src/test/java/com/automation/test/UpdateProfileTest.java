package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest extends BaseTest {

    @Test
    public void updateProfile(){
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
        profilePage.clickOnUploadBtn(ConfigReader.getConfigValue("cat.profileImg"));
        profilePage.enterUpdateName(ConfigReader.getConfigValue("updated.name"));
        profilePage.enterUpdateMsg(ConfigReader.getConfigValue("updated.msg"));
        profilePage.clickOnSaveChangesButton();
        Assert.assertTrue(profilePage.isChangesSaved());
    }
}
