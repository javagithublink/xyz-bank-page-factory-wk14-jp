package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.Test;

public class BankTest extends TestBase {

    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    OpenAccountPage openAccountPage = new OpenAccountPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    CustomersPage customersPage = new CustomersPage();


    String firstName = "Harry";
    String lastName = "Potter";
    String postCode = "HA45SQ";

    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLogInTab();
        bankManagerLoginPage.clickOnAddCustomerTab();

        addCustomerPage.addCustomerDetails(firstName, lastName, postCode);
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.verifyPopUpMessage();
        addCustomerPage.clickOnOkButtonOnPopUp();

        //useClickOnElement(By.xpath("//button[normalize-space()='Home']"));


    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLogInTab();
        bankManagerLoginPage.clickOnOpenAccountTab();

        openAccountPage.searchCustomer(firstName, lastName);
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.verifyAccountCreatedSuccessfullyText();
        openAccountPage.clickOnOkButtonPopUp();

    }

    @Test
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstName, lastName);
        customerLoginPage.clickOnLoginButton();

        customersPage.verifyLogOutButtonDisplayed();
        customersPage.verifyYourNameTextDisplayed(firstName, lastName);
        customersPage.clickOnLogOutButton();


    }

    @Test
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstName, lastName);
        customerLoginPage.clickOnLoginButton();

        customersPage.clickOnDepositTab();
        customersPage.enterAmount("100");
        customersPage.clickOnDepositButton();
        customersPage.verifyDepositSuccessFullMessage();

    }

    @Test
    public void customerShouldWithdrawMoneySuccessfully(){
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstName, lastName);
        customerLoginPage.clickOnLoginButton();

        customersPage.clickOnDepositTab();
        customersPage.enterAmount("100");
        customersPage.clickOnDepositButton();
       

        customersPage.clickOnWithdrawlTab();
        customersPage.enterWithdrawlAmount("25");
        customersPage.clickOnDepositButton();
        customersPage.verifyDepositSuccessFullMessage();



    }

}
