package Stage_4_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browser_Management.browser;
import excel.excel_sheet;

public class frameworkextend {
	String url="https://stages4.inhouse.net/";
	String ProjectPath=System.getProperty("user.dir");
	excel_sheet excel= new excel_sheet(ProjectPath+"\\excel_sheet\\data_base.xlsx","sheet1");
	String username=excel.getCellDataString(1, 0);
	String password=excel.getCellDataString(1, 1);
	public WebDriver d;

	@BeforeTest
	public void openbrowser() throws Throwable {

		d=browser.getdriver("FIREFOX", url);
		d.get(url);

	}

	@Test
	public void f() throws InterruptedException  {
		
		d.findElement(By.name("username")).sendKeys("agni");
		Thread.sleep(2000);
		d.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(2000);;
		d.findElement(By.name("Login")).click();
		Thread.sleep(5000);
		String actual=d.findElement(By.xpath("//body/div[1]")).getText();
		System.out.println("user is " + actual);
		String expected="Agnisoonu K | Core";
		Assert.assertEquals(actual, expected);
		System.out.println("assertpass and login to stage 4");
		Thread.sleep(1000);
	}
}



