package org.iit.cloud.mmp.patient.tests;

import java.time.Duration;

import org.iit.cloud.mmp.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class US_005_SearchSymptoms {

	WebDriver driver;
	@Test(description="TC_001_search_symptoms")
	public void search_symptoms()
	{

		launchbrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		HelperClass HelperClassobj=new HelperClass(driver);
		HelperClassobj.login("ria1","Ria12345");
		navigateToAmodule("Search Symptoms");  
		boolean result=  SearchSymptoms("cold");
		Assert.assertTrue(result);

	} 
	boolean SearchSymptoms(String symp)
	{

		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(symp);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(60));
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[contains(text(),'"+symp+"')])[1]")));
		String text= e.getText();  
		return symp.equals(text) ;                            


	}
	@BeforeTest
	public void initdriver() 
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	/*@AfterTest
	 public void tearDown()
	 {
	 driver.quit();
	 }*/

	public void launchbrowser(String url) 
	{
		driver.get(url);

	}


	public void navigateToAmodule(String moduleName)
	{
		driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();

	}


}
