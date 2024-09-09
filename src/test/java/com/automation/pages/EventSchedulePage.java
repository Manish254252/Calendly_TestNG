package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventSchedulePage extends BasePage {

    @FindBy(xpath = "//div[@data-component='spotpicker']/h2")
    WebElement selectDateTitle;

    @FindBy(xpath = "//div[@data-testid='calendar']")
    WebElement calender;

    @FindBy(xpath = "//button[contains(@aria-label, 'Times available')]/span")
    List<WebElement> availableDates;

    @FindBy(xpath = "//button[@aria-label='Go to next month']")
    WebElement nextMonthButton;

    @FindBy(xpath = "//div[@data-testid='calendar-header']/div[@data-testid='title']")
    WebElement monthHeader;

    @FindBy(xpath = "//div[@data-component='spot-list']")
    WebElement timeListDiv;

    @FindBy(xpath = "//button[@data-container='time-button']")
    List<WebElement> timeButtons;

    @FindBy(xpath = "//button[contains(@aria-label, 'Next')]")
    WebElement nextBtn;

    @FindBy(xpath = "//input[@name='full_name']")
    WebElement nameInput;

    @FindBy(xpath = "//div/input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = "//textarea[@type='textarea']")
    WebElement textareaInput;

    @FindBy(xpath = "//button/span[contains(text(), 'Schedule Event')]")
    WebElement scheduleEventBtn;

    @FindBy(xpath = "//div[@data-component='confirmation-header']/h1")
    WebElement scheduleConfirmationMsg;


    public boolean isEventSchedulePageDisplayed() {
        return selectDateTitle.getText().contains("Select a Date") && calender.isDisplayed();
    }


    public void selectDate(String stringDate) {
        String monthYear = stringDate.substring(stringDate.indexOf(" ") + 1);
        String date = stringDate.substring(0, stringDate.indexOf(" "));

        while (!monthHeader.getText().equals(monthYear)) {
            nextMonthButton.click();
            waitUntilElementVisible(monthHeader);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
        for (WebElement dateEle : availableDates) {
            if (dateEle.getText().equals(date)) {
                dateEle.click();
                break;
            }
        }
    }

    public void selectTime() {
        if (isPresent(timeListDiv)) {
            timeButtons.get(0).click();
            nextBtn.click();
        }
    }

    public void enterEventNameAndMsg(String name, String email, String msg) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        textareaInput.sendKeys(msg);
    }

    public void clickScheduleButton() {
        scheduleEventBtn.click();
    }

    public boolean isEventScheduled() {
        return scheduleConfirmationMsg.getText().contains("You are scheduled");
    }
}
