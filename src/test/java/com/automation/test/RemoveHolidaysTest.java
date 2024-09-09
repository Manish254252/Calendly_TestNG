package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveHolidaysTest extends BaseTest{

    @Test(dataProvider = "country names")
    public void removeHolidays(String country){
        landingPage.openWebsite();
        landingPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
        loginPage.enterEmail(ConfigReader.getConfigValue("userEmail"));
        loginPage.clickOnLoginBtn();
        loginPage.enterPassword(ConfigReader.getConfigValue("password"));
        loginPage.clickOnContinue();
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.clickOnAvailabilityButton();
        Assert.assertTrue(availabilityPage.isAvailabilityPageDisplayed());
        availabilityPage.clickOnHolidaysTab();
        holidaysPage.clickOnChangeLink();
        Assert.assertTrue(holidaysPage.isHolidaysSettingPopUpDisplayed());
        holidaysPage.clickOnCountryListButton();
        holidaysPage.clickOnCountry(country);
        holidaysPage.clickOnApplyButton();
        Assert.assertTrue(holidaysPage.isHolidaysOfCountryDisplayed(country));
        holidaysPage.uncheckFirstTwoHolidays();
    }

    @DataProvider(name = "country names")
    public Object[] countryNames(){
        return new Object[]{
                "Germany",
                "Spain"
        };
    }

}
