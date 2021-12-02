package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By bankManagerLogInTab = By.xpath("//button[normalize-space()='Bank Manager Login']");

    By customerLoginTab = By.xpath("//button[normalize-space()='Customer Login']");


    public void clickOnBankManagerLogInTab(){
        useClickOnElement(bankManagerLogInTab);
    }



    public void clickOnCustomerLoginTab(){
        useClickOnElement(customerLoginTab);
    }


}
