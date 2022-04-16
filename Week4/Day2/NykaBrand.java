package seleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaBrand {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions action = new Actions(driver);
		WebElement brand = driver.findElement(By.linkText("Brands"));
		action.moveToElement(brand).perform();
		WebElement search = driver.findElement(By.id("brandSearchBox"));
		search.sendKeys("L'Oreal Paris");
		Thread.sleep(3000);
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		if(driver.getTitle().contains("L'Oreal Paris"))
		{
			System.out.println("Loreal Paris Page exist");
			driver.findElement(By.xpath("//span[contains(text(), 'Sort By')]//parent::button")).click();
			driver.findElement(By.xpath("//span[text() = 'customer top rated']//following::div")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//span[contains(text(), 'Sort By')]//following-sibling::*//child::*")).click();
			WebElement category = driver.findElement(By.xpath("//span[text() = 'Category']"));
			category.click();
			driver.findElement(By.xpath("//span[text() = 'Hair']")).click();
			driver.findElement(By.xpath("//span[text() = 'Hair Care']")).click();
			WebElement hairCare = driver.findElement(By.xpath("//span[text() = 'Hair Care']//parent::div//following-sibling::ul//span[text() = 'Shampoo']//following::div"));
			if(!hairCare.isSelected())
			{
				hairCare.click();
				Thread.sleep(1000);
			}
			category.click();
			driver.findElement(By.xpath("//span[text() = 'Concern']")).click();
			//driver.findElement(By.xpath("//input[@placeholder = 'Search']")).sendKeys("Color Protection");
			driver.findElement(By.xpath("//label[contains(@for, 'checkbox_Color Protection')]//span[text() = 'Color Protection']")).click();
			
			List<WebElement> filterList =driver.findElements(By.xpath("//button[text() = 'clear all']//parent::div//following-sibling::div//span"));
			for(WebElement ele : filterList)
			{
				ele.getText();
				System.out.println(ele.getText());
				if(ele.getText().equals("Shampoo"))
				{
					System.out.println("Filtered with shampoo");
					break;
					
				}
				
			}
			driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
			Set<String> windows = driver.getWindowHandles();
			List<String> windowList = new ArrayList<String>(windows);
			driver.switchTo().window(windowList.get(1));
			WebElement size = driver.findElement(By.xpath("//select[@title = 'SIZE']"));
			Select select = new Select(size);
			
			select.selectByVisibleText("175ml");
			String mrp = driver.findElement(By.xpath("//h1[contains(text(), 'Oreal Paris Colour Protect Shampoo')]//following-sibling::div[2]//span[text() = 'MRP:']//following-sibling::span")).getText();
			mrp = mrp.replaceAll("[^0-9]", "");
			System.out.println("MRP is " +mrp);
			
			driver.findElement(By.xpath("//span[text() = 'ADD TO BAG']")).click();
			
			driver.findElement(By.xpath("//span[@class = 'cart-count']//parent::button")).click();
			driver.switchTo().frame(0);
			String amount = driver.findElement(By.xpath("//span[text() = 'Grand Total']//parent::div/div")).getText();
			 amount = amount.replaceAll("[^0-9]", "");
			System.out.println("Total Amount is " +amount);
			driver.findElement(By.xpath("//span[text() = 'PROCEED']")).click();
			driver.findElement(By.xpath("//button[text() = 'CONTINUE AS GUEST']")).click();
			String totalAmount = driver.findElement(By.xpath("//div[text() = 'Grand Total']//following-sibling::div[@class = 'value']")).getText();
			totalAmount = totalAmount.replaceAll("[^0-9]", "");
			System.out.println("Total Amount after checkout is " +totalAmount);
			if(totalAmount.equals(amount))
				System.out.println("Amount is same even after checkout");
		}
		
		
	}

}
