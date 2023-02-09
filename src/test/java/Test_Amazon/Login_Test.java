package Test_Amazon;

import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import javax.xml.crypto.dsig.SignedInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


import Core_Pack.OpenBrowsers;
import Core_Amazon.UserCredentials;
import Core_Amazon.EmailLogin;
import Core_Amazon.Login_Page;
import Core_Amazon.PasswordLogin;
import Core_Amazon.SignIn;

public class Login_Test extends BaseTest{
	
    @Test
    public void testLogin() throws IOException {
        SignIn signIn = new SignIn(driver);
        EmailLogin emailLogin = new EmailLogin(driver);
        PasswordLogin passLogin = new PasswordLogin(driver);
        
        signIn.clickSignIn();
        UserCredentials cred = new UserCredentials();
        String username = cred.getUserName();
		String password = cred.getPass();
		
        waitForElementToBeClickable(emailLogin.getEmailField());
        emailLogin.fillEmail(username);
        waitForElementToBeClickable(emailLogin.getContinueBtn());
        emailLogin.continueClick();
        waitForElementToBeClickable(passLogin.getSubmitBtn());
        passLogin.fillPassword(password);
        waitForElementToBeClickable(passLogin.getSubmitBtn());
        passLogin.logIn();       
    }
	
    @AfterTest
    public void tearDown() {
      driver.quit();
    }
	 
}
