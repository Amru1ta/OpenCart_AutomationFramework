package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {
  WebDriver driver;
	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy (xpath="//input[@name=\"firstname\"]") WebElement firstname;
	
	@FindBy (xpath="//input[@name=\"lastname\"]") WebElement lastname;
	
	@FindBy (xpath="//input[@name=\"email\"]") WebElement email;
	
	@FindBy (xpath="//input[@name=\"telephone\"]") WebElement telephone;
	
	@FindBy (xpath="//input[@name=\"password\"]") WebElement password;
	
	@FindBy (xpath="//input[@name=\"confirm\"]") WebElement confirm;
	
    @FindBy (xpath="//input[@name=\"agree\"]") WebElement agree;
    
    @FindBy (xpath="//input[@value=\"Continue\"]") WebElement presscontinue;
	
    @FindBy (xpath="//h1[text()='Your Account Has Been Created!']") WebElement accountCreated;
      
    public void enterFirstName (String name1) {
    	firstname.sendKeys(name1);
    }
    
    public void enterLastName (String name2) {
    	lastname.sendKeys(name2);
    }
    
    public void enterEmail (String email1) {
    	email.sendKeys(email1);
    }
    
    public void enterTelephone (String telephone1) {
    	telephone.sendKeys(telephone1);
    }
    
    public void enterPassword (String password1) {
    	password.sendKeys(password1);
    }
    
    public void enterConfirm (String confirm1) {
    	confirm.sendKeys(confirm1);
    }
    
    public void termcond () {
    	agree.click();
    }
    
    public void clickRegister () {
    	presscontinue.click();
    }
    
    public String accountConfirmation() {
    	String a = accountCreated.getText();
    	return a; 
    }
    
}
