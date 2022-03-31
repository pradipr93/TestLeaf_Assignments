package seleniumPractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignupValidation {
	
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
	
	//Sign Up Validation FB
	public void signUp() throws InterruptedException
	{
		driver.findElement(By.linkText("Create New Account")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Prakash");
		System.out.println("Entered Firstname: "+firstName.getAttribute("value"));
		WebElement lastName =driver.findElement(By.name("lastname"));
		lastName.sendKeys("Jagadeesan");
		System.out.println("Entered LastName: "+lastName.getAttribute("value"));
		WebElement mobile_Email = driver.findElement(By.name("reg_email__"));
		mobile_Email.sendKeys("8680801917");
		System.out.println("Entered Mobile or Email: "+mobile_Email.getAttribute("value"));
		WebElement gender = driver.findElement(By.xpath("//label[text() = 'Female']//following-sibling::input"));
		if(!gender.isSelected())
		gender.click();
		else
		System.out.println("Gender Already Selected");
	}
	
	public static void main(String[] args) throws Exception
	{

		
		FacebookSignupValidation fbObj = new FacebookSignupValidation();
		fbObj.driver = fbObj.setUpChrome();
		fbObj.launchUrl("https://en-gb.facebook.com/");
		fbObj.signUp();
		

	}

}
