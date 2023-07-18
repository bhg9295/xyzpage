package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerDropdown ;
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropdown;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement process;

    /*y openAccount = By.xpath("//button[normalize-space()='Open Account']");
    By customerDropdown =By.xpath("//select[@id='userSelect']");
    By currencyDropdown = By.xpath("//select[@id='currency']");
    By process = By.xpath("//button[contains(text(),'Process')]");*/
    public void clickOnOpenAccountTab(){
        clickOnElement(openAccount);
        CustomListeners.test.log(Status.PASS,"click on open account");
    }
    public void selectCustomer(){
        selectByVisibleTextFromDropDown(customerDropdown,"Ron Weasly");
        CustomListeners.test.log(Status.PASS,"click customerDropdown");

    }
    public void selectCurrencyPound(){
        selectByVisibleTextFromDropDown(currencyDropdown ,"Pound");
        CustomListeners.test.log(Status.PASS,"Text from drop down");
    }
    public void clickOnProcessBtn(){
        clickOnElement(process);
        CustomListeners.test.log(Status.PASS,"click on PressBtn");
}

}
