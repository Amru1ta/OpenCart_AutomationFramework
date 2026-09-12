package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class testBase  {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"sanity", "regression", "master"})
	@Parameters({"os","browser"})
	public void openLink(String os,String br) throws IOException {
		logger =LogManager.getLogger(this.getClass());
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				
				cap.setPlatform(Platform.WIN10);
			} 
			else if (os.equalsIgnoreCase("linux")){
				cap.setPlatform(Platform.LINUX);
				
			} else {
				System.out.println("No Matching Operating System");
				return;
			}
		
			
			//browser
			switch(br.toLowerCase()) {
			case "chrome": cap.setBrowserName("chrome");
			break;
			
			case "edge": cap.setBrowserName("MicrosoftEdge");
			break;
			
			case "firefox": cap.setBrowserName("firefox");
			break;
			
			default: System.out.println("No Matching Browser");
			return;
			}
			
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
		}
		
		
	
		//driver = new ChromeDriver(options);
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch (br.toLowerCase()) {
		case "chrome":
			          ChromeOptions options = new ChromeOptions ();
		              options.setAcceptInsecureCerts(true); 
			          driver=new ChromeDriver(options);
		              break;
		      
		case "edge":
			          EdgeOptions options1 = new EdgeOptions ();
		              options1.setAcceptInsecureCerts(true); 
			          driver=new EdgeDriver();
	                  break;
	      
		case "firefox": 
			          FirefoxOptions options2 = new FirefoxOptions ();
		              options2.setAcceptInsecureCerts(true);
			          driver=new FirefoxDriver();
	                  break;
	      
		default : System.out.println("Invalid option selected");
	      return;
		      }
		}
		
		driver.get(p.getProperty("appURL2"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"sanity", "regression", "master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomstring() {
		String generatedstring = RandomStringUtils.insecure().nextAlphabetic(5);
		return generatedstring;
		
	}
	
	public String randomnumber() {
		String generatednumber = RandomStringUtils.insecure().nextNumeric(10);
		return generatednumber;
		
	}
	
	public String randomalphanumeric() {
		String generatedalphanum = RandomStringUtils.insecure().nextAlphanumeric(5);
		return generatedalphanum;
		
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat ("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+ "\\screenshots\\"+ tname + "_" + timeStamp;
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		}
	

}
