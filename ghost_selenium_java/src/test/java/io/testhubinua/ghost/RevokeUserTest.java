package io.testhubinua.ghost;

import io.testhubinua.ghost.model.User;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RevokeUserTest extends io.testhubinua.ghost.pages.TestBase {
	
  
	  @BeforeMethod
	  public void mayBeLogout() {
		app.getNavigationHelper().openLoginPage();
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }

	  
	  @Test(dataProvider = "userData")
	    public void revokeUser(String email, String role) throws Exception {
		    User user = new User()
		    .setEmail(email)
		    .setRole(role);	    
		  
		    app.getUserHelper().loginAs(OWNER);
		    app.getUserHelper().goToUserManagementPage();
		    app.getUserHelper().addNewUser(user);
		    Thread.sleep(100);
		    int countBefore = app.getUserHelper().countInvitedUsers();
		    app.getUserHelper().revokeUser();
		    Thread.sleep(100);
		    int countAfter = app.getUserHelper().countInvitedUsers();
	        Assert.assertEquals(countAfter, (countBefore - 1), "Invite is not revoked for user: " + user.getEmail() );
	    }

	  
	   @DataProvider(name = "userData")
	   public static Object[][] userData() {
	      return new Object[][] {{"user1"+ System.currentTimeMillis() +"@localhost.localdomain", "Administrator"}, 
	    		  				 {"user2"+ System.currentTimeMillis() +"@localhost.localdomain", "Editor"}, 
	    		  				 {"user3"+ System.currentTimeMillis() +"@localhost.localdomain", "Author"}};
	   }
}