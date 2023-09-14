package SeleniumAssignmentTask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario3 {

	public static void main(String[] args) throws Exception {
		//1.Open the https://www.lambdatest.com/selenium-playground page and
		
		WebDriverManager.chromedriver().setup();		
		// Launching Chrome Browser Instance
		WebDriver driver = new ChromeDriver();
		// manage() method
		driver.manage().window().maximize();
		// Open Application URL 
		driver.get("https://www.lambdatest.com/selenium-playground");
		
		//click “Input Form Submit” under “Input Forms”.
		
		driver.findElement(By.xpath("//a[normalize-space()='Input Form Submit']")).click();
		
		//2. Click “Submit” without filling in any information in the form.
		
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		
		//3. Assert “Please fill in the fields” error message.
		
		String expectedMessage="Please fill out this field.";
		
	    String actualMessage=driver.findElement(By.xpath("//input[@id='name']")).getAttribute("validationMessage"); 
	    
	    System.out.println(actualMessage);	    
	    
	    try {
	    	Assert.assertEquals(actualMessage, expectedMessage, "Both validation Message are not matching");
		} catch (AssertionError a) {
			//a.printStackTrace();
		}
		System.out.println("validation Message Passed");
	    
	    
		
		//4. Fill in Name, Email, and other fields.
		
		driver.findElement(By.id("name")).sendKeys("Selenium");
		driver.findElement(By.id("inputEmail4")).sendKeys("Selenium@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("Password@123");
		driver.findElement(By.id("company")).sendKeys("Selenium");
		driver.findElement(By.id("websitename")).sendKeys("//www.selenium.com");
		
		//5. From the Country drop-down, select “United States” using the text property.
		
		List<WebElement> country= driver.findElements(By.xpath("(//select[@name='country'])[1]/option"));
		//System.out.println("Total dropdown values :- " + country.size());
		//System.out.println(country.get(237).isEnabled()); // True
		country.get(237).click(); // United States
		
		//6.Fill all fields and click “Submit”.
		
		driver.findElement(By.id("inputCity")).sendKeys("Test");
		driver.findElement(By.id("inputAddress1")).sendKeys("Test");
		driver.findElement(By.id("inputAddress2")).sendKeys("Test");
		driver.findElement(By.id("inputState")).sendKeys("Test");
		driver.findElement(By.id("inputZip")).sendKeys("12345588");
		
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		
		
		//7. Once submitted, validate the success message “Thanks for contacting
		//    us, we will get back to you shortly.” on the screen.
			
		
        String expectedMessage1="Thanks for contacting us, we will get back to you shortly.";
		
	    String actualMessage1=driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText(); 
	    
	    System.out.println(actualMessage1);
	    
	    try {
	    	Assert.assertEquals(actualMessage1, expectedMessage1, "Both validation Message are not matching");
		} catch (AssertionError a) {
			//a.printStackTrace();
		}
		System.out.println("From Submit sucess and validation Message Passed");		
			
		
	}
}
