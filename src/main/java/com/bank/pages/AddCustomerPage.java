package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddCustomerPage extends Utility {
    By firstName = By.xpath("//input[@placeholder='First Name']");
    By lastName = By.xpath("//input[@placeholder='Last Name']");
    By postCode = By.xpath("//input[@placeholder='Post Code']");
    By buttonAddCustomer = By.xpath("//button[@type='submit']");

    public void addCustomerDetails(String fName, String lName, String pCode){
        useSendTextToElement(firstName,fName);
        useSendTextToElement(lastName,lName);
        useSendTextToElement(postCode,pCode);
    }

    public void clickOnAddCustomerButton() {
        useClickOnElement(buttonAddCustomer);
    }

    public void verifyPopUpMessage(){
        String actual = useGetTextAlert();
        String expected = "Customer added successfully with customer id :6";
        Assert.assertEquals(expected,actual,"wrong popup message");
    }

    public void clickOnOkButtonOnPopUp(){
        useAcceptAlert();
    }


}
