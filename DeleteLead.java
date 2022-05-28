package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[2]//span[@class='x-tab-strip-text ']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
		
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("");
		driver.findElement(By.xpath("((//table[@class='x-btn-wrap x-btn']//tr/td[2])//button[@type='button'])[7]")).click();
		Thread.sleep(2000);
		//Accessing the first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[4]")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys("12663");
		//Clicking Find leads buttons after deleting
		driver.findElement(By.xpath("((//td[@class='x-panel-btn-td'])[6]//tbody//td[2])//button")).click();
		Thread.sleep(1000);
		String strDisp = driver.findElement(By.xpath("//div[@class='x-panel-bbar']//table/following-sibling::div")).getText();
		System.out.println("Text is "+ strDisp);
		if(strDisp.equals("No records to display")) {
			System.out.println("successful deletion");
		}
		driver.close();
		
	}
}