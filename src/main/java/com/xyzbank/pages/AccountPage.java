package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawl;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountnNo;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawBtn;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement transaction;
    public void withdrawlTab() {
        clickOnElement(withdrawl);
        sendTextToElement(amountnNo,"50");
    }
    private void clearWebElementText(By amountnNo) {

        CustomListeners.test.log(Status.PASS, "click on button" + withdrawl);

    }
    public void clickOnWithdrawlButton() {
        clickOnElement(withdrawl);
       CustomListeners.test.log(Status.PASS, "click on button" + withdrawl);


    }
    public String getTransitionSuccessMessage() {

        getTextFromElement(transaction);
        CustomListeners.test.log(Status.PASS, "click on transaction" + transaction);

        return null;
    }
    public void withdrawlSomeAmount() {

    }
}

