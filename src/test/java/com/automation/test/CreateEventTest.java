package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEventTest extends BaseTest{

    @Test
    public void createOneOnOneEventTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnNewEventTypeButton();
        Assert.assertTrue(newEventPage.isEventPageDisplayed());

        newEventPage.clickOnTheEventType(ConfigReader.getConfigValue("eventType.one"));
        newEventPage.clickOnNextButton();
        newEventPage.enterEventNameAndDuration(ConfigReader.getConfigValue("newEvent.name"), ConfigReader.getConfigValue("newEvent.duration"));
        newEventPage.clickContinueButton();
        Assert.assertTrue(newEventPage.isEventReadyMsgIsDisplayed());
        newEventPage.clickDoneButton();
        Assert.assertTrue(homePage.isEventListedOnHomePage(ConfigReader.getConfigValue("newEvent.name"), ConfigReader.getConfigValue("newEvent.duration")));
    }

    @Test
    public void createGroupEventTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnNewEventTypeButton();
        Assert.assertTrue(newEventPage.isEventPageDisplayed());

        newEventPage.clickOnTheEventType(ConfigReader.getConfigValue("eventType.group"));
        newEventPage.clickOnNextButton();
        newEventPage.enterEventNameAndDuration(ConfigReader.getConfigValue("newEvent.name"), ConfigReader.getConfigValue("newEvent.duration"));
        newEventPage.clickContinueButton();
        Assert.assertTrue(newEventPage.isEventReadyMsgIsDisplayed());
        newEventPage.clickDoneButton();
        Assert.assertTrue(homePage.isEventListedOnHomePage(ConfigReader.getConfigValue("newEvent.name"), ConfigReader.getConfigValue("newEvent.duration")));
    }

    @Test
    public void collectiveEventTest(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnNewEventTypeButton();
        Assert.assertTrue(newEventPage.isEventPageDisplayed());

        newEventPage.clickOnTheEventType(ConfigReader.getConfigValue("eventType.collective"));
        invitePage.clickOnInviteUserButton();
        invitePage.enterInvitesEmails("invite.email");
        invitePage.clickSetRoleButton();
        invitePage.clickOnSendInvite();
        Assert.assertTrue(invitePage.isInvitationSent());
    }
}
