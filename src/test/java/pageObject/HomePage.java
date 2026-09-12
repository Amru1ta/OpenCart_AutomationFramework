package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//span[text()='My Account']") WebElement myaccount;
	@FindBy(xpath="//a[text()='Register']") WebElement register;
	@FindBy(xpath="//a[text()='Login']") WebElement login;
	
	public void clickmyaccount() {
		myaccount.click();;
	}
	public void clickregister() {
		register.click();;
	}
	public void clicklogin() {
		login.click();
	}
	
	

}
