package holapack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class scenarioseven {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/NAKUL LAKHOTIA/Documents/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Scenario- To logout by clicking on the username on top-right corner
		String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		driver.get(baseUrl);
		
		WebElement userName = driver.findElement(By.xpath("//div/input[@name='txtUsername']"));
		userName.sendKeys("Admin");
		  
		WebElement pass = driver.findElement(By.xpath("//div/input[@name='txtPassword']"));
		pass.sendKeys("admin123");
		
		WebElement login = driver.findElement(By.xpath("//div/input[@type='submit']"));
		login.click();
		// sleep for 3 seconds
		Thread.sleep(3000);
		
		WebElement userNam = driver.findElement(By.xpath("//a[@id='welcome']"));
		userNam.click();
		Thread.sleep(3000);
		
		WebElement logoutButton = driver.findElement(By.xpath("//div[@id=\"welcome-menu\"]/ul/li[2]/a"));
		logoutButton.click();
		
		
		}
}
