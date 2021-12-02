package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OpenAccountPage extends Utility {

    By searchText = By.xpath("//select[@id='userSelect']");
    By currencyText = By.xpath("//select[@id='currency']");
    By processButton = By.xpath("//button[normalize-space()='Process']");
    AddCustomerPage addCustomerPage = new AddCustomerPage();

    public void searchCustomer(String fName, String lName){
        useSelectByVisibleTextFromDropDown(searchText,fName.trim()+" "+lName.trim());
    }

    public void selectCurrency(String currency){
        useSelectByVisibleTextFromDropDown(currencyText,currency);
    }

    public void clickOnProcessButton(){
        useClickOnElement(processButton);
    }

    public void verifyAccountCreatedSuccessfullyText(){
        String expected = "Account created successfully with account Number :1016";
        String actual = useGetTextAlert();
        Assert.assertEquals(expected,actual,"wrong message");
    }

    public void clickOnOkButtonPopUp(){
        useAcceptAlert();
    }
}
