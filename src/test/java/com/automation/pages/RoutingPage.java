package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class RoutingPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'routing form')]")
    WebElement newRoutingFormBtn;

    @FindBy(xpath = "//div[@data-component='main']//h1")
    WebElement routingPageTitle;

    @FindBy(xpath = "//button/span[text() = 'Create a new form']")
    WebElement createNewFormBtn;

    @FindBy(xpath = "//div[@role='dialog']//h1")
    WebElement newFormPopUpHeading;

    @FindBy(xpath = "//input[@placeholder='Routing form name']")
    WebElement formNameInput;

    @FindBy(xpath = "//span[contains(text(),'Create form')]")
    WebElement createFormBtn;

    @FindBy(xpath = "//div[@data-component='main']//h1")
    WebElement formHeadingName;

    @FindBy(xpath = "//button[contains(text(), 'Add a question')]")
    WebElement addAQuestionBtn;

    @FindBy(xpath = "//button[@role='menuitem']/div[contains(text(), 'Name')]")
    WebElement nameOption;

    @FindBy(xpath = "//button[@role='menuitem']/div[contains(text(), 'Email')]")
    WebElement emailOption;

    @FindBy(xpath = "//input[@placeholder='Write a question']")
    WebElement questionInput;

    @FindBy(xpath = "//span[text()='Save']")
    WebElement saveBtn;

    @FindBy(xpath = "//div[@aria-live='polite']")
    WebElement changesSavedMsg;

    @FindBy(xpath = "//div[@data-component='sticky-footer']//button/span[text()='Next']")
    WebElement nextBtn;

    @FindBy(xpath = "//span[text()='Publish form']")
    WebElement publishFormBtn;

    @FindBy(xpath = "//div[@role='dialog']//p[contains(text(),'Copy')]")
    WebElement copyPopUp;

    @FindBy(xpath = "//span[contains(text(),'Copy link')]")
    WebElement copyLinkBtn;

    @FindBy(xpath = "//span[contains(text(),'Close')]")
    WebElement closeBtn;

    @FindBy(xpath = "//div[@aria-disabled='false']//label")
    List<WebElement> addedSectionList;

    @FindBy(xpath = "//tbody//tr//p//a")
    List<WebElement> formNameList;

    @FindBy(xpath = "//tbody//tr//td//button[@aria-label='Options']")
    List<WebElement> optionsList;

    @FindBy(xpath = "//tbody//tr//td//div//button//div[contains(text(),'Delete')]")
    WebElement deleteOption;

    @FindBy(xpath = "//div[@role='dialog']//button/span[contains(text(),'Delete')]")
    WebElement deleteConfirmationBtn;

    public boolean isRoutingPageDisplayed() {
        return newRoutingFormBtn.isDisplayed() && routingPageTitle.getText().equals("Routing");
    }

    public void clickOnNewRoutingButton() {
        newRoutingFormBtn.click();
    }

    public void clickOnCreateNewForm() {
        createNewFormBtn.click();
    }


    public boolean isRoutingFormPopUpDisplayed() {
        return newFormPopUpHeading.getText().equals("New routing form");
    }

    public void enterRoutingName(String routingName) {
        formNameInput.sendKeys(routingName);
    }

    public void clickOnCreateFormBtn() {
        createFormBtn.click();
    }

    public void clickOnAddQuestionButton() {
        addAQuestionBtn.click();
    }

    public void selectNameOption() {
        nameOption.click();
    }

    public void enterQuestion(String nameQuestion) {
        questionInput.clear();
        questionInput.sendKeys(nameQuestion);
    }

    public void clickOnSaveBtn() {
        click(saveBtn);
    }

    public void selectEmailOption() {
        emailOption.click();
    }

    public boolean isChangesSavedMsgDisplayed() {
        return changesSavedMsg.getText().equals("Changes saved");
    }

    public void clickOnNextButton() {
        waitUntilClickable(nextBtn);
        nextBtn.click();
    }

    public void clickOnPublishBtn() {
        publishFormBtn.click();
    }

    public boolean isCopyPopUpDisplayed() {
        boolean popUpDisplayed = copyPopUp.isDisplayed() && copyLinkBtn.isDisplayed();
        closeBtn.click();
        return popUpDisplayed ;
    }

    public boolean isNameSectionAdded() {
        if(isPresent(addedSectionList.get(0))){
            for(WebElement section: addedSectionList){
                if(section.getText().equals("Name")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmailSectionAdded() {
        if(isPresent(addedSectionList.get(0))){
            for(WebElement section: addedSectionList){
                if(section.getText().equals("Email")){
                    return true;
                }
            }
        }
        return false;
    }

    public void clickOnRoutingOption(String routingName) {
        for(int i = 0; i < formNameList.size(); i++){
            if(formNameList.get(i).getText().equals(routingName)){
                click(optionsList.get(i));
            }
        }
    }

    public void clickOnDeleteBtn() {
        deleteOption.click();
    }

    public boolean isConfirmationDeletePopUpDisplayed() {
        return deleteConfirmationBtn.isDisplayed();
    }

    public void clickOnConfirmDeleteBtn() {
        deleteConfirmationBtn.click();
    }

    public boolean isRoutingFormDeleted(String routingName) {
        for (WebElement formName: formNameList){
            if(formName.getText().equals(routingName)){
                return false;
            }
        }
        return true;
    }
}
