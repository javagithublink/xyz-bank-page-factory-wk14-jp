package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    //By searchCustomerText = By.xpath("//select[@id='userSelect']");
    //By logInButton = By.xpath("//button[normalize-space()='Login']");

    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement searchCustomerText;

    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement logInButton;

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void searchCustomer(String fName, String lName){
        Reporter.log("Searching customer name"+searchCustomerText.toString()+"\n</br>");
        pmSelectByVisibleTextFromDropDown(searchCustomerText,fName.trim()+" "+lName.trim());
    }

    public void clickOnLoginButton(){
        Reporter.log("Clicking on log in button"+logInButton.toString()+"\n</br>");
        pmClickOnElement(logInButton);
    }


}
