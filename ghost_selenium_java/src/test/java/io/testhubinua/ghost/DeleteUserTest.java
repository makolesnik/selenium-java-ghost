package io.testhubinua.ghost;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeleteUserTest extends io.testhubinua.ghost.pages.TestBase {
	
  
	  @BeforeMethod
	  public void mayBeLogout() {
		app.getNavigationHelper().openLoginPage();
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	  
  
	  @Test
	    public void deleteUser() throws Exception {
		  	String user = "saga9119+7777";
		    app.getUserHelper().loginAs(OWNER);
		    app.getUserHelper().goToUserManagementPage();
		    int countBefore = app.getUserHelper().countConfirmedUsers();
		    app.getUserHelper().deleteUser(user);
		    int countAfter = app.getUserHelper().countConfirmedUsers();
	        Assert.assertEquals(countAfter, (countBefore - 1), "User "+ user +" is not deleted" );
	    }
}