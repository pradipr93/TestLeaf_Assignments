package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundActions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Setup is done");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions action = new Actions(driver);
		WebElement dragEle = driver.findElement(By.id("draggable"));
		action.dragAndDropBy(dragEle, 100, 70).perform();
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement resizeEle = driver.findElement(By.xpath("//div[contains(@class, 'ui-resizable-handle')][contains(@class, 'ui-resizable-se')][contains(@class, 'ui-icon')][contains(@class, 'ui-icon-gripsmall-diagonal-se')]"));
		action.clickAndHold(resizeEle).moveByOffset(30, 60).perform();
		driver.get("http://www.leafground.com/pages/selectable.html");
		WebElement selectEle1 = driver.findElement(By.xpath("//li[text()= 'Item 1']"));
		WebElement selectEle7 = driver.findElement(By.xpath("//li[text()= 'Item 7']"));
		action.clickAndHold(selectEle1).keyDown(Keys.CONTROL).click(selectEle7).keyDown(Keys.CONTROL).perform();
		driver.get("http://www.leafground.com/pages/sortable.html");
		WebElement sortEle1 = driver.findElement(By.xpath("//li[contains(@class, 'ui-state-default')][contains(@class, 'ui-sortable-handle')][text() = 'Item 1']"));
		WebElement sortEle2 = driver.findElement(By.xpath("//li[contains(@class, 'ui-state-default')][contains(@class, 'ui-sortable-handle')][text() = 'Item 2']"));
		WebElement sortEle3 = driver.findElement(By.xpath("//li[contains(@class, 'ui-state-default')][contains(@class, 'ui-sortable-handle')][text() = 'Item 3']"));
		WebElement sortEle4 = driver.findElement(By.xpath("//li[contains(@class, 'ui-state-default')][contains(@class, 'ui-sortable-handle')][text() = 'Item 4']"));
		WebElement sortEle6 = driver.findElement(By.xpath("//li[contains(@class, 'ui-state-default')][contains(@class, 'ui-sortable-handle')][text() = 'Item 6']"));
		WebElement sortEle7 = driver.findElement(By.xpath("//li[contains(@class, 'ui-state-default')][contains(@class, 'ui-sortable-handle')][text() = 'Item 7']"));
		action.clickAndHold(sortEle1).moveToElement(sortEle4).clickAndHold(sortEle3).moveToElement(sortEle7).clickAndHold(sortEle2).moveToElement(sortEle6).release().perform();
	}

}
