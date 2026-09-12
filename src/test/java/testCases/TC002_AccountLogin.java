package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.AccountLoginPage;
import pageObject.AccountRegisterationPage;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import testBase.testBase;

public class TC002_AccountLogin extends testBase {
	
	@Test(groups= {"sanity", "master"})
	public void loginpage()
	{
		logger.info("***Starting TC002***");
		HomePage hp = new HomePage (driver);
		
		logger.info("Clicked On My Account");
		hp.clickmyaccount();
		logger.info("Clicked on Login");
		hp.clicklogin();
		
		logger.info("Entering login information");
		AccountLoginPage ap = new AccountLoginPage (driver);
		ap.loginemail(p.getProperty("email"));
		ap.loginpassword(p.getProperty("password"));
		ap.buttonlogin();
		
		MyAccountPage mp = new MyAccountPage (driver);
		boolean textcompare = mp.text();
		Assert.assertTrue(textcompare);
		logger.info("Logged in successfully, now we are on my acount page");
		
	}
}
