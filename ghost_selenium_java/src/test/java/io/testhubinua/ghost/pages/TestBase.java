package io.testhubinua.ghost.pages;

import io.testhubinua.ghost.applogic.ApplicationManager;
import io.testhubinua.ghost.applogic1.ApplicationManager1;
import io.testhubinua.ghost.model.User;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class TestBase {

  public static User OWNER	= new User().setEmail("saga9119+2@gmail.com").setPassword("qwer12345").setUsername("saga");
	
  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager1();
	}

	@AfterSuite
	public void stop() {
	  app.stop();
	}
	


}
