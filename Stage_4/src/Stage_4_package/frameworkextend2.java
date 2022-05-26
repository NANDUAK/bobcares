package Stage_4_package;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class frameworkextend2 extends frameworkextend {
	

	@Test(priority = 1)
	public void f1() throws InterruptedException {
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



	}}

