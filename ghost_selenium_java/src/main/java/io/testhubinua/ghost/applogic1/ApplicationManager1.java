package io.testhubinua.ghost.applogic1;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.testhubinua.ghost.applogic.ApplicationManager;
import io.testhubinua.ghost.applogic.ClipboardHelper;
import io.testhubinua.ghost.applogic.PostHelper;
import io.testhubinua.ghost.applogic.NavigationHelper;
import io.testhubinua.ghost.applogic.UserHelper;
import io.testhubinua.ghost.util.Browser;
import io.testhubinua.ghost.util.PropertyLoader;
import io.testhubinua.ghost.webdriver.WebDriverFactory;


public class ApplicationManager1 implements ApplicationManager {

  private UserHelper userHelper;
  private PostHelper postHelper;
  private NavigationHelper navHelper;
  private ClipboardHelper clipHelper;


  private WebDriver driver;
  private String baseUrl;
  private Properties properties;
  
  public ApplicationManager1() {
    baseUrl = PropertyLoader.loadProperty("site.url");
    String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

    Browser browser = new Browser();
    browser.setName(PropertyLoader.loadProperty("browser.name"));
    browser.setVersion(PropertyLoader.loadProperty("browser.version"));
    browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

    String username = PropertyLoader.loadProperty("user.username");
    String password = PropertyLoader.loadProperty("user.password");
    
    driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);

    userHelper = new UserHelper1(this);
    postHelper = new PostHelper1(this);
    navHelper = new NavigationHelper1(this);
    clipHelper = new ClipboardHelper1(this);


    getNavigationHelper().openMainPage();
  }
  
  @Override
  public UserHelper getUserHelper() {
    return userHelper;
  }

  @Override
  public PostHelper getPostHelper() {
    return postHelper;
  }

  @Override
  public NavigationHelper getNavigationHelper() {
    return navHelper;
  }

  @Override
  public ClipboardHelper getClipboardHelper() {
    return clipHelper;
  }
  
  
  protected WebDriver getWebDriver() {
    return driver;
  }

  protected String getBaseUrl() {
    return baseUrl;
  }
  
  public ApplicationManager1(Properties properties) {
      this.properties = properties;
      baseUrl = properties.getProperty("baseUrl");
  }
  public String getProperty(String key) {
      return properties.getProperty(key);
  }
  

  @Override
  public void stop() {
    if (driver != null) {
      driver.quit();
    }
  }
}
