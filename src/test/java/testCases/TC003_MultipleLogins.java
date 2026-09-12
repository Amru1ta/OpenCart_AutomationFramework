package testCases;


import org.testng.annotations.Test;

import Utilities.DataProviderMultiple;
import junit.framework.Assert;
import pageObject.AccountLoginPage;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import testBase.testBase;


public class TC003_MultipleLogins extends testBase {

	@Test (dataProvider="dp", dataProviderClass=DataProviderMultiple.class)
	public void multipleloginmethod(String username, String password, String res) {
		try {
			logger.info("***TC003_Started***");
  HomePage hp = new HomePage (driver);
  hp.clickmyaccount();
  hp.clicklogin();
  
  AccountLoginPage ap = new AccountLoginPage(driver);
  ap.loginemail(username);
  ap.loginpassword(password);
  ap.buttonlogin();
  
  
  MyAccountPage mp = new MyAccountPage(driver);
  boolean value = mp.text();
 
  
  /* Data is Valid - login success - test passed - logout
   *                 login failed - test failed
   * Data is Invalid - login success - test failed - logout
   *                   login failed - test passed
   */
  
  if (res.equalsIgnoreCase("valid")) {
	  if (value==true) {
		  System.out.println("Logged in successfully");
		  mp.clicklogout(); 
		  Assert.assertTrue(true);
	  }  else {
		  System.out.println("Login Failed, test failed");
		  Assert.assertTrue(false);
	  }
		
	  }
  
	
	if (res.equalsIgnoreCase("invalid")) {
		if (value==true) {
			System.out.println("Logged in successfully with invalid data");
			mp.clicklogout(); 
			Assert.assertTrue(false);
		} else {
			System.out.println("Login Failed, test passed");
			Assert.assertTrue(true);
		}
	}
		
	} catch (Exception e) {
		Assert.fail();
	}
  
  
	logger.info("***TC003_Finished***");

	
	

	
}
}
