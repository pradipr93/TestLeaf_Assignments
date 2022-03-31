package seleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadDeletion {
	
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
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println("Clicked on CRM/SFA icon");
	}
	
	//Create Lead
	public void createLead()
	{
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
	
	
	
	public void deleteLead() throws InterruptedException
	{
		
		driver.findElement(By.linkText("Leads")).click();
		System.out.println("Clicked on Leads tab");
		driver.findElement(By.linkText("Find Leads")).click();
		System.out.println("Clicked on Find Lead link");
		Thread.sleep(2000);
		WebElement firstLeadID = driver.findElement(By.xpath("//div[contains(@class, 'x-grid3-cell-inner')][contains(@class, 'x-grid3-col-partyId')]/a"));
		String leadID = firstLeadID.getText();
		System.out.println("First Lead ID which needs to be deleted: "+leadID);
		firstLeadID.click();
		System.out.println("Clicked on first Lead ID");
		
		driver.findElement(By.linkText("Delete")).click();
		System.out.println("Clicked on delete button");
		
		driver.findElement(By.linkText("Find Leads")).click();
		System.out.println("Clicked on Find Lead link");
		
		driver.findElement(By.name("id")).sendKeys(leadID);
		System.out.println("Entered Deleted Link ID");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		System.out.println("Clicked on find ID");
		Thread.sleep(3000);
		String recordText = driver.findElement(By.xpath("//div[contains(@class, 'x-toolbar')][contains(@class, 'x-small-editor')]/div")).getText();
		System.out.println(recordText);
		if(recordText.equals("No records to display"))
			System.out.println("Record Successfully Deleted");
		else
			System.out.println("Record not Deleted");
		
		
	}
	
	//creates duplicate for already created Lead
	public void duplicateLead() throws InterruptedException
	{
		driver.findElement(By.linkText("Leads")).click();
		System.out.println("Clicked on Leads tab");
		driver.findElement(By.linkText("Find Leads")).click();
		System.out.println("Clicked on Find Leads link");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text() = 'Email']")).click();
		System.out.println("Clicked on Email");
		driver.findElement(By.name("emailAddress")).sendKeys("pradiprock965@gmail.com");
		System.out.println("Entered Email");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		System.out.println("Clicked on Find Leads button");
		Thread.sleep(1000);
		String recordText = driver.findElement(By.xpath("//div[contains(@class, 'x-toolbar')][contains(@class, 'x-small-editor')]/div")).getText();
        if(recordText.contains("Displaying records"))
        {
		WebElement leadNameele = driver.findElement(By.xpath("//div[contains(@class, 'x-grid3-cell-inner')][contains(@class,'x-grid3-col-firstName')]/a"));
		String leadName = leadNameele.getText();
		System.out.println("Lead First Name is: " +leadName);
		leadNameele.click();
		System.out.println("Clicked on First Lead");
		driver.findElement(By.linkText("Duplicate Lead")).click();
		System.out.println("Clicked on Duplicate Lead button");
		verifyTitle("View Lead | opentaps CRM");
		driver.findElement(By.name("submitButton")).click();
		System.out.println("Clicked on Create Lead button");
		String dupText = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Lead First Name in Duplicate Lead tab is"+dupText);
		if(dupText.equals(leadName))
					System.out.println("Lead Duplicated successfully");
		else
			System.out.println("Lead not duplicated");
        }
        else
        {
        	System.out.println("No Records with entered email");
        }
	
	}
	
	public void editLead() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		System.out.println("Clicked on Leads tab");
		driver.findElement(By.linkText("Find Leads")).click();
		System.out.println("Clicked on Find Leads link");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text() = 'Phone']")).click();
		System.out.println("Clicked on Phone Link");
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys("91");

		driver.findElement(By.name("phoneNumber")).sendKeys("8667888941");
		System.out.println("Entered phone Number");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		System.out.println("Clicked on Find Leads button");
		Thread.sleep(2000);
		
		WebElement compNam= driver.findElement(By.xpath("//div[contains(@class, 'x-grid3-cell-inner')][contains(@class, 'x-grid3-col-companyName')]/a"));
		String comNamText = compNam.getText();
		System.out.println(comNamText);
		compNam.click();
		verifyTitle("View Lead | opentaps CRM");
		driver.findElement(By.linkText("Edit")).click();
		System.out.println("Clicked on Edit link");
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Tata");
		System.out.println("Entered Company name");
		Thread.sleep(2000);
		String updatedText = driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");
		System.out.println(updatedText);
		driver.findElement(By.name("submitButton")).click();
		System.out.println("Clicked on Update button");
		String viewText[] = driver.findElement(By.id("viewLead_companyName_sp")).getText().split(" ");
		String compText = viewText[0];
		System.out.println(compText);
		if(compText.equals(updatedText))
			System.out.println("Company Name updated successfully");
		else
			System.out.println("Company Name not Updated");


		
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
		
		LeadDeletion LeadDeletionObj = new LeadDeletion();
		LeadDeletionObj.driver = LeadDeletionObj.setUp("http://leaftaps.com/opentaps");
		LeadDeletionObj.login();		
		LeadDeletionObj.deleteLead();
		
		
	}

}
