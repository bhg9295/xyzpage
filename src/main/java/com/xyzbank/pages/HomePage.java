package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginBtn ;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
            WebElement customerLogin;

    public void clickOnBankManagerLoginTab() {
        clickOnElement(bankManagerLoginBtn);
        CustomListeners.test.log(Status.PASS,"click on loginTab");

    }
    public void clickOnCustomerLoginTab(){
        clickOnElement(customerLogin);
        CustomListeners.test.log(Status.PASS,"click on CustomerloginTab");

}


}
