package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateRoutingTest extends BaseTest {

    @Test
    public void createRouting(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.clickOnRoutingLink();
        Assert.assertTrue(routingPage.isRoutingPageDisplayed());
        routingPage.clickOnNewRoutingButton();
        routingPage.clickOnCreateNewForm();
        Assert.assertTrue(routingPage.isRoutingFormPopUpDisplayed());

        routingPage.enterRoutingName(ConfigReader.getConfigValue("routing.name"));
        routingPage.clickOnCreateFormBtn();
        routingPage.clickOnAddQuestionButton();
        routingPage.selectNameOption();
        routingPage.enterQuestion(ConfigReader.getConfigValue("name.question"));
        routingPage.clickOnSaveBtn();
        routingPage.clickOnAddQuestionButton();
        routingPage.selectEmailOption();
        routingPage.enterQuestion(ConfigReader.getConfigValue("email.question"));
        routingPage.clickOnSaveBtn();
        routingPage.clickOnNextButton();
        routingPage.clickOnPublishBtn();
        Assert.assertTrue(routingPage.isCopyPopUpDisplayed());
    }

    @Test
    public void deleteRoutingTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.clickOnRoutingLink();
        Assert.assertTrue(routingPage.isRoutingPageDisplayed());
        routingPage.clickOnRoutingOption(ConfigReader.getConfigValue("routing.name"));
        routingPage.clickOnDeleteBtn();
        Assert.assertTrue(routingPage.isConfirmationDeletePopUpDisplayed());
        routingPage.clickOnConfirmDeleteBtn();
        Assert.assertTrue(routingPage.isRoutingFormDeleted("routing.name"));
    }

}
