package seleniumPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

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

	public static void closeAndSwitchParentWindow(String parentWindow) {
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("Application Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println("Clicked on CRM/SFA icon");
		driver.findElement(By.linkText("Contacts")).click();
		System.out.println("Clicked on Contact tab");
		driver.findElement(By.linkText("Merge Contacts")).click();
		System.out.println("Clicked on Merge Contacts");
		driver.findElement(By.xpath("//a[contains(@href, 'LookupContacts')][contains(@href, 'partyIdFrom')]")).click();
		System.out.println("Clicked on From contact Widget");
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		
		if (switchChildWindow(windowHandles, "Find Contacts")) {
			String contactID = driver
					.findElement(By.xpath(
							"//div[contains(@class, 'x-grid3-cell-inner')][contains(@class, 'x-grid3-col-partyId')]"))
					.getText();
			System.out.println(contactID);

		}
		closeAndSwitchParentWindow(parentWindow);
		driver.findElement(By.xpath("//a[contains(@href, 'LookupContacts')][contains(@href, 'partyIdFrom')]")).click();
		System.out.println("Clicked on To contact Widget");
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		if (switchChildWindow(windowHandles2, "Find Contacts")) {
			String contact = driver
					.findElement(By.xpath(
							"(//div[contains(@class, 'x-grid3-cell-inner')][contains(@class, 'x-grid3-col-partyId')])[2]"))
					.getText();
			System.out.println(contact);

		}
		closeAndSwitchParentWindow(parentWindow);
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		driver.quit();
	}

	
}
