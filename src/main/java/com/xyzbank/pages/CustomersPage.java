package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends Utility {


    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement deposit;
    @FindBy(xpath = " (//input[@placeholder='amount'])[1]")
    WebElement amount ;
    @FindBy(xpath = "//button[@type='submit'] ")
    WebElement depositSubmit ;
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')] ")
    WebElement successfulMessage;

    public void clickOnDepositBtn(){
        clickOnElement(deposit);
        CustomListeners.test.log(Status.PASS,"click on DepositionButton");
    }
    public void depositSomeAmount(){
        clearWebElementText((By) amount);
        sendTextToElement(amount,"1000");
       CustomListeners.test.log(Status.PASS,"click on amount");
    }

    private void clearWebElementText(By amount) {
    }

    public void clickOnDepositSubmitBtn(){
        clickOnElement(depositSubmit);
      CustomListeners.test.log(Status.PASS,"click on DepositSubmissonBtn");
    }
    public String getAmountSubmitMessage(){
      getTextFromElement(successfulMessage);
        CustomListeners.test.log(Status.PASS,"click on SubmitButton");
        return null;
}

}
