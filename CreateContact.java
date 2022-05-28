package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[3]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[2]")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Amrutha");
		driver.findElement(By.id("lastNameField")).sendKeys("T");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("aaa");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("lll");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("CSE");
		//driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("ddd");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("desc");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("aaa@gmail.com");
		WebElement ddGenState =driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']")); 
		Select	 ddGenOption = new Select(ddGenState);
				 ddGenOption.selectByVisibleText("New York");
	
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[1]")).click();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).sendKeys("note");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("Title is "+driver.getTitle());
				
	}
}
