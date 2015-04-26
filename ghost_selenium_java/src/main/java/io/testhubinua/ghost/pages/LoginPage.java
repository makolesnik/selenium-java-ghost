package io.testhubinua.ghost.pages;

import io.testhubinua.ghost.model.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LoginPage extends AnyPage {

	
	public LoginPage(PageManager pages) {
		super(pages);
	}

	public static String passwd = "password";	
	public static String email = "identification";
	
  @FindBy(name = "identification")
  private WebElement emailField;

  @FindBy(name = "password")
  private WebElement passwordField;

  @FindBy(css = "#login > button")
  private WebElement submitButton;
  
  public LoginPage setEmailField(String text) {
	emailField.click();
	emailField.clear();
    emailField.sendKeys(text);
    return this;
  }

  public LoginPage setPasswordField(String text) {
	passwordField.click();
	passwordField.clear();
    passwordField.sendKeys(text);
    return this;
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public LoginPage ensureEmailIsFilled(String email) {
	    super.ensurePageLoaded();
	    wait.until(ExpectedConditions.textToBePresentInElement(emailField, email));
	    return this;
	  }

  public LoginPage ensurePasswdIsFilled(String passwd) {
	    super.ensurePageLoaded();
	    wait.until(ExpectedConditions.textToBePresentInElement(passwordField, passwd));
	    return this;
	  }  
  
  public LoginPage ensureNotificationMessageIsPresent() {
	    super.ensurePageLoaded();
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("notification-message")));
	    return this;
	  }    
  
  
  public LoginPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.id("login")));
    return this;
  }
  
}
