package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Magento { 
	@Test(priority=1)
	public void registration() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[8]/a/span[1]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"register\"]/span")).click();
		driver.findElement(By.id("firstname")).sendKeys("First");
		driver.findElement(By.id("lastname")).sendKeys("Last");
		driver.findElement(By.name("email")).sendKeys("ibrahimhossain1981@gmail.com");
		Select type = new Select(driver.findElement(By.id("company_type")));
		type.selectByIndex(2);
		type.selectByVisibleText("Develops Magento extensions");
		Select role= new Select(driver.findElement(By.id("individual_role")));
		role.selectByValue("technical/developer");
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("India");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("welcome");
		driver.findElement(By.name("password_confirmation")).sendKeys("welcome");
		if(!driver.findElement(By.id("agree_terms")).isSelected()) {
		driver.findElement(By.id("agree_terms")).click();
		
		}
		driver.quit();		
		
	}
	@Test(priority=2)
	public void negative_login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[8]/a/span[1]/i")).click();
		driver.findElement(By.name("login[username]")).sendKeys("ibrahimhossain1981@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Bithee1984");
		driver.findElement(By.name("send")).click();
		String error=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div[1]/div")).getText();
		System.out.println("error");
		if(error.equals("Invalid login or password.")) {
			System.out.println("TestCase pass");
		}
		else {
			System.out.println("TestCase fail");
		}
		driver.quit();
	}

}
