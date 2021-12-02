package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {

    By searchCustomerText = By.xpath("//select[@id='userSelect']");
    By logInButton = By.xpath("//button[normalize-space()='Login']");

    public void searchCustomer(String fName, String lName){
        useSelectByVisibleTextFromDropDown(searchCustomerText,fName.trim()+" "+lName.trim());
    }

    public void clickOnLoginButton(){
        useClickOnElement(logInButton);
    }


}
