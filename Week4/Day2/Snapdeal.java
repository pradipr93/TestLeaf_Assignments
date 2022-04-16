package seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static ChromeDriver driver;

	public static boolean switchChildWindow(Set<String> list, String title) {

		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(title)) {
				
				System.out.println("Found Window: "  +title);
				driver.manage().window().maximize();
				return true;
			}

		}
		return false;
	}

	public static void addPriceList(List<WebElement> eleList, List<Integer> strList)
	{
		for(WebElement ele: eleList)
		{
			strList.add(Integer.parseInt(ele.getText().replaceAll("[^0-9]", "")));
		}
	}
	public static void closeAndSwitchParentWindow(String parentWindow) {
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Setup is done");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(option);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.snapdeal.com/");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);
		WebElement menFashion = driver.findElement(By.xpath("//span[contains (text(), 'Men')][contains (text(), 'Fashion')]"));
		builder.moveToElement(menFashion).perform();
		WebElement sportsShoe = driver.findElement(By.linkText("Sports Shoes"));
		builder.click(sportsShoe).perform();
		String shoeCount = driver.findElement(By.xpath("//div[text() = 'Sports Shoes for Men']//following-sibling::div[contains(@class, 'child-cat-count')]")).getText();
		System.out.println("count of Sports Shoe is "+shoeCount);
		driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
		
		List<WebElement> priceListEle = driver.findElements(By.xpath("//span[contains(@id, 'display-price')]"));
		List<Integer> priceList = new ArrayList<Integer>();
		
		addPriceList(priceListEle, priceList);
		System.out.println(priceList);
		Collections.sort(priceList);
		System.out.println(priceList);
		
		driver.findElement(By.xpath("//span[text() = 'Sort by:']")).click();
		System.out.println("Clicked on Sort By");
		driver.findElement(By.xpath("//ul[@class = 'sort-value']//li/span//following-sibling::text()[contains(normalize-space(.), 'Price Low To High')]//parent::li")).click();
		System.out.println("Sorted by Price Low To High");
//		driver.navigate().refresh();
//		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(@id, 'display-price')]")));
//		Thread.sleep(5000);
		List<Integer> priceListLowToHigh = new ArrayList<Integer>();
		
		try
		{
		priceListEle = driver.findElements(By.xpath("//span[contains(@id, 'display-price')]"));
		
		addPriceList(priceListEle, priceListLowToHigh);
		System.out.println(priceListLowToHigh);
		}
		catch(StaleElementReferenceException e)
		{
			Thread.sleep(5000);
			priceListEle = driver.findElements(By.xpath("//span[contains(@id, 'display-price')]"));
			
			addPriceList(priceListEle, priceListLowToHigh);
			System.out.println(priceListLowToHigh);
		
		}
		//IN2204140921w88454
		if(priceList.get(0).equals(priceListLowToHigh.get(0)) 
				&& 
		   priceList.get(priceList.size()-1).equals(priceListLowToHigh.get(priceListLowToHigh.size()-1)))
		{
			System.out.println("Sorted as per price - Low to High");
		}
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(), 'GO')]")).click();
		String color ="";
		
		String filteredColor = "";
		String fromPrice ="";
		String toPrice = "";
		
		//driver.navigate().refresh();
		//Thread.sleep(4000);
		try
		{
		List<WebElement> colorEle = driver.findElements(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::span[@class = 'filter-prod-count']"));
		for(WebElement ele : colorEle)
		{
			//colorEle = driver.findElements(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::span[@class = 'filter-prod-count']"));
			if(ele.getText().equals("1"))
			{
				
				driver.findElement(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::span[@class = 'filter-prod-count']//preceding-sibling::span")).click();
				color= driver.findElement(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::a")).getText().trim();
				System.out.println("Filtered with Color: " +color);
				break;
			}
		}
		
	
		 filteredColor = driver.findElement(By.xpath("//div[contains(text(), 'Price:')]//following-sibling::div[contains(text(), 'Color:')]/a[contains(@data-key, 'Color')]")).getText();
		fromPrice = driver.findElement(By.xpath("//span[@class = 'from-price-text']")).getText();
		toPrice = driver.findElement(By.xpath("//span[@class = 'to-price-text']")).getText();
		}
		catch(StaleElementReferenceException e)
		{
			Thread.sleep(5000);
			
			List<WebElement> colorEle = driver.findElements(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::span[@class = 'filter-prod-count']"));
			for(WebElement ele : colorEle)
			{
				//colorEle = driver.findElements(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::span[@class = 'filter-prod-count']"));
				if(ele.getText().equals("1"))
				{
					
					driver.findElement(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::span[@class = 'filter-prod-count']//preceding-sibling::span")).click();
					color= driver.findElement(By.xpath("//span[contains(@class, 'filter-color-tile')]//following-sibling::a")).getText().trim();
					System.out.println("Filtered with Color: " +color);
					break;
				}
			}
			
		
			 filteredColor = driver.findElement(By.xpath("//div[contains(text(), 'Price:')]//following-sibling::div[contains(text(), 'Color:')]/a[contains(@data-key, 'Color')]")).getText();
			fromPrice = driver.findElement(By.xpath("//span[@class = 'from-price-text']")).getText();
			toPrice = driver.findElement(By.xpath("//span[@class = 'to-price-text']")).getText();
			
		}
		if(filteredColor.equals(color) && fromPrice.equals("900") && toPrice.equalsIgnoreCase("1200"))
		{
			System.out.println("Filtered with color and Price");
		}
		
		WebElement shoeImg = driver.findElement(By.xpath("//img[contains(@class, 'product-image')]"));
		Actions action = new Actions(driver);
		action.moveToElement(shoeImg).perform();
		WebElement quickViewButton = driver.findElement(By.xpath("//div[contains(text(), 'Quick View')]"));
		action.click(quickViewButton).perform();
		
		String Price = driver.findElement(By.xpath("//div[contains(text(), 'Rs')]/span[@class = 'payBlkBig']")).getText().trim();
		String offerPrice = driver.findElement(By.xpath("//span[contains(@class, 'percent-desc')]")).getText();
		System.out.println("Price of shoe is "+Price);
		System.out.println("Offer of shoe is "+offerPrice);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//snapshot//snapdeal.png");
		FileUtils.copyFile(src, dest);
		driver.findElement(By.xpath("//div[contains(@class, 'close')]/i[contains(@class, 'delete-sign')]")).click();

	}
}