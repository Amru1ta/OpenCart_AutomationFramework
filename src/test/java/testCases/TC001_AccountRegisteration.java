package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegisterationPage;
import pageObject.HomePage;
import testBase.testBase;


public class TC001_AccountRegisteration extends testBase {

	
	
	@Test(groups= {"regression", "master"})
	public void verify_public_registeration() {
		logger.info("**Starting Test Case 001**");
		HomePage hp = new HomePage(driver);
		
		logger.info("Clicked On My Account");
		hp.clickmyaccount();
		
		logger.info("Clicked On Register");
		hp.clickregister();
		
		AccountRegisterationPage accountregister = new AccountRegisterationPage (driver);
		
		logger.info("Registeration Details......");
		accountregister.enterFirstName(randomstring());
		accountregister.enterLastName(randomstring());
		accountregister.enterEmail(randomstring()+randomnumber()+"@gmail.com");
		accountregister.enterTelephone(randomnumber());
		
		String a = randomalphanumeric();
		accountregister.enterPassword(a);
		accountregister.enterConfirm(a);
		accountregister.termcond();
		accountregister.clickRegister();
		
		String createdaccount = accountregister.accountConfirmation();
		logger.info("**Registeration Completed..........");
		Assert.assertEquals(createdaccount, "Your Account Has Been Created!");
		
		}
	
	

}
