package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		//Clicking Leads button
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
		//Clicking Find Leads
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		//Enter first name
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys("Amrutha");
		//Cliking Find Leads button
		driver.findElement(By.xpath("(//td[@class='x-panel-btn-td']//tbody//td[2])[6]")).click();
		//Click on the first resulting lead
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Verify title of the page
		Thread.sleep(2000);
		String strTitle = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		//Clicking Edit button
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[3]")).click();
		//Updating the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Keane");
		//Clicking Update button
		driver.findElement(By.xpath("//td/input[@value='Update']")).click();
		//Confirm the changed name appears
		Thread.sleep(1000);
		String strName = driver.findElement(By.
				xpath("//div[@class='fieldgroup-title-bar']/following-sibling::div//tbody//td[2]/span[contains(text(),'Keane')]")).getText();
		System.out.println("Updated string "+strName);
		if(strName.contains("Keane")) {
			System.out.println("String updated");
		}
		driver.close();
	}

}
