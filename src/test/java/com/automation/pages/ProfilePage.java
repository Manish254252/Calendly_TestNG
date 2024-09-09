package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//div/h1")
    WebElement profilePageTitle;

    @FindBy(xpath = "//div[@data-component='avatar-editor']//label/span/input")
    WebElement uploadPictureBtn;

    @FindBy(xpath = "//div/button/span[contains(text(),'Apply')]")
    WebElement applyBtn;

    @FindBy(xpath = "//div[@data-component='avatar-editor']//img")
    WebElement profileImage;

    @FindBy(xpath = "//div/button/span[contains(text(),'Save')]")
    WebElement saveChangesBtn;

    @FindBy(xpath = "//div[@aria-live='polite']")
    WebElement savedMsg;

    @FindBy(xpath = "//a/span[contains(text(),'Logout')]")
    WebElement logoutLink;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameInput;

    @FindBy(xpath = "//textarea[@type='textarea']")
    WebElement textareaInput;

    public boolean isProfilePageDisplayed() {
        return profilePageTitle.getText().equals("Profile");
    }


    public void clickOnUploadBtn(String path) {
        uploadPictureBtn.sendKeys(System.getProperty("user.dir")+ path);
        applyBtn.click();
    }

    public boolean isProfileChanged() {
        return profileImage.getAttribute("src").contains("data:image/png");
    }

    public void clickOnSaveChangesButton() {
        saveChangesBtn.click();
    }

    public boolean isChangesSaved() {
        System.out.println(savedMsg.getText());
        return savedMsg.getText().equals("Your settings have been saved!");
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    public void enterUpdateName(String updatedName) {
        nameInput.clear();
        nameInput.sendKeys(updatedName);
    }

    public void enterUpdateMsg(String updatedMsg) {
        textareaInput.clear();
        textareaInput.sendKeys(updatedMsg);
    }
}
