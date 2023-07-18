package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')] ")
    WebElement loginBtn ;
    @CacheLookup
    @FindBy(xpath = " //button[contains(text(),'Logout')]")
    WebElement logOut;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')] ")
    WebElement yourName;



    public void searchCreatedCustomerName(){
        selectByVisibleTextFromDropDown(searchCustomer,"Harry Potter");
        CustomListeners.test.log(Status.PASS,"click on customerName");
    }
    public void clickOnLoginBtn(){
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"click on loginButton");
    }

    public String getLogOutTab(){
        String  message =    getTextFromElement(logOut);
       CustomListeners.test.log(Status.PASS,"click on logout");


        return message;
    }
    public void clickOnLogOut(){
        clickOnElement(logOut);
        CustomListeners.test.log(Status.PASS,"click on logout");


    }
    public String getYourNameText(){
     String  message =   getTextFromElement(yourName);
       CustomListeners.test.log(Status.PASS,"click on yourname");
        return message;
    }

}
