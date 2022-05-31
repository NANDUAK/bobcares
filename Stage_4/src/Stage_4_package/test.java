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


	@Test(priority=9)
	public void f10() throws Throwable {		
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
			Thread.sleep(1000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[4]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Add Shift')]")).click();
			Select list1= new Select (d.findElement(By.name("id")));
			list1.selectByVisibleText("Anu M S");
			Thread.sleep(1000);
			Select list2= new Select (d.findElement(By.name("tid")));
			list2.selectByVisibleText("Mirage");
			Thread.sleep(1000);
			Select list3= new Select (d.findElement(By.name("WD_rule_type")));
			list3.selectByVisibleText("Custom");
			Thread.sleep(1000);
			Select list4= new Select (d.findElement(By.name("custom_cat")));
			list4.selectByVisibleText("Casual Leave(CL)");
			Thread.sleep(1000);
			Select list5= new Select (d.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/select[1]")));
			list5.selectByVisibleText("Jan");
			Thread.sleep(1000); 
			Select list6= new Select (d.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/select[2]")));
			list6.selectByVisibleText(excel.getCellDataNumber(2, 0).toString());
			Thread.sleep(1000);
			d.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/div[4]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[4]")).click();
			Thread.sleep(1000);
			d.findElement(By.name("Add_Cal")).click();
			d.findElement(By.name("custom_shift_comment")).clear();
			d.findElement(By.name("custom_shift_comment")).sendKeys("demo testing");
			d.findElement(By.name("Add")).click();
			Thread.sleep(2000);
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f10.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f10.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 

		}} 
	@Test(priority=10)
	public void f11() throws Throwable {		
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
			Thread.sleep(1000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[4]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View Shift')]")).click();
			Thread.sleep(1000);
			Select list1=new Select (d.findElement(By.name("team")));
			list1.selectByVisibleText("Mirage");
			Thread.sleep(1000);
			{
				String fromdatepage = d.getWindowHandle();
				d.findElement(By.xpath("//tbody/tr[4]/td[1]/img[1]")).click();
				Thread.sleep(1000); 

				for 
				(String winHandle : d.getWindowHandles())
				{
					d.switchTo().window(winHandle);
				}
				List<WebElement> Fomdate=d.findElements(By.xpath("//tbody/tr/td"));
				System.out.println(Fomdate);
				Thread.sleep(2000);
				int totalFomdate=Fomdate.size();
				for (int i=0; i<totalFomdate; i++)
				{
					String users=Fomdate.get(i).getText();
					if(users.equals("1"))
					{ 
						Fomdate.get(i).click();
						break;
					}}
				d.switchTo().window(fromdatepage);
			}
			{
				String todatepage = d.getWindowHandle();
				d.findElement(By.xpath("//tbody/tr[4]/td[1]/img[2]")).click();
				Thread.sleep(1000); 

				for 
				(String winHandle : d.getWindowHandles())
				{
					d.switchTo().window(winHandle);
				}
				List<WebElement> todate=d.findElements(By.xpath("//tbody/tr/td"));
				System.out.println(todate);
				Thread.sleep(2000);
				int totaltodate=todate.size();
				for (int i=0; i<totaltodate; i++)
				{
					String date=todate.get(i).getText();
					if(date.equals("30"))
					{ 
						todate.get(i).click();
						break;
					}}
				d.switchTo().window(todatepage);
			}
			Thread.sleep(2000);
			d.findElement(By.name("Go")).click();
			String actualhead = d.findElement(By.xpath("//b[contains(text(),'Date')]")).getText();
			System.out.println(actualhead);
			String expectedhead ="Date";
			Assert.assertEquals(actualhead, expectedhead);
			d.quit();


		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f11.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f11.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}

	@Test(priority=11)
	public void f12() throws Throwable {		
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
			Thread.sleep(1000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[4]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Manage Shift')]")).click();
			Thread.sleep(1000);
			Select list1=new Select (d.findElement(By.name("id")));
			list1.selectByVisibleText("Anu M S");
			Thread.sleep(4000);
			String actualhead = d.findElement(By.xpath("//td[contains(text(),'Assigned Shift Rules')]")).getText();
			System.out.println(actualhead);
			String expectedhead ="Assigned Shift Rules";
			Assert.assertEquals(actualhead, expectedhead);
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f12.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f12.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}

	@Test(priority=12)
	public void f13() throws Throwable {		
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
			Thread.sleep(1000);
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[4]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View Admin Shift')]")).click();
			Thread.sleep(1000);			
			String actualhead = d.findElement(By.xpath("//b[contains(text(),'Date')]")).getText();
			System.out.println(actualhead);
			String expectedhead ="Date";
			Assert.assertEquals(actualhead, expectedhead);
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f13.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f13.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}
}
