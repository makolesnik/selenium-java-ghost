package io.testhubinua.ghost;

import io.testhubinua.ghost.model.User;
import io.testhubinua.ghost.util.ExcelUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class InviteUserTest extends io.testhubinua.ghost.pages.TestBase {
	
  
	  @BeforeMethod
	  public void mayBeLogout() {
		app.getNavigationHelper().openLoginPage();
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }

	  
	  @Test(dataProvider = "validInvite")
	    public void inviteUserTest(String email, String role) throws Exception {
		  User user = new User()
		    .setEmail(email)
		    .setRole(role);	   
		  
		  app.getUserHelper().loginAs(OWNER);
		  app.getUserHelper().goToUserManagementPage();
   	      //int countBefore = app.getUserHelper().countInvitedUsers();
		  int countBefore = app.getUserHelper().invitedUsersList().size();
	      app.getUserHelper().addNewUser(user);		   
	      Thread.sleep(500);
	      //int countAfter = app.getUserHelper().countInvitedUsers();
	      int countAfter = app.getUserHelper().invitedUsersList().size();
	      Assert.assertEquals(countAfter, (countBefore + 1));
	      app.getUserHelper().ensurePageContainsText(user.getEmail().replaceAll(" ", ""));
	    }

	  
	  //@Test(dataProvider = "invalidInvite")
	    public void invalidInviteTest(String email, String role) throws Exception {
		  User user = new User()
		    .setEmail(email)
		    .setRole(role);    
  	      app.getUserHelper().loginAs(OWNER);
	      app.getUserHelper().goToUserManagementPage();
	      int countBefore = app.getUserHelper().countInvitedUsers();
          app.getUserHelper().addNewUser(user);		   
          app.getUserHelper().ensureNotificationMessageIsPresent();
          app.getUserHelper().ensurePageContainsText("Please supply a valid email address", user.getEmail());
          Thread.sleep(100);
          int countAfter = app.getUserHelper().countInvitedUsers();
          Assert.assertEquals(countAfter, (countBefore));
	    }

	  
	   @DataProvider
	    public Object[][] validInvite() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//InviteUserTest.xlsx","validInvite");
	         return (testObjArray);
			}
	
	   @DataProvider
	    public Object[][] invalidInvite() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//InviteUserTest.xlsx","invalidInvite");
	         return (testObjArray);
			}
}