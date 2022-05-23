package Stage_4_package;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import base_Codes.base_code;
import browser_Management.browser;
import excel.excel_sheet;

public class test2 {
	String url="https://stages4.inhouse.net/";
	String ProjectPath=System.getProperty("user.dir");
	excel_sheet excel= new excel_sheet(ProjectPath+"\\excel_sheet\\data_base.xlsx","sheet1");
	String username=excel.getCellDataString(1, 0);
	String password=excel.getCellDataString(1, 1);

	@Test(priority=1)
	public void f() throws Throwable {	
		WebDriver d=browser.getdriver("FIREFOX", url);
		try{
			base_code obj=PageFactory.initElements(d, base_code.class);
			obj.setuserNamefield(username);
			obj.setpassWodField(password);
			obj.click_login();
			Thread.sleep(3000);
			String actual=d.findElement(By.xpath("//body/div[1]")).getText();
			System.out.println("user is " + actual);
			String expected="Agnisoonu K | Core";
			Assert.assertEquals(actual, expected);
			System.out.println("assertpass and login to stage 4");
			Thread.sleep(1000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[8]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View User')]")).click();
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//tbody//tr//td//fieldset//legend")).getText();
			String expectedmsg="View User";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper header shows");
			d.quit();
			
		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f0.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	
			
		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f0.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}}



