package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleEventTest extends BaseTest{

    @Test
    public void scheduleEvent(){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.clickOnBookingEventLink(ConfigReader.getConfigValue("newEvent.name"), ConfigReader.getConfigValue("newEvent.duration"));
        homePage.switchTab();
        Assert.assertTrue(eventSchedulePage.isEventSchedulePageDisplayed());
        eventSchedulePage.selectDate(ConfigReader.getConfigValue("eventSchedule.date"));
        eventSchedulePage.selectTime();
        eventSchedulePage.enterEventNameAndMsg(ConfigReader.getConfigValue("eventSchedule.name"),ConfigReader.getConfigValue("eventSchedule.email") ,ConfigReader.getConfigValue("eventSchedule.Msg"));
        eventSchedulePage.clickScheduleButton();
        Assert.assertTrue(eventSchedulePage.isEventScheduled());
    }

    @Test
    public void cancelEvent() {
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
        Assert.assertTrue(meetingsPage.isMeetingPresent(ConfigReader.getConfigValue("eventSchedule.name"), ConfigReader.getConfigValue("newEvent.name")));
        meetingsPage.clickOnMeetingOfNameAndEvent(ConfigReader.getConfigValue("eventSchedule.name"), ConfigReader.getConfigValue("newEvent.name"));
        meetingsPage.clickOnCancelButton();
        Assert.assertTrue(meetingsPage.isCancelEventPopUpDisplayed());
        meetingsPage.clickOnConfirmButton();
        Assert.assertTrue(meetingsPage.isMeetingCanceled(ConfigReader.getConfigValue("eventSchedule.name"), ConfigReader.getConfigValue("newEvent.name")));
    }

    }
