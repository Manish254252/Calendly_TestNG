package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditContactTest extends BaseTest{

    @Test
    public void editContact(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        contactPage.clickOnContactSection();
        contactPage.editSpecifiedContact(ConfigReader.getConfigValue("contact.firstname"), ConfigReader.getConfigValue("edit.firstname"),ConfigReader.getConfigValue("contact.phoneNo"), ConfigReader.getConfigValue("edit.phoneNo"),ConfigReader.getConfigValue("contact.email"));
        contactPage.clickOnSaveContactBtn();
        Assert.assertFalse(contactPage.isContactPresent(ConfigReader.getConfigValue("edit.firstname"),ConfigReader.getConfigValue("contact.email")),"contact does not exists");
    }

}
