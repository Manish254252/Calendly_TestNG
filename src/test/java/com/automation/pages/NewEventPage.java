package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewEventPage extends BasePage{

    String XPATH_EVENT_TYPE = "//button//h2[contains(text(), '%s')]";

    @FindBy(xpath = "//button/span[contains(text(),'Next')]")
    WebElement nextBtn;

    @FindBy(xpath = "//input[@id='event-name-field']")
    WebElement newEventNameInput;

    @FindBy(xpath="//div[@name='eventDuration']")
    WebElement eventDuration;

    String XPATH_DURATION = "//button[contains(text(),'%s')]";

//    String XPATH_DURATION = "//div[@data-component='sortable']//p[contains(text(),'%s')]";

    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueBtn;

    @FindBy(xpath = "//div/button/span[text()='Invite users']")
    WebElement inviteUserButton;

    @FindBy(xpath = "//h1[contains(text(), 'Your event type is ready!')] ")
    WebElement confirmationDialogueBox;

    @FindBy(xpath = "//div[@role='listbox']/button[1]")
    WebElement durationFirstOption;

    @FindBy(xpath = "//button[contains(text(),'Done')]")
    WebElement doneBtn;

    @FindBy(xpath = "//h1[contains(text(), 'Create New Event')]")
    WebElement eventPageTitle;

    @FindBy(xpath = "//tbody/tr//button")
    List<WebElement> eventTypeList;


    @FindBy(xpath = "//input[@name='inviteesLimit']")
    WebElement inviteLimitInput;


    public boolean isEventPageDisplayed() {
        return eventPageTitle.isDisplayed() && eventTypeList.get(0).isDisplayed();
    }


    public void clickOnTheEventType(String eventType) {
        String xpath = String.format(XPATH_EVENT_TYPE, eventType);
        WebElement eventTypeDiv = driver.findElement(By.xpath(xpath));
        eventTypeDiv.click();
    }


    public void clickOnNextButton() {
        nextBtn.click();
    }

    public void enterEventNameAndDuration(String eventName, String duration) {
        newEventNameInput.sendKeys(eventName);
        eventDuration.click();
//        String xpath = String.format(XPATH_DURATION,duration);
//        driver.findElement(By.xpath(xpath)).click();
        durationFirstOption.click();

        if(isPresentWithoutWait(inviteLimitInput)){
            inviteLimitInput.sendKeys(ConfigReader.getConfigValue("maxInviteLimit"));
        }

    }

    public void clickContinueButton() {
        continueBtn.click();
    }

    public boolean isEventReadyMsgIsDisplayed() {
        return confirmationDialogueBox.isDisplayed();
    }

    public void clickDoneButton() {
        doneBtn.click();
    }
}
