package seleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadCreation {
	
	public ChromeDriver driver;
	
	//Chrome Setup & launch application url
	public ChromeDriver setUp(String url) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
		
	}
	
	//Login to Application
	public void login()
	{
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	//Create Lead
	public void createLead()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCL");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Prakash");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Jagadesan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Pragu");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating Lead");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("prakash99@gmail.com");
		WebElement country =driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select selectObj = new Select(country);
        selectObj.selectByVisibleText("New York");
        driver.findElement(By.name("submitButton")).click();
	}
	
	//update lead with Important Note
	public void updateLead()
	{
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Update Lead");
		driver.findElement(By.name("submitButton")).click();

	}
	
	//creates duplicate for already created Lead
	public void duplicateLead()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Prathik");
		driver.findElement(By.name("submitButton")).click();
	
	}
	
	//verify tile of application
	public void verifyTitle(String title)
	{
		String text = driver.getTitle();
		if(text.equals(title))
		System.out.println("Title is displayed as expected: " +text);
		else
		System.out.println("Title is not displayed as expected: " +text);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		LeadCreation LeadCreationObj = new LeadCreation();
		LeadCreationObj.driver = LeadCreationObj.setUp("http://leaftaps.com/opentaps");
		LeadCreationObj.login();		
		LeadCreationObj.createLead();
		LeadCreationObj.verifyTitle("View Lead | opentaps CRM");
		
	}

}
