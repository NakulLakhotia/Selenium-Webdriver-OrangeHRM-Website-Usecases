package holapack;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class scenariofour {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/NAKUL LAKHOTIA/Documents/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Scenario- To Apply leave using Actions & Select Class
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
		

		WebElement leave = driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']/b"));
		
		Actions act=new Actions(driver);
		act.moveToElement(leave).perform();
		// to move to the Leave section
		WebElement apply = driver.findElement(By.xpath("//a[@id='menu_leave_applyLeave']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(apply).click().perform();
		// to select the leave type
		WebElement leaveType = driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
		Select sel=new Select(leaveType);
		sel.selectByVisibleText("US - Personal");
		Thread.sleep(3000);
		// to print the leave balance
		WebElement balance = driver.findElement(By.xpath("//div[@id=\'applyleave_leaveBalance\']"));
		String leaves=balance.getText();
		System.out.println(leaves.substring(0,1));
		// to enter from,to and comment, click on apply
		WebElement fromDate = driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
		fromDate.click();
		fromDate.sendKeys("2020-11-23");
		Actions act2=new Actions(driver);
		act2.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		
		//WebElement toDate= driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
		act2.sendKeys(Keys.TAB).perform();
		act2.sendKeys("2020-12-02").perform();
		act2.sendKeys(Keys.TAB).perform();
		Thread.sleep(3000);
		
		WebElement errorMessage = driver.findElement(By.xpath("//a[@id='leaveBalance_details_link']"));
		System.out.println(errorMessage.getText());
		
		
		
		
		driver.close();
}

}
