package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {
	
	public ChromeDriver driver;
	//Set up Chrome Driver according to browser and launch chrome
			public void setUpChrome() throws Exception {
				WebDriverManager.chromedriver().setup();
				System.out.println("Chrome Driver Setup - done");
				driver = new ChromeDriver();
				System.out.println("Chrome Launched");
				
			}

			//launch application url
			public void launchUrl(String url)
			{
				driver.get(url);
				System.out.println( driver.getTitle() +": Application Launched");
				driver.manage().window().maximize();
			}
			
			//edit features
			public void verifyEdit()
			{
				driver.findElement(By.id("email")).sendKeys("ramnathgovind1945@gmail.com");
				System.out.println("Entered Email");
				WebElement appendText = driver.findElement(By.xpath("//label[contains(text(), 'Append a text')]//following-sibling::input"));
				appendText.sendKeys("Hello All", Keys.TAB);
				System.out.println("Entered Text and Presed TAB");
				String defaultText =driver.findElement(By.name("username")).getAttribute("value");
				System.out.println("Default value is: " +defaultText);
				driver.findElement(By.xpath("//label[contains(text(), 'Clear the text')]//following-sibling::input")).clear();
				System.out.println("Text is clear");
				WebElement disabledField = driver.findElement(By.xpath("//label[contains(text(), 'disabled')]//following-sibling::input"));
				if(!disabledField.isEnabled())
					System.out.println("Text field is disabled");
				else
					
					System.out.println("Text field is enabled");
	
			}
			
			public void verifyButton() {
				
				driver.findElement(By.id("home")).click();
				System.out.println("Clicked on button to travel home page");
				driver.findElement(By.xpath("//img[@alt = 'Buttons']")).click();
				Point location = driver.findElement(By.id("position")).getLocation();
				System.out.println("Location of Get Position Button" +location);
				String color = driver.findElement(By.id("color")).getCssValue("background-color");
				System.out.println("Color of button is: "+color);
				Dimension size = driver.findElement(By.id("color")).getSize();
				System.out.println("Height & Widtth of a size button is: "+size);

			}
			
			public void verifyCheckbox()
			{
				driver.findElement(By.xpath("//label[text() = 'Select the languages that you know?']//following-sibling::input")).click();
				System.out.println("Clicked on JAVA");
				driver.findElement(By.xpath("(//label[text() = 'Select the languages that you know?']//following-sibling::input)[3]")).click();
				System.out.println("Clicked on SQL");
				WebElement cnfmCheck = driver.findElement(By.xpath("//label[text() = 'Confirm Selenium is checked']//following-sibling::input"));
				if(cnfmCheck.isSelected())
					System.out.println("Selenium is already selected");
				else
				driver.findElement(By.xpath("//div[contains(text(), 'Selenium')]/input")).click();
				
				List<WebElement> deSelectChecklist = driver.findElements(By.xpath("//label[text() = 'DeSelect only checked']/following-sibling::input"));
				
				for(int i=0; i<deSelectChecklist.size(); i++)
				{
					System.out.println(deSelectChecklist.get(i).getAttribute("checked"));
					
					
					if(deSelectChecklist.get(i).getAttribute("checked")!= null && deSelectChecklist.get(i).getAttribute("checked").equals("true"))
					{
						deSelectChecklist.get(i).click();
						
					    System.out.println("Clicked on check box");
					}
					
				}
				
				List<WebElement>  allOptions = driver.findElements(By.xpath("//label[contains(text(), 'Select all below checkboxes')]//following-sibling::input"));
				for(WebElement eachOption : allOptions)
				{
					eachOption.click();
					System.out.println("clicked on Option");
					
				}
			}
			
			public void verifyDropdown()
			{
				Select selectObj = new Select(driver.findElement(By.id("dropdown1")));
				
				Select selectObj2 = new Select(driver.findElement(By.name("dropdown2")));
				
				Select selectObj3 = new Select(driver.findElement(By.id("dropdown3")));
				selectObj.selectByIndex(1);
				System.out.println("Selected Drowndown1 using index");
				selectObj2.selectByVisibleText("Selenium");
				System.out.println("Selected Drowndown2 using text");
				selectObj3.selectByValue("1");
				System.out.println("Selected Drowndown2 using value");
				Select selectOptionsObj = new Select(driver.findElement(By.className("dropdown")));
				List<WebElement> selectOptionsObjList = selectOptionsObj.getOptions();
				
				for(WebElement eachOption: selectOptionsObjList)
				{
					String optionText = eachOption.getText();
					System.out.println(optionText);
				}
				
				driver.findElement(By.xpath("//option[text() = 'You can also use sendKeys to select']//parent::select")).sendKeys("Selenium", Keys.ENTER);
				
				List<WebElement> multiSelectOptionsList = new Select(driver.findElement(By.xpath("//option[text() = 'Select your programs']//parent::select"))).getOptions();
				
				for(int i =1; i<multiSelectOptionsList.size(); i++)
				{
					multiSelectOptionsList.get(i).click();
					System.out.println("Selected Option");
				}
			}
			
			public void verifyLinks() {
				driver.findElement(By.linkText("Go to Home Page")).click();
				
				if(verifyTitle("TestLeaf - Selenium Playground"))
					System.out.println("Navigated to Home Page");
				else
					System.out.println("Home Page is not displayed");
				launchUrl("http://leafground.com/pages/Link.html");
				WebElement where = driver.findElement(By.partialLinkText("Find where am"));
				
				String href = driver.findElement(By.partialLinkText("Find where am")).getAttribute("href");
				
				System.out.println("Find Where destination link : " +href);
				driver.findElement(By.linkText("Verify am I broken?")).click();
				if(driver.getTitle().contains("404"))
				System.out.println("Link is broken");
				else
					System.out.println("Link is not broken");	
				launchUrl("http://leafground.com/pages/Link.html");
				
				System.out.println(driver.findElement(By.xpath("//label[text() = '(Interact with same link name)']//preceding-sibling::a")).getAttribute("value"));
				driver.findElement(By.linkText("How many links are available in this page?")).click();
				
				List<WebElement> linkList = driver.findElements(By.tagName("a"));
				System.out.println("Total Links  available in page: "+linkList.size());
			}
			
			//Verify image links
			public void verifyImage()
			{
				driver.findElement(By.xpath("//label[text() = 'Click on this image to go home page']//following-sibling::img")).click();
				System.out.println("Clicked on image");
				if(verifyTitle("TestLeaf - Selenium Playground"))
					System.out.println("Navigated to Home Page");
				else
					System.out.println("Home Page is not displayed");
				launchUrl("http://leafground.com/pages/Image.html");
				if(driver.findElement(By.xpath("//label[text() = 'Am I Broken Image?']//following-sibling::img")).getAttribute("onclick")!= null)
				System.out.println("Link is not broken");
				else
					System.out.println("Link is broken");
				driver.findElement(By.xpath("//label[text() = 'Click me using Keyboard or Mouse']//following-sibling::img")).click();
				System.out.println("Clicked on Keyboard or mouse image");
			}
			
			//verify tile of application
			public boolean verifyTitle(String title)
			{
				String text = driver.getTitle();
				if(text.equals(title))
				{
				System.out.println("Title is displayed as expected: " +text);
				return true;
				}
				else
				{
				System.out.println("Title is not displayed as expected: " +text);
				return false;
				}
			}
			
			//close Browser
			public void closeChrome() {

				driver.close();
				System.out.println("Closed Chrome");
			}
	
			
	public static void main(String[] args) throws Exception {
		
		LeafGroundEdit LeafGroundEditObj = new LeafGroundEdit();
	    LeafGroundEditObj.setUpChrome();
		
		LeafGroundEditObj.launchUrl("http://leafground.com/pages/Edit.html");
		//Edit Verification
		LeafGroundEditObj.verifyEdit();
		
		
		LeafGroundEditObj.launchUrl("http://leafground.com/pages/Button.html");
		//Button Verification
		LeafGroundEditObj.verifyButton();
		
		LeafGroundEditObj.launchUrl("http://leafground.com/pages/checkbox.html");
		//Checkbox Verification
		LeafGroundEditObj.verifyCheckbox();

		LeafGroundEditObj.launchUrl("http://leafground.com/pages/Dropdown.html");
		//Dropdown Verification
		LeafGroundEditObj.verifyDropdown();
	
		LeafGroundEditObj.launchUrl("http://leafground.com/pages/Link.html");
		//Link Verification
		LeafGroundEditObj.verifyLinks();
		
		LeafGroundEditObj.launchUrl("http://leafground.com/pages/Image.html");
		//Image Verification
		LeafGroundEditObj.verifyImage();
		LeafGroundEditObj.closeChrome();
	}

}
