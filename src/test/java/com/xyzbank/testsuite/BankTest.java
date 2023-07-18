package com.xyzbank.testsuite;

import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.pages.*;
import com.xyzbank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage ;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage ;
    CustomerLoginPage customerLoginPage ;
    CustomersPage customersPage ;
    AccountPage accountPage;
    @BeforeMethod(groups = {"sanity","smoke","regrassion"})
    public void inIT(){
        homePage = new HomePage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();


    }

    @Test(groups = {"sanity", "regression"})
public void bankManagerShouldAddCustomerSuccessfully() {
        sleep(2000);
    homePage.clickOnBankManagerLoginTab();
    addCustomerPage.clickOnAddCustomerTab();
    addCustomerPage.fillAddCustomerForm();
    addCustomerPage.clickOnAddCustomerButton();
    String expectedAlertMessage = "Customer added successfully";sleep(20000);
   String actualAlertMessage = getTextFromAlert();
    System.out.println("Alert Popup Notification : " + actualAlertMessage);
    sleep(2000);
    Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage), "Customer added successfully message validation failed");
   acceptAlert();
}

    @Test(groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLoginTab();
        openAccountPage.clickOnOpenAccountTab();
        openAccountPage.selectCustomer();
        openAccountPage.selectCurrencyPound();
        openAccountPage.clickOnProcessBtn();
        String expectedAlertMessage = "Account created successfully";
        String actualAlertMessage = getTextFromAlert();
        System.out.println("Alert Popup Notification : " + actualAlertMessage);
        Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage), "Account created successfully message validation failed");
        acceptAlert();
    }
    @Test(groups = { "regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchCreatedCustomerName();
        customerLoginPage.clickOnLoginBtn();
        Thread.sleep(2000);
        String expectedText = "Logout";
        Assert.assertEquals(customerLoginPage.getLogOutTab(), expectedText, "Logout text is not displayed");
        customerLoginPage.clickOnLogOut();
        String expectedYourNameText = "Your Name :";
        Assert.assertEquals(customerLoginPage.getYourNameText(), expectedYourNameText, "your Name text is not displayed");
    }

    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchCreatedCustomerName();
        customerLoginPage.clickOnLoginBtn();
        customersPage.clickOnDepositBtn();
        customersPage.depositSomeAmount();
        customersPage.clickOnDepositSubmitBtn();
        String expectedAmountSubmitMessage = "Deposit Successful";
        String actualAmountSubmitMessage = customersPage.getAmountSubmitMessage();
        Assert.assertEquals(actualAmountSubmitMessage, expectedAmountSubmitMessage, "Amount submitMassage is not displayed");
    }
    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchCreatedCustomerName();
        customerLoginPage.clickOnLoginBtn();
        accountPage.withdrawlTab();
        accountPage.withdrawlSomeAmount();
        accountPage.clickOnWithdrawlButton();
        String expectedTransitionMessage = "Transaction successful";
        String actualTransitionMessage = accountPage.getTransitionSuccessMessage();
        Assert.assertEquals(actualTransitionMessage,expectedTransitionMessage,"Transition Message is not displayed");
}




}
