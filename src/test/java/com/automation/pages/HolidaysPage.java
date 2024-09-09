package com.automation.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HolidaysPage extends BasePage {

    @FindBy(xpath = "//div/button/span[text()='Change']")
    WebElement changeButton;

    @FindBy(xpath = "//div/h1[text()='Holiday settings']")
    WebElement holidaySettingPopUp;

    @FindBy(xpath = "//div/button/span[text()='Apply']")
    WebElement applyButton;

    @FindBy(xpath = "//div[@name='countryCode']")
    WebElement countrySelectionButton;

    @FindBy(xpath = "//div[@role='listbox']/button")
    List<WebElement> countriesList;

    @FindBy(xpath = "//div/button/span[text()='Change']/../.././p")
    WebElement holidaysOfCountry;

    @FindBy(xpath = "//main//div/p/following-sibling::div/div/div//label/div/div")
    List<WebElement> holidaysCheckButtons;


    public void clickOnChangeLink() {
        changeButton.click();
    }

    public boolean isHolidaysSettingPopUpDisplayed() {
        return holidaySettingPopUp.isDisplayed();
    }

    public void clickOnCountryListButton() {
        countrySelectionButton.click();
    }

    public void clickOnCountry(String country) {
        for (WebElement countryEle : countriesList) {
            if (countryEle.getText().equals(country)) {
                countryEle.click();
                break;
            }
        }
    }

    public void clickOnApplyButton() {
        applyButton.click();
    }

    public boolean isHolidaysOfCountryDisplayed(String country) {
        return holidaysOfCountry.isDisplayed();
    }

    public void uncheckFirstTwoHolidays() {
        for (int i = 0; i < holidaysCheckButtons.size(); i++) {
            if (i < 2) {
                driver.navigate().refresh();
                holidaysCheckButtons.get(i).click();
            } else {
                break;
            }
        }
    }
}
