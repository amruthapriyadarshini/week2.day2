package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Open the browser
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("http://leaftaps.com/opentaps/control/login");

		// maximize
		driver.manage().window().maximize();
		WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[3]//span[@class='x-tab-strip-text ']")).click();
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='emailAddress']")).sendKeys("aaa@gmail.com");
		driver.findElement(By.xpath("(//td[@class='x-panel-btn-td']//tbody//td[2])[6]//button[@type='button']")).click();
		//Accessing the first element 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Clicking Duplicate lead
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[1]")).click();
		//how to verify as 'duplicate lead'
		Thread.sleep(2000);
		String strTitle = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println("Title is "+ strTitle);
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[2]/a")).click();
		//Confirm the duplicated lead name is same as captured name
		if(strTitle.equals("Duplicate Lead"))
		{
			System.out.println("Its a duplicate lead");
		}
		
		driver.close();
	}

}
