package browser_Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;



public class browser {

	String url="https://stages4.inhouse.net/";
	@Test
	public static  WebDriver getdriver (String type, String url) throws InterruptedException{
		WebDriver d = null;

		if( type.equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver",( System.getenv("GECKO_DRIVER")));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities. setCapability("marionette",true);
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless"); 
		    d = new FirefoxDriver(options);
		}
		else if ( type.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\nandu\\Desktop\\selenium\\driver\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--headless");
		   // d = new ChromeDriver(chromeOptions);
		}
		else if ( type.equalsIgnoreCase("SAFARI"))
		{
			System.setProperty("webdriver.Safari.driver",( System.getenv("safaridriver")));
			//d= new SafariDriver();	
		}
		else 
		{
			Assert.assertFalse(false, "NO BROWSER TYPE SENT");
		}
		d.get(url);
		d.manage().window().maximize();
		Thread.sleep(2000);
		return d;

	}
}


