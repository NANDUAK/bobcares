package Stage_4_package;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
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


public class stage_4_class1 {

	String url="https://stages4.inhouse.net/";
	String ProjectPath=System.getProperty("user.dir");
	excel_sheet excel= new excel_sheet(ProjectPath+"\\excel_sheet\\data_base.xlsx","sheet1");
	String username=excel.getCellDataString(1, 0);
	String password=excel.getCellDataString(1, 1);


	@Test(priority = 0)
	public void f1() throws Throwable    {
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
			System.out.println("Assert pass and login to stage 4");
			d.quit();


		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f1.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f1.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	
		}}


	@Test(priority = 1)
	public void f2() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[1]")).click();
			Thread.sleep(2000);
			d.findElement(By.xpath("//a[contains(text(),'Add Category')]")).click();
			Thread.sleep(1000);
			d.findElement(By.name("name")).sendKeys("demo");
			Thread.sleep(1000);
			d.findElement(By.name("code")).sendKeys("demo123");
			Thread.sleep(1000);
			d.findElement(By.id("id_log_reason")).sendKeys("testing");
			Thread.sleep(2000);
			d.findElement(By.name("Add")).click();
			Thread.sleep(1000);
			String actual_message=d.findElement(By.xpath("//td[contains(text(),'Category Added Successfully !!')]")).getText();
			System.out.println(actual_message);
			String expected_message ="Category Added Successfully !!";
			Assert.assertEquals(actual_message,expected_message);
			System.out.println("Assert pass");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f2.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f2.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority = 3)
	public void f3() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[1]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Delete Category')]")).click();
			Thread.sleep(1000);
			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByVisibleText("demo1(demo1234)");
			Thread.sleep(1000);
			d.findElement(By.id("id_log_reason")).sendKeys("Testing purpose");
			String confimationmessage_before=d.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[4]/td[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/table[1]/tbody[1]/tr[4]/td[1]")).getText();
			System.out.println(confimationmessage_before);
			String actual_confimationmessage_before ="Do you want to delete this Team?";
			Assert.assertEquals(confimationmessage_before, actual_confimationmessage_before);
			d.findElement(By.name("yes")).click();
			Thread.sleep(1000);
			Alert a1=d.switchTo().alert();
			a1.accept();
			Thread.sleep(1000);
			String confimationmessage_after=d.findElement(By.xpath("//td[contains(text(),'Category Deleted Successfully !!')]")).getText();
			System.out.println(confimationmessage_after);
			String actual_confimationmessage_after ="Category Deleted Successfully !!";
			Assert.assertEquals(confimationmessage_after, actual_confimationmessage_after);
			System.out.println("Assert pass");	
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f3.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f3.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();

		}}

	@Test(priority = 2)
	public void f4() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[1]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Edit Category')]")).click();
			Thread.sleep(1000);
			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByVisibleText("demo(demo123)");
			Thread.sleep(1000);
			WebElement name=d.findElement(By.name("name"));
			name.clear();
			name.sendKeys("demo1");
			Thread.sleep(1000);
			WebElement code= d.findElement(By.name("code"));
			code.clear();
			code.sendKeys("demo1234");
			Thread.sleep(1000);
			WebElement reason=d.findElement(By.id("id_log_reason"));
			reason.clear();
			reason.sendKeys("testingg");
			Thread.sleep(2000);
			d.findElement(By.name("Edit")).click();
			Thread.sleep(1000);
			String confimationmessage_after=d.findElement(By.xpath("//td[contains(text(),'Shift Category Updated Successfully !!')]")).getText();
			System.out.println(confimationmessage_after);
			String actual_confimationmessage_after ="Shift Category Updated Successfully !!";
			Assert.assertEquals(confimationmessage_after, actual_confimationmessage_after);
			System.out.println("Assert pass");	
			d.quit();


		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f4.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f4.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority = 4)
	public void f5() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[1]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'List Category')]")).click();
			Thread.sleep(1000);
			String actual_header=d.findElement(By.xpath("//tbody//tr//td//fieldset//legend")).getText();
			Thread.sleep(1000);
			System.out.println(actual_header);
			String expected_header="List User";
			Assert.assertEquals(actual_header, expected_header);
			System.out.println("assert pass");
			d.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]")).click();
			Thread.sleep(1000);
			String actualhead=d.findElement(By.xpath("//tbody//tr//td//fieldset//legend")).getText();
			Thread.sleep(1000);
			System.out.println(actualhead);
			String expectedhead="View Category";
			Assert.assertEquals(actualhead, expectedhead);
			System.out.println("assert pass");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f5.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f5.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority = 5)
	public void f6() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[1]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View Category')]")).click();
			Thread.sleep(1000);
			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByIndex(1);
			String actualhead=d.findElement(By.xpath("//tbody//tr//td//fieldset//legend")).getText();
			String expectedhead="View Category";
			Assert.assertEquals(actualhead, expectedhead);
			System.out.println("view category screen shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f6.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f6.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();

		}}

	@Test(priority=6)
	public void f7() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[3]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View Log')]")).click();
			Thread.sleep(1000);
			Select list1=new Select(d.findElement(By.name("type")));
			list1.selectByIndex(1);
			d.findElement(By.name("Go")).click();
			Thread.sleep(1000);
			String actualhead=d.findElement(By.xpath("//b[contains(text(),'Details')]")).getText();
			System.out.println(actualhead);
			String expectedhead="Details";
			Assert.assertEquals(actualhead,expectedhead);
			System.out.println("Assert pass");
			d.quit();
		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f7.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f7.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority=7)
	public void f8() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[2]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Manage InterTeamWorks')]")).click();
			Thread.sleep(1000);
			Select list1=new Select(d.findElement(By.xpath("//tbody/tr[3]/td[1]/select[1]")));
			list1.selectByVisibleText("SharedDev");
			Thread.sleep(1000);
			{
				String fromdatepage = d.getWindowHandle();
				d.findElement(By.xpath("//tbody/tr[3]/td[1]/img[1]")).click();
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
				d.findElement(By.xpath("//tbody/tr[3]/td[1]/img[2]")).click();
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
			d.findElement(By.xpath("//tbody/tr[3]/td[1]/input[7]")).click();
			Thread.sleep(2000);

			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f8.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f8.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority=8)
	public void f9() throws Throwable {
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[2]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View InterTeamWorks')]")).click();
			Thread.sleep(1000);
			Select list1=new Select(d.findElement(By.xpath("//tbody/tr[3]/td[1]/select[1]")));
			list1.selectByVisibleText("SharedDev");
			Thread.sleep(1000);
			{
				String fromdatepage = d.getWindowHandle();
				d.findElement(By.xpath("//tbody/tr[3]/td[1]/img[1]")).click();
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
					}
					else {
						throw new Exception();
					}}
				d.switchTo().window(fromdatepage);
			}
			{
				String todatepage = d.getWindowHandle();
				d.findElement(By.xpath("//tbody/tr[3]/td[1]/img[2]")).click();
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
			Thread.sleep(2000);
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f9.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f9.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();

		}}

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

	@Test(priority=13)
	public void f14() throws Throwable {		
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[6]")).click();
			Thread.sleep(1000);		
			d.findElement(By.xpath("//a[contains(text(),'Add Team')]")).click();
			Thread.sleep(2000);

			d.findElement(By.name("name")).sendKeys(excel.getCellDataString(1, 4));
			Select list1=new Select(d.findElement(By.name("type")));
			list1.selectByIndex(0);
			List<WebElement> user=d.findElements(By.xpath("//tbody/tr[5]/td[1]/select[1]/option"));
			System.out.println(user);
			Thread.sleep(2000);
			System.out.println(user);
			int total_no=user.size();
			for (int i=0; i<total_no; i++)
			{
				String users=user.get(i).getText();
				if(users.equals("Anu M S"))
				{ 
					user.get(i).click();
					d.findElement(By.id("add_button")).click();
					break;
				}}

			List<WebElement> admin=d.findElements(By.xpath("//tbody/tr[7]/td[1]/select[1]/option"));
			System.out.println(admin);
			Thread.sleep(2000);
			int adminlist=admin.size();
			System.out.println("number of loops " + adminlist) ;
			for (int t=0; t<adminlist; t++)
			{
				String admins=admin.get(t).getText();
				if(admins.equals("a.bug.in.s4"))
				{
					admin.get(t).click();
					d.findElement(By.xpath("//tbody/tr[7]/td[2]/input[1]")).click();	
					break;
				}}
			d.findElement(By.name("comment")).sendKeys("Demoteam");
			d.findElement(By.name("Add")).click();
			String Actualmessage=d.findElement(By.xpath("//td[contains(text(),'Team Added Successfully !!')]")).getText();
			System.out.println(Actualmessage);
			String expectedmessage="Team Added Successfully !!";
			Assert.assertEquals(Actualmessage, expectedmessage);
			System.out.println("proper message shows");	
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

	@Test(priority=15)
	public void f15() throws Throwable {		
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[6]")).click();
			Thread.sleep(1000);		
			d.findElement(By.xpath("//a[contains(text(),'Delete Team')]")).click();
			Thread.sleep(2000);

			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByVisibleText("Demo1");
			Thread.sleep(1000);

			d.findElement(By.id("id_log_reason")).sendKeys("demo");
			d.findElement(By.name("yes")).click();
			Alert a1=d.switchTo().alert();
			a1.accept();

			Thread.sleep(2000);
			String actualhead = d.findElement(By.xpath("//td[contains(text(),'Team Deleted Successfully !!')]")).getText();
			System.out.println(actualhead);
			String expectedhead ="Team Deleted Successfully !!";
			Assert.assertEquals(actualhead, expectedhead);
			System.out.println("proper message shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f15.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f15.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); }}


	@Test(priority=14)
	public void f16() throws Throwable {		
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[6]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Edit Team')]")).click();
			Thread.sleep(1000);
			Select list1=new Select (d.findElement(By.name("id")));
			list1.selectByVisibleText(("DEMO"));
			Thread.sleep(3000);
			WebElement Team=d.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]"));
			Thread.sleep(1000);
			Team.clear();
			Team.sendKeys("Demo1");
			List<WebElement> user=d.findElements(By.xpath("//tbody/tr[7]/td[1]/select[1]/option"));
			System.out.println(user);
			Thread.sleep(2000);
			System.out.println(user);
			int total_no=user.size();
			for (int i=0; i<total_no; i++)
			{
				String users=user.get(i).getText();
				if(users.equals("Aathira"))
				{ 
					user.get(i).click();
					d.findElement(By.id("add_button")).click();
					break;
				}}
			List<WebElement> admin=d.findElements(By.xpath("//tbody/tr[9]/td[1]/select[1]/option"));
			System.out.println(admin);
			Thread.sleep(2000);
			int adminlist=admin.size();
			System.out.println("number of loops " + adminlist) ;
			for (int t=0; t<adminlist; t++)
			{
				String admins=admin.get(t).getText();
				if(admins.equals("a3"))
				{
					admin.get(t).click();
					d.findElement(By.xpath("//tbody/tr[9]/td[2]/input[1]")).click();	
					break;
				}}

			WebElement comment=d.findElement(By.name("comment"));
			comment.clear();
			comment.sendKeys("edit demmo");	
			d.findElement(By.name("Edit")).click();			
			String Actualmessage=d.findElement(By.xpath("//td[contains(text(),'Team Updated Successfully !!')]")).getText();
			System.out.println(Actualmessage);
			String expectedmessage="Team Updated Successfully !!";
			Assert.assertEquals(Actualmessage, expectedmessage);
			System.out.println("proper message shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f16.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f16.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); }}

	@Test(priority=16)
	public void f17() throws Throwable {	
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[6]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'List Team')]")).click();
			Thread.sleep(1000);
			String Actualhead=d.findElement(By.xpath("//tbody//tr//td//fieldset//legend")).getText();
			System.out.println(Actualhead);
			String expectedhead="List Team";
			Assert.assertEquals(Actualhead, expectedhead);
			System.out.println("proper header shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f17.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f17.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); }}

	@Test(priority=17)
	public void f18() throws Throwable {	
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[6]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View Team')]")).click();
			Thread.sleep(1000);
			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByVisibleText("Mirage");
			String Actualteam=d.findElement(By.xpath("//td[contains(text(),'Mirage')]")).getText();
			System.out.println(Actualteam);
			String expectedteam="Mirage";
			Assert.assertEquals(Actualteam, expectedteam);
			System.out.println("proper team shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f18.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f18.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();}}

	@Test(priority=18)
	public void f19() throws Throwable {	
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[5]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Add SLA')]")).click();
			Thread.sleep(2000);
			Select list1=new Select(d.findElement(By.id("selYear")));
			list1.selectByVisibleText("2022");
			Select list2=new Select(d.findElement(By.id("selectTeam")));
			list2.selectByVisibleText("Mirage");
			Select list3=new Select(d.findElement(By.id("month")));
			list3.selectByVisibleText("March");
			Thread.sleep(2000);
			WebElement SLA= d.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
			SLA.clear();
			SLA.sendKeys("1");
			d.findElement(By.name("submit")).click();
			System.out.println("process complete");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f19.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f19.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();}}

	@Test(priority = 19)
	public void f20() throws Throwable  { 
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

	@Test(priority = 20)
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

	@Test(priority = 21)
	public void f21() throws Throwable  { 
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

	@Test(priority = 22)
	public void f23() throws Throwable  { 
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
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[7]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'View Timings')]")).click();
			Thread.sleep(2000);
			Select list1=new Select(d.findElement(By.name("id")));
			list1.selectByVisibleText("Mirage");
			Thread.sleep(2000);
			Select list2=new Select(d.findElement(By.name("shift")));
			list2.selectByVisibleText("8:00am-4:00pm ");
			Thread.sleep(2000);
			String actualhead=d.findElement(By.xpath("//tbody//tr//td//fieldset//legend")).getText();
			String expectedhead="View Team Shift";
			Assert.assertEquals(actualhead, expectedhead);
			System.out.println("proper Header shows");
			d.quit();
		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f23.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f23.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}

	@Test(priority=23)
	public void f24() throws Throwable {	
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
			d.findElement(By.xpath("//a[contains(text(),'Add User')]")).click();
			Thread.sleep(2000);
			d.findElement(By.name("name")).sendKeys("test");
			Thread.sleep(1000);
			d.findElement(By.name("nickname")).sendKeys("nick test");
			Thread.sleep(1000);
			d.findElement(By.name("email")).sendKeys("nandu.ak@poornam.com");
			Thread.sleep(1000);
			Select list1=new Select (d.findElement(By.name("selOff")));
			list1.selectByVisibleText("Sunday");
			d.findElement(By.name("AddRole")).click();
			Thread.sleep(2000);
			Select list2=new Select (d.findElement(By.name("selRole[]")));
			list2.selectByVisibleText("QM");
			Thread.sleep(1000);
			d.findElement(By.name("AddTeam")).click();
			Thread.sleep(1000);
			Select list3=new Select (d.findElement(By.name("selTeam[]")));
			list3.selectByVisibleText("Mirage");
			Thread.sleep(1000);
			Select list4=new Select (d.findElement(By.name("selTeamRole[]")));
			list4.selectByVisibleText("Team Member");
			Thread.sleep(1000);
			d.findElement(By.id("id_log_reason")).sendKeys("test user");
			Thread.sleep(1000);
			d.findElement(By.name("Add")).click();
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//td[contains(text(),'User Added Successfully !!')]")).getText();
			String expectedmsg="User Added Successfully !!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper msg shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f24.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f24.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority=24)
	public void f25() throws Throwable {	
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
			d.findElement(By.xpath("//a[contains(text(),'Edit User')]")).click();
			Thread.sleep(2000);
			Select list1=new Select (d.findElement(By.name("id")));
			list1.selectByVisibleText("test");
			WebElement name=d.findElement(By.name("name"));
			name.clear();
			name.sendKeys("testdelete");
			Thread.sleep(1000);			
			WebElement nick_name=d.findElement(By.name("nickname"));
			nick_name.clear();
			nick_name.sendKeys("nick testdelete");
			Thread.sleep(1000);			
			WebElement log=d.findElement(By.id("id_log_reason"));
			log.clear();
			log.sendKeys("test user");
			Thread.sleep(1000);
			d.findElement(By.name("Edit")).click();
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//td[contains(text(),'User Updated Successfully !!')]")).getText();
			String expectedmsg="User Updated Successfully !!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper msg shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f25.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f25.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority=25)
	public void f26() throws Throwable {	
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
			d.findElement(By.xpath("//a[contains(text(),'List User')]")).click();
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//tbody//tr//td//fieldset//legend")).getText();
			String expectedmsg="List User";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper header shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f26.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f26.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority=26)
	public void f27() throws Throwable {	
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
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f27.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f27.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority=27)
	public void f28() throws Throwable {	
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
			d.findElement(By.xpath("//a[contains(text(),'Delete User')]")).click();
			Thread.sleep(2000);
			Select list1=new Select (d.findElement(By.name("id")));
			list1.selectByVisibleText("testdelete");
			d.findElement(By.id("id_log_reason")).sendKeys("test");
			Thread.sleep(2000);
			d.findElement(By.name("yes")).click();
			Thread.sleep(2000);
			Alert a1=d.switchTo().alert();
			a1.accept();
			Thread.sleep(1000);
			String actualmsg=d.findElement(By.xpath("//td[contains(text(),'User Deleted Successfully !!')]")).getText();
			String expectedmsg="User Deleted Successfully !!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper message shows");
			d.quit();


		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f28.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f28.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}

	@Test(priority = 28)
	public void f29() throws Throwable  { 
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
			d.findElement(By.xpath("//a[contains(text(),'LogOut!')]")).click();	
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//b[contains(text(),'Login!')]")).getText();
			String expectedmsg="Login!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper header shows");
			d.quit();

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f29.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f29.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception(); 
		}}

	@Test(priority=29)
	public void f30() throws Throwable {	
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
			d.findElement(By.xpath("//a[contains(text(),'Add User')]")).click();
			Thread.sleep(2000);
			String randomdata = RandomStringUtils.randomAlphabetic(6);
			String Generateddata=randomdata.toLowerCase();
			System.out.println(Generateddata);
			d.findElement(By.name("name")).sendKeys(Generateddata);
			Thread.sleep(1000);
			d.findElement(By.name("nickname")).sendKeys(Generateddata);
			Thread.sleep(1000);
			d.findElement(By.name("email")).sendKeys(Generateddata+"@poornam.com");
			Thread.sleep(1000);
			Select list1=new Select (d.findElement(By.name("selOff")));
			list1.selectByVisibleText("Sunday");
			d.findElement(By.id("id_log_reason")).sendKeys("test user");
			Thread.sleep(3000);
			d.findElement(By.name("Add")).click();
			Thread.sleep(2000);
			String actualmsg=d.findElement(By.xpath("//td[contains(text(),'User Added Successfully !!')]")).getText();
			String expectedmsg="User Added Successfully !!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("proper msg shows");
			d.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[8]")).click();
			Thread.sleep(1000);
			d.findElement(By.xpath("//a[contains(text(),'Disable User')]")).click();
			Thread.sleep(2000);
			Select list5=new Select (d.findElement(By.name("id")));
			list5.selectByVisibleText(Generateddata);
			d.findElement(By.name("comment")).sendKeys("demo");
			d.findElement(By.name("yes")).click();
			Thread.sleep(2000);
			Alert a1=d.switchTo().alert();
			a1.accept();
			Thread.sleep(2000);
			String actualmsg2=d.findElement(By.xpath("//td[contains(text(),'User Disabled Successfully !!')]")).getText();
			String expectedmsg2="User Disabled Successfully !!";
			Assert.assertEquals(actualmsg2, expectedmsg2);
			System.out.println("proper msg shows");
			d.quit();			

		}catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f30.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();	

		}catch(AssertionError e) {
			e.printStackTrace();
			TakesScreenshot scrShot =((TakesScreenshot)d);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/Users/nandu/Desktop/selenium/screenshot/f30.png");
			Files.copy(SrcFile, DestFile);
			System.out.println("screenshot added");
			d.quit();
			throw new Exception();
		}}











}