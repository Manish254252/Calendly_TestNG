package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InvitePage extends BasePage{

    @FindBy(xpath = "//div/button/span[text()='Invite users']")
    WebElement inviteUsersBtn;

    @FindBy(xpath = "//label[@for='invitee_emails_input']")
    WebElement emailAddressBox;

    @FindBy(xpath = "//div[@data-container='invitee-email-valid']/div[@aria-label='Remove']")
    List<WebElement> previousEmailCloseBtn;

    @FindBy(xpath = "//div/button/span[contains(text(), 'Set roles')]")
    WebElement setRolesBtn;

    @FindBy(xpath = "//div/button/span[contains(text(), 'Assign event')]")
    WebElement assignEventButton;

    @FindBy(xpath = "//div/button/span[contains(text(), 'Send invitation')]")
    WebElement sendInvitationBtn;

    @FindBy(xpath = "//div[@data-component='main']//h1[contains(text(), 'All done')]")
    WebElement confirmationMsg;

    @FindBy(xpath = "//div[@role='dialog']//h3")
    WebElement upgradePlanHeading;

    public void clickOnInviteUserButton() {
        inviteUsersBtn.click();
    }

    public void enterInvitesEmails(String email) {
        ConfigReader.setConfigValue(email,getRandomEmail());
        email = ConfigReader.getConfigValue(email);
        emailAddressBox.click();
        emailAddressBox.sendKeys(email);
    }

    public void clickSetRoleButton() {
        setRolesBtn.click();
    }

    public void clickOnSendInvite() {
        sendInvitationBtn.click();
    }

    public void clickOnAssignEventButton() {
        assignEventButton.click();
    }

    public boolean isInvitationSent() {
        return confirmationMsg.isDisplayed();
    }

    public boolean isUpgradePlanPopUpDisplayed() {
        return upgradePlanHeading.getText().equalsIgnoreCase("Upgrade to Standard");
    }
}
