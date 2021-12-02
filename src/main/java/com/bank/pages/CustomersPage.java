package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomersPage extends Utility {



    By logOutButton = By.xpath("//button[normalize-space()='Logout']");
    By nameText = By.xpath("//strong//span[@class='fontBig ng-binding']");
    By depositTab = By.xpath("//button[normalize-space()='Deposit']");
    By amountField = By.xpath("//input[@placeholder='amount']");
    By depositButton = By.xpath("//button[@type='submit']");
    By depositMessage = By.xpath("//span[contains(normalize-space(),'Deposit Successful')]");
    By withdrawlTab = By.xpath("//button[normalize-space()='Withdrawl']");
    By withdrawlAmountField = By.xpath("//input[@placeholder='amount']");
    By withdrawlButton = By.xpath("//button[normalize-space()='Withdraw']");
    By withdrawlMessage = By.xpath("//span[contains(normalize-space(),'Transaction successful')]");


    public void verifyLogOutButtonDisplayed(){
        useWaitUntilVisibilityOfElementLocated(logOutButton,20);
        useVerifyResult("Logout",logOutButton,"log out button not displayed properly");
    }

    public void verifyYourNameTextDisplayed(String fName, String lName){
        useWaitUntilVisibilityOfElementLocated(nameText,20);
        useVerifyResult(fName.trim()+" "+lName.trim(),nameText,"wrong name displayed");
    }

    public void clickOnLogOutButton(){

        useClickOnElement(logOutButton);
    }

    public void clickOnDepositTab(){
        useClickOnElement(depositTab);
    }

    public void enterAmount(String amount){
        useSendTextToElement(amountField,amount);
    }

    public void clickOnDepositButton(){
        useClickOnElement(depositButton);
    }

    public void verifyDepositSuccessFullMessage(){
        useWaitUntilVisibilityOfElementLocated(depositMessage,30);
        useVerifyResult("Deposit Successful",depositMessage,"wrong message");
    }

    public void clickOnWithdrawlTab(){
        useClickOnElement(withdrawlTab);
    }

    public void enterWithdrawlAmount(String amount){
        useSendTextToElement(withdrawlAmountField,amount);
    }

    public void clickOnWithdrawlButton(){
        useClickOnElement(withdrawlButton);
    }

    public void verifyTransactionSuccessfulMessage(){
        useWaitUntilVisibilityOfElementLocated(withdrawlMessage,20);
        useVerifyResult("Transaction successful",withdrawlMessage,"Withdrawl not successful");
    }
}
