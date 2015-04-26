package io.testhubinua.ghost.applogic1;

import io.testhubinua.ghost.applogic.NavigationHelper;
import io.testhubinua.ghost.pages.InternalPage;


public class NavigationHelper1 extends DriverBasedHelper implements NavigationHelper {

  private String baseUrl;

  public NavigationHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
    this.baseUrl = manager.getBaseUrl();
  }

  @Override
  public void openMainPage() {
    driver.get(baseUrl);
  }

  @Override
  public void openRelativeUrl(String url) {
    driver.get(baseUrl + url);
  }

  @Override
  public void openLoginPage() {
    driver.get(baseUrl + "ghost/signin/");
  }


}
