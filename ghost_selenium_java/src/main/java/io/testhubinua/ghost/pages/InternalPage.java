package io.testhubinua.ghost.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);

	}
	
	 @FindBy(css = "div.name")
	  private WebElement username;
	
	 @FindBy(css = ".ember-view.dropdown-item.user-menu-profile.js-nav-item")
	  private WebElement profileLink;
	
	 @FindBy(css = ".ember-view.dropdown-item.user-menu-signout")
	  private WebElement logoutLink;	
	 
	 @FindBy(css = ".ember-view.nav-item.nav-settings")
	  private WebElement settingsLink;	
	 
	 @FindBy(css = ".settings-nav-users.icon-users a")
	  private WebElement userSettingsLink;	
	 	 
	 
	  public WebElement username() {
		    return username;
	  }
	  public WebElement profileLink() {
		    return profileLink;
	  }
	  
	  public WebElement logoutLink() {
		    return logoutLink;
	  }
	  
	  public WebElement settingsLink() {
		    return settingsLink;
	  }

	  public WebElement userSettingsLink() {
		    return userSettingsLink;
	  }
	  
	  public void clickProfileLink() {
		    profileLink.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ember-view div.content.settings-user figure.user-cover")));  
			  
	  }
	  
	  public void clickLogoutLink() {
		    logoutLink.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ember-view.dropdown-item.user-menu-signout")));  
			  
	  }
	  
	  public InternalPage clickSettingsLink() {
		    settingsLink.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".settings-nav-users.icon-users a")));
		    return this;
			  
	  }

	  public UserManagementPage clickUserSettingsLink() {
		    userSettingsLink.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content.settings-users")));  
		    return pages.userManagementPage;
			  
	  }
	  
	  public InternalPage ensurePageLoaded() {
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("nav.global-nav")));  
		  return this;
	  }	
	  
}