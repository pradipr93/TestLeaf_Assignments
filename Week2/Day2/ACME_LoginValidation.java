package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ACME_LoginValidation {

	public ChromeDriver driver;
	//Set up Chrome Driver according to browser and launch chrome
		public ChromeDriver setUpChrome() throws Exception {
			WebDriverManager.chromedriver().setup();
			System.out.println("Chrome Driver Setup - done");
			driver = new ChromeDriver();
			System.out.println("Chrome Launched");
			return driver;
		}

		//launch application url
		public void launchUrl(String url)
		{
			driver.get(url);
			System.out.println( driver.getTitle() +": Application Launched");
			driver.manage().window().maximize();
		}
		
		//login to ACME Application
		public void login(String eMail, String pass) {

			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys(eMail);
			System.out.println("Entered Email: "+email.getAttribute("value"));
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys(pass);
			System.out.println("Entered Password: "+password.getAttribute("value"));
			driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
			System.out.println("Clicked on Login Button");
		
		}
		
		//Logout of Application
		public void logout()
		{
			driver.findElement(By.xpath("//a[text() = 'Log Out']")).click();
			System.out.println("Logged out");
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
			
			String eMail = "kumar.testleaf@gmail.com";
			String pwd = "leaf@12";
			ACME_LoginValidation ACME_LoginValidationObj = new ACME_LoginValidation();
			ACME_LoginValidationObj.setUpChrome();
			ACME_LoginValidationObj.launchUrl("https://acme-test.uipath.com/login");
			ACME_LoginValidationObj.login(eMail, pwd);
			ACME_LoginValidationObj.verifyTitle("ACME System 1 -  Dashboard");
			ACME_LoginValidationObj.logout();
		
			
		}
			
}
