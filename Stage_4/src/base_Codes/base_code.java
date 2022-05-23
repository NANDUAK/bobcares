package base_Codes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class base_code {

		WebDriver d;
		public base_code(WebDriver d) 
		{
			this.d=d;
		}
		@FindBy(how=How.NAME,using="username")
		private WebElement userNameField;

		@FindBy(how=How.NAME,using="password")
		private WebElement passWordField;

		@FindBy(how=How.NAME,using = "Login")
		private WebElement login;

		//methods

		public void setuserNamefield(String arg)
		{
			userNameField.sendKeys(arg);
			Reporter.log("username is " + arg ,true);
		}
		public void setpassWodField(String arg)

		{
			passWordField.sendKeys(arg);
			Reporter.log("password is " +arg ,true);

		} 

		public void click_login()
		{
			login.click();
			Reporter.log("click_login");
		}
		
		public void clickbyxpath(String String) {
			
		d.findElement(By.xpath(String));
		}
		
		public void clickbyname(String String) {
			
			d.findElement(By.name(String)).click();
			}
		public void clickbyid(String String) {
			
			d.findElement(By.id(String)).click();
			}
		
		public void sendkeysbyxpath(String String ) {
			
			d.findElement(By.xpath(String)).sendKeys();
			}

		
		

		

		
		
		
		
		//business method
		public void stage_4_Entry(String arg)
		{
			setuserNamefield(arg);
			setpassWodField(arg);
			click_login();
//			String actual=d.getTitle();
//			String expected="";
//			Assert.assertEquals(actual, expected, "not able to LOGIN");

			Reporter.log("entered to stage_4" , true);



		}}
