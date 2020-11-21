package holapack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class scenariosix {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/NAKUL LAKHOTIA/Documents/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Scenario- To update the information on my info page
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
		// click on myinfo
		WebElement myInfo = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b"));
		myInfo.click();
		Thread.sleep(3000);
		
		WebElement oldName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
		System.out.println(oldName.getText());
		
		WebElement editBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
		editBtn.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
		firstName.clear();
		firstName.sendKeys("Michael");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
		lastName.clear();
		lastName.sendKeys("Jhulelal");
		
		WebElement dob = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
		dob.clear();
		dob.sendKeys("1998-12-17");
		
		WebElement saveBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
		saveBtn.click();
		
		Thread.sleep(4000);
		
		WebElement newName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
		System.out.println(newName.getText());
		
		Thread.sleep(3000);
		
		driver.close();
		
		
}
}
		