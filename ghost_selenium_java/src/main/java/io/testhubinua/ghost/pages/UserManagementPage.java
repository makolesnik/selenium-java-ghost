package io.testhubinua.ghost.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class UserManagementPage extends AnyPage {

	public UserManagementPage(PageManager pages) {
		super(pages);
	}
	
	  public static String newUserButtonLocator = ".ember-view.js-users-list-view.users-list-wrapper header.settings-view-header.user-list-header section.page-actions";
	  public static String newUserEmailFieldLocator = "new-user-email";
	  public static String newUserSubmitButtonLocator = ".btn.btn-green.js-button-accept";
	  public static String newUserRoleLocator = "new-user-role";
	  public static String invitedUsersLocator = "section.user-list.invited-users";
	  public static String notificationLocator = "notification-message";
	  public static String umpLocator = ".content.settings-users";
	  public static String settingsBttnCss = ".ember-view.btn.btn-default.only-has-icon.user-actions-cog.closed";
	  public static String deleteBttnCss = ".ember-view.ghost-dropdown.user-actions-menu.dropdown-menu.dropdown-triangle-top-right.fade-in-scale.open li button.delete";
	  public static String acceptBttnCss = ".js-button-accept";
	  public static String confirmedUsersCss = ".ember-view.user-list-item div.user-list-item-body";
	  public static String revokeLinkText = "REVOKE";
	  public static String resendLinkText = "RESEND";
	  

	  @FindBy(css = ".user-list-header section.page-actions")
	  private WebElement newUserButton;
	  
	  @FindBy(id = "new-user-email")
	  private WebElement newUserEmailField;	  
	  
  
	  @FindBy(css = ".js-button-accept")
	  private WebElement newUserSubmitButton;		  
	  
	  @FindBy(linkText = "REVOKE")
	  private WebElement revokeButton;			  

	  
	  public  UserManagementPage clickNewUserButton() {
		    WebElement bttn = driver.findElement(By.cssSelector(newUserButtonLocator));
		    bttn.click();
		    return this;
	  }	  

	  
	  public UserManagementPage clicknewUserSubmittButton() {
		    newUserSubmitButton.click();
		    return this;
	  }	  
	  

	  public UserManagementPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.cssSelector(".content.settings-users")));
	    return this;
		  }

	  
	public List<WebElement> usersList() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("REVOKE")));
	    List<WebElement> users = driver.findElements(By.linkText("REVOKE"));
	    return users;
	}

	
	public void clickRevokeButton() {
		revokeButton.click();
	}
}
