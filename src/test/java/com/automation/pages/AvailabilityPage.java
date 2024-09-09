package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AvailabilityPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'Holidays')]")
    WebElement holidayTab;

    @FindBy(xpath = "//h1[contains(text(),'Availability')]")
    WebElement availabilityPageTitle;


    public boolean isAvailabilityPageDisplayed() {
        return availabilityPageTitle.isDisplayed() && holidayTab.isDisplayed();
    }

    public void clickOnHolidaysTab() {
        holidayTab.click();
    }
}
