package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	
public AccountLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    @FindBy (xpath="//input[@placeholder=\"E-Mail Address\"]") WebElement emaillogin;
    
    @FindBy (xpath="//input[@placeholder=\"Password\"]") WebElement passwordlogin;
    
    @FindBy (xpath="//input[@value=\"Login\"]") WebElement loginbutton;
    

    
    public void loginemail (String emailforlogin) {
    	emaillogin.sendKeys(emailforlogin);
    }
    
    public void loginpassword (String passwordforlogin) {
    	passwordlogin.sendKeys(passwordforlogin);
    }
    
    public void buttonlogin () {
    	loginbutton.click();
    }
    
    

}
