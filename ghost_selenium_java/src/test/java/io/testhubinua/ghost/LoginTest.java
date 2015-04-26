package io.testhubinua.ghost;

import io.testhubinua.ghost.model.User;
import io.testhubinua.ghost.util.ExcelUtils;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends io.testhubinua.ghost.pages.TestBase {

	  @BeforeMethod
	  public void mayBeLogout() {
		app.getNavigationHelper().openLoginPage();
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }


	  @Test(dataProvider = "validLogin")
	  public void aa_validLogin(String email, String password) throws Exception {
		  User user = new User().setEmail(email).setPassword(password).setUsername(OWNER.getUsername()); 
		  app.getUserHelper().loginAs(user);
		  app.getUserHelper().ensureLoginAs(OWNER, app);
	  }
	  

	  @Test(dataProvider = "invalidEmail")
	  public void a_invalidEmail(String email, String password) throws Exception {
		User user = new User().setEmail(email).setPassword(password); 
	    app.getUserHelper().loginAs(user);
	    app.getUserHelper().ensureNotificationMessageIsPresent();
	    app.getUserHelper().ensurePageContainsText("Invalid Email");
	  }

	  
	  @Test(dataProvider = "blankEmail")
	  public void blankEmail(String email, String password) throws Exception {
		
		User user = new User().setEmail(email).setPassword(password); 
	    app.getUserHelper().loginAs(user);
	    app.getUserHelper().ensureNotificationMessageIsPresent();
	    app.getUserHelper().ensurePageContainsText("Invalid Email");
	  }
	  

	  @Test(dataProvider = "incorrectPassword")
	  public void incorrectPasswd(String email, String password) throws Exception {
		User user	= new User().setEmail(email).setPassword(password); 
	    app.getUserHelper().loginAs(user);
	    Thread.sleep(1000);
	    app.getUserHelper().ensurePageContainsText("Your password is incorrect. ");
	    }


	  @Test(dataProvider = "invalidPassword")
	  public void aaa_invalidPasswd(String email, String password) throws Exception {
		User user	= new User().setEmail(email).setPassword(password); 
	    app.getUserHelper().loginAs(user);
	    app.getUserHelper().ensureNotificationMessageIsPresent();
	    app.getUserHelper().ensurePageContainsText("Please enter a password");
	    }
	  
	  
	  @Test(dataProvider = "validNotRegisteredEmail")
	  public void notRegisteredEmail(String email, String password) throws Exception {
		User user	= new User().setEmail(email).setPassword(password); 
	    app.getUserHelper().loginAs(user);
	    app.getUserHelper().ensureNotificationMessageIsPresent();
	    app.getUserHelper().ensurePageContainsText("There is no user with that email address.");
	    }	
	  
	  
	  @Test
	  public void blankEmailAndPasswd() throws Exception {
		User user	= new User().setEmail("").setPassword(""); 
	    app.getUserHelper().loginAs(user);
	    app.getUserHelper().ensureNotificationMessageIsPresent();
	    app.getUserHelper().ensurePageContainsText("Please enter an email");
	    app.getUserHelper().ensurePageContainsText("Please enter a password");
	    
	    }
	  
	  
	  @DataProvider
	    public Object[][] validLogin() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//LoginTest.xlsx","validLogin");
	         return (testObjArray);
			}	  

	   @DataProvider
	    public Object[][] incorrectPassword() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//LoginTest.xlsx","incorrectPassword");
	         return (testObjArray);
			}	

	   @DataProvider
	    public Object[][] invalidPassword() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//LoginTest.xlsx","invalidPassword");
	         return (testObjArray);
			}	
	   
	   @DataProvider
	    public Object[][] invalidEmail() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//LoginTest.xlsx","invalidEmail");
	         return (testObjArray);
			}	 
	   
	   @DataProvider
	    public Object[][] blankEmail() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//LoginTest.xlsx","blankEmail");
	         return (testObjArray);
			}
	   
	   @DataProvider
	    public Object[][] validNotRegisteredEmail() throws Exception{
	         Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//LoginTest.xlsx","validNotRegEmail");
	         return (testObjArray);
			}
}
