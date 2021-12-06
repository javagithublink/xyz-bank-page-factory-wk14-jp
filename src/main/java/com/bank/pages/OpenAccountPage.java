package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

//    By searchText = By.xpath("//select[@id='userSelect']");
//    By currencyText = By.xpath("//select[@id='currency']");
//    By processButton = By.xpath("//button[normalize-space()='Process']");

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchText;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyText;

    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processButton;

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    AddCustomerPage addCustomerPage = new AddCustomerPage();



    public void searchCustomer(String fName, String lName){
        Reporter.log("Searching customer under open account page"+"\n</br>");
        pmSelectByVisibleTextFromDropDown(searchText,fName.trim()+" "+lName.trim());
    }

    public void selectCurrency(String currency){
        Reporter.log("Select currency"+"\n</br>");
        pmSelectByVisibleTextFromDropDown(currencyText,currency);
    }

    public void clickOnProcessButton(){
        Reporter.log("Clicking on Process button"+"\n</br>");
        pmClickOnElement(processButton);
    }

    public void verifyAccountCreatedSuccessfullyText(){
        Reporter.log("Clicking on Process button"+"\n</br>");

        String expected = "Account created successfully with account Number :1016";
        String actual = pmGetTextFromAlert();
        Assert.assertEquals(expected.substring(0,20),actual.substring(0,20),"wrong message");
    }

    public void clickOnOkButtonPopUp(){
        pmAcceptAlert();
    }
}
