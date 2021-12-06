package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    //By firstName = By.xpath("//input[@placeholder='First Name']");
//    By lastName = By.xpath("//input[@placeholder='Last Name']");
//    By postCode = By.xpath("//input[@placeholder='Post Code']");
//    By buttonAddCustomer = By.xpath("//button[@type='submit']");

    @FindBy (xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy (xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy (xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement buttonAddCustomer;

    public AddCustomerPage() {

        PageFactory.initElements(driver, this);
    }

    public void addCustomerDetails(String fName, String lName, String pCode){
        Reporter.log("Entering customer details " + firstName.toString()+" "+lastName.toString()+" "+postCode.toString() + "\n</br>");
        pmSendTextToElement(firstName,fName);
        pmSendTextToElement(lastName,lName);
        pmSendTextToElement(postCode,pCode);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Clicking on add customer button"+buttonAddCustomer.toString()+"\n</br>");
        pmClickOnElement(buttonAddCustomer);
    }

    public void verifyPopUpMessage(){

        String actual = pmGetTextFromAlert();
        String expected = "Customer added successfully with customer id :6";
        Assert.assertEquals(actual.substring(0,20),expected.substring(0,20),"wrong popup message");
    }

    public void clickOnOkButtonOnPopUp(){
        Reporter.log("Accepting popup message"+"\n</br>");
        pmAcceptAlert();
    }


}
