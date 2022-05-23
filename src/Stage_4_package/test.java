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

public class test {

	String url="https://stages4.inhouse.net/";
	String ProjectPath=System.getProperty("user.dir");
	excel_sheet excel= new excel_sheet(ProjectPath+"\\excel_sheet\\data_base.xlsx","sheet1");
	String username=excel.getCellDataString(1, 0);
	String password=excel.getCellDataString(1, 1);


	@Test(priority = 1)
	public void f() throws Throwable  { 
		WebDriver d=browser.getdriver("FIREFOX", url);
		try {
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
			Thread.sleep(4000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[7]")).click();
			Thread.sleep(1000);	
     		d.findElement(By.xpath("//a[contains(text(),'Add Timings')]")).click();
			Thread.sleep(2000);
			Select list1=new Select(d.findElement(By.name("team")));
			list1.selectByVisibleText("Mirage");
			d.findElement(By.name("hour")).sendKeys("4");
			d.findElement(By.xpath("//tbody/tr[2]/td[2]/label[1]/input[1]")).click();
			WebElement durationhour=d.findElement(By.id("duration_h"));
			durationhour.clear();
			durationhour.sendKeys("8");
			Thread.sleep(1000);
			WebElement durationminutes=d.findElement(By.id("duration_m"));
			durationminutes.clear();
			durationminutes.sendKeys("30");
			Thread.sleep(1000);
			d.findElement(By.xpath("//tbody/tr[4]/td[2]/div[1]/img[1]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//body/div[@id='dhtmlgoodies_colorPicker']/div[@id='color_picker_content']/div[1]/div[2]")).click();
			Thread.sleep(1000);
			WebElement reason=d.findElement(By.name("comment"));
			reason.sendKeys("demo");
			d.findElement(By.name("Add")).click();
			String actualmsg=d.findElement(By.xpath("//td[contains(text(),'Team shift Added Successfully !!')]")).getText();
			String expectedmsg="Team shift Added Successfully !!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper msg shows");
			d.quit();


		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f20.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f20.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}

	@Test(priority = 3)
	public void f2() throws Throwable  { 
		WebDriver d=browser.getdriver("FIREFOX", url);
		try {
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
			Thread.sleep(4000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[7]")).click();
			Thread.sleep(1000);		
			d.findElement(By.xpath("//a[contains(text(),'Delete Timings')]")).click();
			Thread.sleep(2000);
			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByVisibleText("Mirage");
			Thread.sleep(1000);			
			Select list2=new Select(d.findElement(By.name("shift")));
			list2.selectByVisibleText("4:00pm-0:35am ");			
			d.findElement(By.name("comment")).sendKeys("demo");
			d.findElement(By.name("Delete")).click();
			Thread.sleep(3000);
			Alert a1=d.switchTo().alert();
			a1.accept();
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//td[contains(text(),'Team shift Deleted Successfully !!')]")).getText();
			String expectedmsg="Team shift Deleted Successfully !!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper msg shows");
			d.quit();


		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f14.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f14.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}


	
	@Test(priority = 2)
	public void f22() throws Throwable  { 
		WebDriver d=browser.getdriver("FIREFOX", url);
		try {
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
			Thread.sleep(4000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[7]")).click();
			Thread.sleep(1000);		
			d.findElement(By.xpath("//a[contains(text(),'Edit Timings')]")).click();
			Thread.sleep(2000);
			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByVisibleText("Mirage");
			Thread.sleep(1000);			
			Select list2=new Select(d.findElement(By.name("shift")));
			list2.selectByVisibleText("4:00am-12:30pm ");	
			WebElement hour=d.findElement(By.name("hour"));
			hour.clear();
			hour.sendKeys("4");
			WebElement Dhour=d.findElement(By.name("duration_h"));
			Dhour.clear();
			Dhour.sendKeys("8");
			WebElement Dminute=d.findElement(By.name("duration_m"));
			Dminute.clear();
			Dminute.sendKeys("35");
			Thread.sleep(1000);
			d.findElement(By.xpath("//tbody/tr[5]/td[2]/div[1]/img[1]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//body/div[@id='dhtmlgoodies_colorPicker']/div[@id='color_picker_content']/div[1]/div[211]")).click();
			Thread.sleep(1000);
			d.findElement(By.id("id_log_reason")).sendKeys("edit");
			Thread.sleep(1000);
			d.findElement(By.name("Edit")).click();
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//td[contains(text(),'Team shift Updated Successfully !!')]")).getText();
			String expectedmsg="Team shift Updated Successfully !!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper msg shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f22.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f22.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}
	






}












