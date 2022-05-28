package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadXpath {

	public static void main(String[] args) {
		// set up chrome driver.
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
		
		 driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		 driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaaf");
		 driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Amrutha");
		 driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("T");
		 driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("aaa");
		 driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("CSE");
		 driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("desc");
		 driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("bbb@gmail.com");
		WebElement ddSource = driver.findElement(By.id("createLeadForm_dataSourceId")); 
		Select ddOption = new Select(ddSource); ddOption.selectByValue("LEAD_CONFERENCE");
		 /* 
		 * WebElement ddGenState =
		 * driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")); Select
		 * ddGenOption = new Select(ddGenState);
		 * ddGenOption.selectByVisibleText("New York");*/
		 driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		 String title = driver.getTitle(); System.out.println("Title is "+ title); 
		 driver.close();
		 

	}

}
