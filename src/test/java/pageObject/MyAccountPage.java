package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage  {
    public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//h2[text()='My Account']") WebElement text1;
	@FindBy (xpath="(//a[text()='Logout'])[2]") WebElement logout;
	
	public boolean text ()
    {
    	try{
    		return text1.isDisplayed();
    		
    	}
    	
    catch (Exception e) {
    	return false;
    }
    }
	
	public void clicklogout() {
		logout.click();
	}

	

}
