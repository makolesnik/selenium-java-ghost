package io.testhubinua.ghost.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserProfilePage extends AnyPage {
	
	public static String username1CssLocator = ".ember-view header.settings-subview-header.clearfix h2.page-title";
	public static String username2CssLocator = ".ember-view div.content.settings-user form.user-profile fieldset.user-details-top div.form-group.first-form-group input#user-name.ember-view.ember-text-field.user-name";
	public static String username3CssLocator = ".ember-view div.content.settings-user form.user-profile fieldset.user-details-bottom div.form-group input#user-slug.ember-view.ember-text-field.user-name";
	public static String username4XpathLocator = "//div/form/fieldset[2]/div[1]/p";
	public static String emailIdLocator = "user-email";
	
	
	public UserProfilePage(PageManager pages) {
		super(pages);

	}
	
	
	
	 @FindBy(css = ".ember-view header.settings-subview-header.clearfix h2.page-title")
	  private WebElement username1;

	 @FindBy(css = ".ember-view div.content.settings-user form.user-profile fieldset.user-details-top div.form-group.first-form-group input#user-name.ember-view.ember-text-field.user-name")
	  private WebElement username2;
	 
	 @FindBy(css = ".ember-view div.content.settings-user form.user-profile fieldset.user-details-bottom div.form-group input#user-slug.ember-view.ember-text-field.user-name")
	  private WebElement username3;
	 
	 @FindBy(xpath = ".//*[@id='user-email']")
	  private WebElement username4;


	 @FindBy(xpath = "//div/form/fieldset[2]/div[1]/p")
	  private WebElement email;

	 @FindBy(css = ".ember-view div.content.settings-user figure.user-cover")
	  private WebElement profileNav;

	 public String getUsername1CssLocator() {
		    return ".ember-view header.settings-subview-header.clearfix h2.page-title";
     }
	 
	  public WebElement username1() {
		    return username1;
      }

	  public WebElement username2() {
		    return username2;
    }
	  public WebElement username3() {
		    return username3;
    }
	  public WebElement username4() {
		    return username4;
    }
	  
	  public WebElement email() {
		    return email;
    }
	  
	  public WebElement profileNav() {
		    return profileNav;
    }
	  
	  public UserProfilePage ensurePageLoaded() {
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".user-cover")));  
		  return this;
	  }	
}
