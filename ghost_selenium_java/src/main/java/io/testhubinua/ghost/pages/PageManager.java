package io.testhubinua.ghost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageManager {

  private WebDriver driver;

  public LoginPage loginPage;
  public InternalPage internalPage;
  public UserProfilePage userProfilePage;
  public UserManagementPage userManagementPage;
  public PostPage postPage;

  public PageManager(WebDriver driver) {
    this.driver = driver;
    loginPage = initElements(new LoginPage(this));
    internalPage = initElements(new InternalPage(this));
    postPage = initElements(new PostPage(this));
    }

  private <T extends Page> T initElements(T page) {
    PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 20), page);
    return page;
  }

  public WebDriver getWebDriver() {
    return driver;
  }

}
