package io.testhubinua.ghost.applogic1;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import io.testhubinua.ghost.applogic.ApplicationManager;
import io.testhubinua.ghost.applogic.UserHelper;
import io.testhubinua.ghost.model.User;
import io.testhubinua.ghost.pages.UserManagementPage;
import io.testhubinua.ghost.pages.UserProfilePage;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class UserHelper1 extends DriverBasedHelper implements UserHelper {
  public UserHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

  
  @Override
  public void loginAs(User user) {
    pages.loginPage.ensurePageLoaded()
      .setEmailField(user.getEmail())
      .setPasswordField(user.getPassword())
      .clickSubmitButton();
  }	
  
  
  @Override
  public void loginAsPastePasswd(User user, String pattern, Integer length, ApplicationManager app) {
	  pages.loginPage.ensurePageLoaded()
      .setEmailField(user.getEmail());
	  //copypaste to password field
	  String passwd = pages.loginPage.passwd;
	  String str = StringUtils.repeat(pattern, length);
	  app.getClipboardHelper().setClipboardData(str);
	  pasteTextFromCipboardByName(passwd);
	  pages.loginPage.ensurePasswdIsFilled(str);
      pages.loginPage.clickSubmitButton();
  }	

  
  @Override
  public void loginAsPasteEmail(User user, String pattern, Integer length, ApplicationManager app) {
	  pages.loginPage.ensurePageLoaded()
      .setPasswordField(user.getPassword());
	  //copypaste to email field
	  String email = pages.loginPage.email;
	  String str = StringUtils.repeat(pattern, length);
	  app.getClipboardHelper().setClipboardData(str);
	  pasteTextFromCipboardByName(email);	  
	  pages.loginPage.ensureEmailIsFilled(str);
	  pages.loginPage.clickSubmitButton();
  }	

  
@Override
public void logout() {
	pages.internalPage.ensurePageLoaded();
	pages.internalPage.username().click();
	pages.internalPage.clickLogoutLink();
	pages.loginPage.ensurePageLoaded();
}


@Override
public boolean isNotLoggedIn() {
	return driver.getPageSource().contains("Forgotten password?");
}

//ApplicationManager is used as 2nd argument to use ClipbordHelper (necessary to get text from some elements).
@Override
public void ensureLoginAs(User user, ApplicationManager app){
	pages.internalPage.ensurePageLoaded();
	Assert.assertEquals((pages.internalPage.username().getText()).toLowerCase(), user.getUsername(), "Incorrect username on the internal page." );
	pages.internalPage.username().click();
	pages.internalPage.clickProfileLink();
	
	String css1 = UserProfilePage.username1CssLocator;
	String css2 = UserProfilePage.username2CssLocator;
	String css3 = UserProfilePage.username3CssLocator;
	String xpath4 = UserProfilePage.username4XpathLocator;
	String emailIdLocator = UserProfilePage.emailIdLocator;
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css1)));  
    WebElement un1 = driver.findElement(By.cssSelector(css1));
    WebElement un4 = driver.findElement(By.xpath(xpath4));
    //check username1,4 on the user profile page
	Assert.assertEquals(un1.getText().toLowerCase(), user.getUsername(), "Incorrect username1 on the user profile page." );
	Assert.assertEquals((un4.getText()).toLowerCase(), "/author/"+user.getUsername(), "Incorrect username4 on the user profile page." );
	//check username2
	copyTextToCipboardByCss(css2);
	String un2UPP = (String) app.getClipboardHelper().getClipboardData();
	Assert.assertEquals(un2UPP.toLowerCase(), user.getUsername(), "Incorrect username2 on the user profile page." );
	//check username3
	copyTextToCipboardByCss(css3);
	String un3UPP = (String) app.getClipboardHelper().getClipboardData();
	Assert.assertEquals(un3UPP.toLowerCase(), user.getUsername(), "Incorrect username3 on the user profile page." );
	//check email
	copyTextToCipboardById(emailIdLocator);
    String emailUPP = (String) app.getClipboardHelper().getClipboardData();
    Assert.assertEquals(emailUPP.toLowerCase(), user.getEmail(), "Incorrect email on the user profile page." );
	}


@Override
public void copyTextToCipboardById(String idLocator) {
	WebElement elem = driver.findElement(By.id(idLocator));
	elem.click();
	elem.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	elem.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}


@Override
public void copyTextToCipboardByCss(String cssLocator) {
	WebElement elem = driver.findElement(By.cssSelector(cssLocator));
	elem.click();
	elem.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	elem.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}


@Override
public void pasteTextFromCipboardByCss(String cssLocator) {
	WebElement elem = driver.findElement(By.cssSelector(cssLocator));
	elem.click();
	elem.clear();
	elem.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}


@Override
public void pasteTextFromCipboardByName(String nameLocator) {
	WebElement elem = driver.findElement(By.name(nameLocator));
	elem.click();
	elem.clear();
	elem.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

@Override
public void ensureNotificationMessageIsPresent() {
	pages.loginPage.ensureNotificationMessageIsPresent();
	}


@Override
public void ensurePageContainsText(String text) {
	Assert.assertTrue(driver.getPageSource().contains(text), "Incorrect text is shown on the page: "+ text);
	}


@Override
public void ensurePageContainsText(String text, String text1) {
	Assert.assertTrue(driver.getPageSource().contains(text), "Incorrect text is shown on the page. \n Expected: "+ text + "\nfor: " + text1);
	}


public String getConfirmationLink(String text) {
    Pattern regex = Pattern.compile("http\\S*");
    Matcher matcher = regex.matcher(text);
    if (matcher.find()) {
        return matcher.group();
    } else {
        return "";
    }
}


@Override
public void goToUserManagementPage() {
	String newUserBttn = UserManagementPage.newUserButtonLocator;
	pages.internalPage.ensurePageLoaded()
	.clickSettingsLink()
	.clickUserSettingsLink();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(newUserBttn)));
}


@Override
public void addNewUser(User user) {
	String newUserBttn = UserManagementPage.newUserButtonLocator;
	String newUserEmail = UserManagementPage.newUserEmailFieldLocator;
	String newUserRole = UserManagementPage.newUserRoleLocator;
	String newUserSubmitBttn = UserManagementPage.newUserSubmitButtonLocator;
	driver.findElement(By.cssSelector(newUserBttn)).click();
	String newUserWindow = driver.getWindowHandle();
	driver.switchTo().window(newUserWindow);
	//Fill the fields to add new user
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(newUserRole))));  
	driver.findElement(By.id(newUserEmail)).click();
	driver.findElement(By.id(newUserEmail)).clear();
	driver.findElement(By.id(newUserEmail)).sendKeys(user.getEmail());
	Select dropdown = new Select(driver.findElement(By.id(newUserRole)));
	dropdown.selectByVisibleText(user.getRole());
	driver.findElement(By.cssSelector(newUserSubmitBttn)).click();
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(newUserSubmitBttn)));  
	}


@Override
public void ensureUserIsAddedAs(User user) {
	String ump = UserManagementPage.umpLocator;
	wait.until(presenceOfElementLocated(By.cssSelector(ump)));
	ensurePageContainsText(user.getEmail().toString());
	}


@Override
public int countInvitedUsers() {
	 String revokeLinkText = UserManagementPage.revokeLinkText;
	 int count = 0;
     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(revokeLinkText)));
     List<WebElement> users = driver.findElements(By.linkText(revokeLinkText));
     for (int i = 0; i < users.size(); i++){
     count += 1; }
     return count;
	}

@Override
public List<WebElement> invitedUsersList() {
	 String revokeLinkText = UserManagementPage.revokeLinkText;
     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(revokeLinkText)));
     List<WebElement> users = driver.findElements(By.linkText(revokeLinkText));
     return users;
	}


@Override
public int countConfirmedUsers() {
	 String confirmedUsersCss = UserManagementPage.confirmedUsersCss;
	 int count = 0;
     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(confirmedUsersCss)));
     List<WebElement> users = driver.findElements(By.cssSelector(confirmedUsersCss));
     for (int i = 0; i < users.size(); i++){
     count += 1; }
     return count;
	}


@Override
public void revokeUser() {
	String revokeLinkText = UserManagementPage.revokeLinkText;
	driver.findElement(By.linkText(revokeLinkText)).click();
}


@Override
public void deleteUser(String user) {
	String newUserBttnCss = UserManagementPage.newUserButtonLocator;
	String settingsBttnCss = UserManagementPage.settingsBttnCss;
	String deleteBttnCss = UserManagementPage.deleteBttnCss;
	String acceptBttnCss = UserManagementPage.acceptBttnCss;
	
	driver.findElement(By.partialLinkText(user)).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(settingsBttnCss))).click();
	driver.findElement(By.cssSelector(deleteBttnCss)).click();

	// to handle popup window
	String newUserWindow = driver.getWindowHandle();
	driver.switchTo().window(newUserWindow)
	.findElement(By.cssSelector(acceptBttnCss)).click();
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(newUserBttnCss))); 
}


@Override
public void resendUser() {
	String resendLinkText = UserManagementPage.resendLinkText;
	driver.findElement(By.linkText(resendLinkText)).click();
}
}
