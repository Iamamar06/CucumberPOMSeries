package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	private WebDriver driver;
	
	//1 By Locators
	private By emailId = By.xpath("//input[@id='email']");
	private By passowrdLocator = By.xpath("//input[@id='pass']");
	private By signInButton = By.xpath("//button[@class='action login primary']");
	private By forgotYourPasswordLinkLocator = By.xpath("//span[contains(text(),'Forgot Your Password?')]/..");
	private By errorMessageLocator = By.xpath("//div[@class='message-error error message']");
	
	//2. Construtor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions: features of the page in form of methods
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnForgotPasswordLink() {
		driver.findElement(forgotYourPasswordLinkLocator).click();
	}
	
	public void enterUsernameAndPassword(String username, String password) {
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(passowrdLocator).clear();
		driver.findElement(passowrdLocator).sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		driver.findElement(signInButton).click();
	}

	public String verifyErrorMessageIsDisplayedForInvalidCreds() {
		return driver.findElement(errorMessageLocator).getText();
	}

	public boolean verifyForgotYourpasswordLinkIsDisplayed() {
		return driver.findElement(forgotYourPasswordLinkLocator).isDisplayed();
	}
}
