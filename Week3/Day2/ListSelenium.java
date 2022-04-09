package seleniumPractice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListSelenium {
	// declared driver as global variable
	public static ChromeDriver driver;

	public ListSelenium() {
		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Setup is done");
		driver = new ChromeDriver();
	}

	public void launchUrl(String url) {
		driver.get(url);
		System.out.println("Application Launched");
		driver.manage().window().maximize();
	}

	public void getProductList() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder = 'Search AJIO']")).sendKeys("bags", Keys.ENTER);
		Thread.sleep(2000);
		WebElement menCheck = driver.findElement(By.id("Men"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", menCheck);
		Thread.sleep(2000);
		WebElement fashionBagCheck = driver.findElement(By.xpath("//input[contains(@id, '- Fashion Bags')]"));
		js.executeScript("arguments[0].click();", fashionBagCheck);
		Thread.sleep(2000);
		String countText = driver.findElement(By.xpath("//div[@class = 'length']")).getText();
		System.out.println(countText);
		String count = getDigit(countText);
		System.out.println("Total Count of Bag is: " +count);
		//Declared list to store List of brand elements
		List<WebElement> brandListElement = driver.findElements(By.className("brand"));
		//Declared set to get unique brand names
		Set<String> brandSet = new HashSet<String>();
		//iterate loop to get text from the brandList
		for(WebElement list : brandListElement)
		{
			brandSet.add(list.getText());
		}
		System.out.println(brandSet);
		//Declared list to store List of product elements
		List<WebElement> productListElement = driver.findElements(By.className("nameCls"));
		//Declared set to get unique product names
		Set<String> productSet = new HashSet<String>();
		//iterate loop to get text from the productList
		for(WebElement list : productListElement)
		{
			productSet.add(list.getText());
		}
		System.out.println(productSet);
	}
	//finds all disgit in given string
	public String getDigit(String str) {
		char[] ch = str.toCharArray();
		String res = "";
		for (char c : ch) {
			if (Character.isDigit(c)) 
			{
				res = res+c;
			}

		}

		return res;

	}

	public static void main(String[] args) throws InterruptedException {
		ListSelenium listObj = new ListSelenium();
		listObj.launchUrl("https://www.ajio.com/");
		listObj.getProductList();

	}
	// ic-close-quickview
}
