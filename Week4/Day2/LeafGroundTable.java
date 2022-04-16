package seleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Setup is done");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		int colSize = driver.findElements(By.xpath("//table//tbody//tr[2]/td")).size();
		
		int rowSize = driver.findElements(By.xpath("//table//tbody//tr//following-sibling::tr")).size();
		List<WebElement> col1 = driver.findElements(By.xpath("//table//tbody//tr//following-sibling::tr/td[1]/font"));
		List<WebElement> col2 = driver.findElements(By.xpath("//table//tbody//tr//following-sibling::tr/td[2]/font"));
		System.out.println("Column Size is: "+colSize);
		System.out.println("Row Size is: "+rowSize);
		List<String> progressList = new ArrayList<String>();
		List<Integer> progressListCompare = new ArrayList<Integer>();
		for(int i=0; i<rowSize; i++)
		{
			if(col1.get(i).getText().trim().equals("Learn to interact with Elements"))
			{
				
				progressList.add(col2.get(i).getText().trim());
				
			}
		}
		System.out.println("Progress Value: " +progressList);
		List<Integer> progressPercentList = new ArrayList<Integer>();
		for(int i=0; i<rowSize; i++)
		{
			System.out.println(col2.get(i).getText().trim());
			int percent = Integer.parseInt(col2.get(i).getText().replaceAll("[^0-9]", ""));
			progressPercentList.add(percent);
			progressListCompare.add(percent);
			
		}
		Collections.sort(progressPercentList);
		
		System.out.println(progressPercentList);
		int leastProgress = progressPercentList.get(0);
		int index =  progressListCompare.indexOf(leastProgress);
		System.out.println(index);
		int i = index+1;
		driver.findElement(By.xpath("//table//tbody//tr//following-sibling::tr["+i+"]/td[2]//following-sibling::td/input")).click();
		driver.get("http://www.leafground.com/pages/sortable.html");
		List<WebElement> items = driver.findElements(By.xpath("//ul[@id= 'sortable']//li"));
		for(WebElement ele : items)
		{
			System.out.println(ele.getText());
			ele.click();
		}
	}
}
