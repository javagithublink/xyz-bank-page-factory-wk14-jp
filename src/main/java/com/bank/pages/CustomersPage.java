package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CustomersPage extends Utility {



    //By logOutButton = By.xpath("//button[normalize-space()='Logout']");
    //By nameText = By.xpath("//strong//span[@class='fontBig ng-binding']");
    //By depositTab = By.xpath("//button[normalize-space()='Deposit']");
    //By amountField = By.xpath("//input[@placeholder='amount']");
    //By depositButton = By.xpath("//button[@type='submit']");
    //By depositMessage = By.xpath("//span[contains(normalize-space(),'Deposit Successful')]");
    //By withdrawlTab = By.xpath("//button[normalize-space()='Withdrawl']");
    //By withdrawlAmountField = By.xpath("//input[@placeholder='amount']");
    //By withdrawlButton = By.xpath("//button[normalize-space()='Withdraw']");
    //By withdrawlMessage = By.xpath("//span[contains(normalize-space(),'Transaction successful')]");


    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logOutButton;

    @FindBy(xpath = "//strong//span[@class='fontBig ng-binding']")
    WebElement nameText;



    public CustomersPage() {
        PageFactory.initElements(driver,this)   ;
    }

    public void verifyLogOutButtonDisplayed(){
        Reporter.log("Verifying logout button"+"\n</br>");
        boolean actual = logOutButton.isDisplayed();
        Assert.assertTrue(actual);

    }

    public void verifyYourNameTextDisplayed(String fName, String lName){
        //pmWaitUntilVisibilityOfElementLocated((By) nameText,20);
        Reporter.log("Verifying name displayed"+"\n</br>");
        pmVerifyElements(nameText,fName.trim()+" "+lName.trim(),"wrong name displayed");
    }

    public void clickOnLogOutButton(){
        Reporter.log("Clicking on logout button"+"\n</br>");
        pmClickOnElement(logOutButton);
    }


}
