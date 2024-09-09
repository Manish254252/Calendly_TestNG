package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContactTest extends BaseTest{

    @Test
    public void createContactTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        contactPage.clickOnContactSection();
        contactPage.clickOnAddToContactIcon();
        Assert.assertTrue(contactPage.isFirstNameDisplayed());
        contactPage.enterFirstName(ConfigReader.getConfigValue("contact.firstname"));
        contactPage.enterEmail("contact.email");
        contactPage.clickOnTimeZone();
        contactPage.enterTimeZone(ConfigReader.getConfigValue("contact.timezone"));
        contactPage.clickOnIndianTimeZone();
        contactPage.enterPhoneNumber(ConfigReader.getConfigValue("contact.phoneNo"));
        contactPage.clickOnSaveContactBtn();
        Assert.assertTrue(contactPage.isContactSaved(ConfigReader.getConfigValue("contact.firstname")));
    }

}
