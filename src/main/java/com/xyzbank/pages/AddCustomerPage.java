package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends Utility {
   @ CacheLookup
   @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomerTab;
    @ CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;
    @ CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;
    @ CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
            WebElement postCodeField;


    String firstName;
    String lastName;
    String postCode;
    By addCustomerBtn = By.xpath("//button[@type = 'submit' and contains(text(),'Add Customer')]");
    public void clickOnAddCustomerTab() {

        clickOnElement(addCustomerTab);
        CustomListeners.test.log(Status.PASS,"click on add customer");
    }
    public String getFirstName(String name) {
        firstName = getRandomString(4);

        CustomListeners.test.log(Status.PASS,"click on First name"+name);
        return name;
    }
    public String getLastName(String name1) {
        lastName = getRandomString(8);
       CustomListeners.test.log(Status.PASS,"click on Last name"+name1);
        return lastName;
    }
    public String getPostCode(String Postcode) {
        postCode = getRandomString(6);

       CustomListeners.test.log(Status.PASS,"click on Postcode" +Postcode);
        return postCode;
    }


    public void clickOnAddCustomerButton() {
        clickOnElement(addCustomerBtn);
        CustomListeners.test.log(Status.PASS,"click on Button" );

}

    public void fillAddCustomerForm() {
        sendTextToElement(firstNameField,getFirstName("Bansari"));
        sendTextToElement(lastNameField,getLastName(""));
        sendTextToElement(postCodeField,getPostCode(""));
    }
}
