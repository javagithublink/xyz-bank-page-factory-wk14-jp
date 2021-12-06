package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    AccountPage accountPage;


    @BeforeMethod
    public void init(){
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();
    }


    String firstName = "Harry";
    String lastName = "Potter";
    String postCode = "HA45SQ";


    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLogInTab();
        bankManagerLoginPage.clickOnAddCustomerTab();

        addCustomerPage.addCustomerDetails(firstName, lastName, postCode);
        addCustomerPage.clickOnAddCustomerButton();

        addCustomerPage.verifyPopUpMessage();
        addCustomerPage.clickOnOkButtonOnPopUp();

    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLogInTab();
        bankManagerLoginPage.clickOnOpenAccountTab();

        openAccountPage.searchCustomer(firstName, lastName);
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.verifyAccountCreatedSuccessfullyText();
        openAccountPage.clickOnOkButtonPopUp();

    }

    @Test(groups = {"sanity","regression"})
    public void customerShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstName, lastName);
        customerLoginPage.clickOnLoginButton();



        customersPage.verifyLogOutButtonDisplayed();
        customersPage.verifyYourNameTextDisplayed(firstName, lastName);
        customersPage.clickOnLogOutButton();


    }

    @Test (groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstName, lastName);
        customerLoginPage.clickOnLoginButton();

        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();
        accountPage.verifyDepositSuccessFullMessage();

    }

    @Test (groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginTab();

        customerLoginPage.searchCustomer(firstName, lastName);
        customerLoginPage.clickOnLoginButton();

        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();

        Thread.sleep(1000);
        accountPage.clickOnWithdrawlTab();
        Thread.sleep(1000);
        accountPage.enterWithdrawlAmount("25");
        Thread.sleep(1000);
        accountPage.clickOnWithdrawlButton();
        accountPage.verifyTransactionSuccessfulMessage();


    }

}
