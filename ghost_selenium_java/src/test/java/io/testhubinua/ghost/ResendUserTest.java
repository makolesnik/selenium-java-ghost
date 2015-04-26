package io.testhubinua.ghost;

import io.testhubinua.ghost.model.User;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResendUserTest extends io.testhubinua.ghost.pages.TestBase {

	
	  @BeforeMethod
	  public void mayBeLogout() {
		app.getNavigationHelper().openLoginPage();
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	  

	  @Test
	    public void resendUser() throws Exception {
		    User user = new User()
		    .setEmail("user123"+ System.currentTimeMillis() +"@localhost.localdomain")
		    .setRole("Editor");   
		  
		    app.getUserHelper().loginAs(OWNER);
		    app.getUserHelper().goToUserManagementPage();
		    app.getUserHelper().addNewUser(user);
		    Thread.sleep(100);
		    int countBefore = app.getUserHelper().countInvitedUsers();
		    app.getUserHelper().resendUser();
		    int countAfter = app.getUserHelper().countInvitedUsers();
	        Assert.assertEquals(countAfter, countBefore, "Invite is not resent");
	    }
}