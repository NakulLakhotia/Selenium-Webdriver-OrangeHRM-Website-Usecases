package holapack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class scenarioone {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/NAKUL LAKHOTIA/Documents/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Scenario- To feed the wrong password and check for error message
		String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		driver.get(baseUrl);
		
		WebElement userName = driver.findElement(By.xpath("//div/input[@name='txtUsername']"));
		userName.sendKeys("Admin");
		  
		WebElement pass = driver.findElement(By.xpath("//div/input[@name='txtPassword']"));
		pass.sendKeys("admin7777");
		
		String expectedMess="Invalid credentials";
		
		WebElement login = driver.findElement(By.xpath("//div/input[@type='submit']"));
		login.click();
		
		WebElement acmessage = driver.findElement(By.xpath("//div[@id='divLoginButton']/span[@id='spanMessage']"));
		String actualMess=acmessage.getText();
		
		if(actualMess.equals(expectedMess))
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");		
		}
		
		driver.close();
		
	}

}
