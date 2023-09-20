package SeleniumAssignmentTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario1 extends TestScenario2 {

	public void TestAss1() throws Exception {

		//1.Open LambdaTest’s Selenium Playground from
		WebDriverManager.chromedriver().setup();		
		// Launching Chrome Browser Instance
		WebDriver driver = new ChromeDriver();
		// manage() method
		driver.manage().window().maximize();
		// Open Application URL 
		driver.get("https://www.lambdatest.com/selenium-playground");

		//2. Click “Simple Form Demo” under Input Forms.
		driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']")).click();

		//3. Validate that the URL contains “simple-form-demo”.
		String url=driver.getCurrentUrl();
		System.out.println("URL: " +url);
		String urlTitle =driver.getTitle();
		System.out.println("URL Title: "+ urlTitle);

		if(driver.getCurrentUrl().endsWith("simple-form-demo")) {
			System.out.println("URL contains Passed ");
		}else {
			System.out.println("URL contains Failed ");
		}

		//4. Create a variable for a string value E.g: “Welcome to LambdaTest”

		String StringValue="Welcome to LambdaTest";

		//5.Use this variable to enter values in the “Enter Message” text box.
		driver.findElement(By.id("user-message")).sendKeys(StringValue);

		//6. Click “Get Checked Value"
		driver.findElement(By.id("showInput")).click();	

		Thread.sleep(2000);

		//7. Validate whether the same text message is displayed in the right-hand
		//    panel under the “Your Message:” section.
		String str1=driver.findElement(By.id("user-message")).getAttribute("value");
		System.out.println(str1);
		String str2=driver.findElement(By.id("message")).getText();	
		System.out.println(str2);

		if(str1.equals(str2)) {
			System.out.println("Passed");
		}else
			System.out.println("Failed");	
		
		driver.quit();
	}

	public static void main(String[] args) throws Exception 
	{
		//TestScenario1 Test1=new TestScenario1();
		//Test1.TestAss1();
		
		Thread.sleep(2000);

		TestScenario2 Test2=new TestScenario2();
		Test2.TestAss2();

	}

}
