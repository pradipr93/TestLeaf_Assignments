package seleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactCreation {
	
	public ChromeDriver driver;
	
	public void setUp() throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	
	//launch application url
	public void launchUrl(String url)
	{
		driver.get(url);
		System.out.println( driver.getTitle() +": Application Launched");
		driver.manage().window().maximize();
	}
	
	//Login to Application
	public void login()
	{
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	public void createContact()
	{
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println("Clicked on CRM/SFA icon");
		driver.findElement(By.linkText("Contacts")).click();
		System.out.println("Clicked on Contact tab");
		driver.findElement(By.linkText("Create Contact")).click();
		System.out.println("Clicked on Create Contact");
		driver.findElement(By.id("firstNameField")).sendKeys("Naga");
		System.out.println("Entered First Name");
		driver.findElement(By.id("lastNameField")).sendKeys("Babu");
		System.out.println("Entered Last Name");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Hari");
		System.out.println("Entered First Name (Local)");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Krishnan");
		System.out.println("Entered Last Name (Local)");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("CSE");
		System.out.println("Entered Department");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Create Contact");
		System.out.println("Entered Description");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("toby93@gmail.com");
		System.out.println("Entered Email");
		
		Select state_drpdn = new Select (driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		state_drpdn.selectByVisibleText("New York");
		System.out.println("Selected State " +state_drpdn.getFirstSelectedOption().getText());
		
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Clicked on Create Contact button");
		
		driver.findElement(By.linkText("Edit")).click();
		System.out.println("Clicked on Edit link");
		
		driver.findElement(By.name("description")).clear();
		System.out.println("Cleared Description");
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Updating Existing contact");
		System.out.println("Entered Important Note");
		
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Clicked on Update button");
		verifyTitle("View Contact | opentaps CRM");
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
		
		ContactCreation ContactCreationObj = new ContactCreation();
		ContactCreationObj.setUp();
		ContactCreationObj.launchUrl("http://leaftaps.com/opentaps");
		ContactCreationObj.login();
		ContactCreationObj.createContact();
		
	
	}

}
