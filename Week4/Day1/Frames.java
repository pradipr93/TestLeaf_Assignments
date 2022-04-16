package seleniumPractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Setup is done");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id= 'topic']//following-sibling::input")).sendKeys("Hello Everyone");
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement animals =driver.findElement(By.id("animals"));
		Select select = new Select(animals);
		select.selectByVisibleText("Avatar");
		
	  }



}
