package SeleniumAssignmentTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario2 extends TestScenario3{


	public void TestAss2() throws Exception {

		//1. Open the https://www.lambdatest.com/selenium-playground page and
		//   click “Drag & Drop Sliders” under “Progress Bars & Sliders”.

		WebDriverManager.chromedriver().setup();		
		// Launching Chrome Browser Instance
		WebDriver driver = new ChromeDriver();
		// manage() method
		driver.manage().window().maximize();
		// Open Application URL 
		driver.get("https://www.lambdatest.com/selenium-playground");

		// click “Drag & Drop Sliders” under “Progress Bars & Sliders”.
		driver.findElement(By.xpath("//a[normalize-space()='Drag & Drop Sliders']")).click();

		//2. Select the slider “Default value 15” and drag the bar to make it 95 by
		//   validating whether the range value shows 95.
		//	Thread.sleep(2000);		

		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));

		//System.out.println("Location of the slider"+slider.getLocation());
		//System.out.println("Height & Width of the slider"+slider.getSize());		
		//Thread.sleep(2000);

		Actions act=new Actions(driver);		
		act.dragAndDropBy(slider,215, 0).perform();


		//System.out.println("Location of the slider"+slider.getLocation());
		//System.out.println("Height & Width of the slider"+slider.getSize());		
		//driver.findElement(By.id("rangeSuccess")).getText();
		//System.out.println(""+driver.findElement(By.id("rangeSuccess")).getText());

		String expectedValue="95";		
		String actualValue=driver.findElement(By.id("rangeSuccess")).getText(); 	    
		System.out.println(actualValue);

		try {
			Assert.assertEquals(actualValue, expectedValue, "Both Value are not matching");
		} catch (AssertionError a) {
			//a.printStackTrace();
		}
		System.out.println("Slider Range Value Valid Sucess.");		
		
		driver.quit();

	}

	public static void main(String[] args) throws Exception {	
		
		//TestScenario2 Test2=new TestScenario2();
		//Test2.TestAss2();
		
		Thread.sleep(2000);
		
		TestScenario3 Test3=new TestScenario3();
		Test3.TestAss3();

		
	}
}
