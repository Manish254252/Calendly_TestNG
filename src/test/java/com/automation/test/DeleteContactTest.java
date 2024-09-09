package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContactTest extends BaseTest {

    @Test
    public void deleteContactTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        contactPage.clickOnContactSection();
        contactPage.removesSpecifiedContact(ConfigReader.getConfigValue("contact.firstname"),ConfigReader.getConfigValue("contact.email"));
        Assert.assertFalse(contactPage.isContactPresent(ConfigReader.getConfigValue("contact.firstname"), ConfigReader.getConfigValue("contact.email")));
    }
}
