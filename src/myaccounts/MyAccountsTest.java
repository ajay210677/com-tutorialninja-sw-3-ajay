package myaccounts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {


    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void selectMyAccountOptions(String option) throws InterruptedException {
//This method should click on the options
        List<WebElement> elements = driver.findElements(By.xpath("//body/footer[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/a[1]"));
        for (WebElement element1 : elements) {
            if (element1.getText().equalsIgnoreCase(option)) {
                Thread.sleep(2000);
                element1.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //Click on My Account link
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //Verify the text "Register Account"
        verifyElements("Register Account", By.xpath("//h1[contains(text(),'Register Account')]"), "Correct text");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //Click on My Account link
        clickOnElement(By.xpath("//a[@title='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //Verify the text "Returning Customer"
        verifyElements("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"), "Correct text");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //Click on "My Account" link
        clickOnElement(By.xpath("//a[@title='My Account']"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "RajaRam");
        //Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Upadhyay");
        // Enter Email
        sendTextToElement(By.xpath(" //input[@id='input-email']"), "raja1234@gmail.com");
        // Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "084512356568");
        // Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "abcd123");
        // Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "abcd123");
        // Select Subscribe Yes radio button
        clickOnElement(By.cssSelector("input[value='1'][name='newsletter']"));
        // Click on Privacy Policy check box
        clickOnElement(By.xpath("input[value='1'][name='newsletter']"));
        clickOnElement(By.cssSelector("input[value='1'][name='agree']"));
        // Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // Verify the message “Your Account Has Been Created!”
        verifyElements("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Register unsuccessfull");
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        // Verify the text “Account Logout”
        verifyElements("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"), "Not logout successfully");
        // Click on Continue button
        clickOnElement(By.xpath(" //a[normalize-space()='Continue']"));

    }

    @Test
    public void verifyThatUserRegisterAccountSucessfully() throws InterruptedException {
        // Click on My Account Link.
        mouseHoverToElementAndClick(By.xpath("//a[@title='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//a[normalize-space()='Login']"));
        // Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "vipatel@gmail.com");
        // Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "123456");
        // Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        // Verify text “My Account”
        verifyElements("My Account", By.xpath("//h2[contains(text(),'My Account')]"), "correct text");
        // Clickr on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        // Verify the text “Account Logout”
        verifyElements("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"), "correct text");
        // Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    public void tearDown() {
        closeBrowser();
    }


}
