package holapack;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class scenariofive {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/NAKUL LAKHOTIA/Documents/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Scenario- To create a new timesheet
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
		
		WebElement time = driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']/b"));
		
		Actions act=new Actions(driver);
		act.moveToElement(time).perform();
		
		WebElement timeSheets = driver.findElement(By.xpath("//a[@id='menu_time_Timesheets']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(timeSheets).click().perform();
		WebElement mytimeSheets = driver.findElement(By.xpath("//a[@id='menu_time_viewMyTimesheet']"));
		act1.moveToElement(mytimeSheets).click().perform();
		
		// to select the date for timesheet
		WebElement sheetWeek = driver.findElement(By.xpath("//select[@id='startDates']"));
		Select sel=new Select(sheetWeek);
		sel.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement status = driver.findElement(By.xpath("//*[@id=\"timesheet_status\"]/h2"));
		System.out.println(status.getText());
		
		// to edit and add
		WebElement edit = driver.findElement(By.xpath("//input[@id='btnEdit']"));
		edit.click();
		Thread.sleep(3000);
		
		WebElement row = driver.findElement(By.xpath("//input[@id='initialRows_0_projectName']"));
		row.clear();
		row.sendKeys("gl");
		
		// to select the item from the dropdown list
		String searchText = "Global Corp and Co - Global Software phase - 1";
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div[4]"));

		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		Thread.sleep(3000);
		for (WebElement option : options)
		{
		    if (option.getText().equals(searchText))
		    {
		        option.click(); // click the desired option
		        break;
		    }
		}
		
		// to select the activity name
		
		Thread.sleep(4000); // need to wait for sometime so that dropdown can load
	
		WebElement activity = driver.findElement(By.xpath("//select[@id='initialRows_0_projectActivityName']"));
		Select sel1=new Select(activity);
		sel1.selectByValue("7");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='initialRows_0_0']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_1']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_2']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_3']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_4']")).sendKeys("8:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_5']")).sendKeys("0:00");
		driver.findElement(By.xpath("//input[@id='initialRows_0_6']")).sendKeys("0:00");
		
		driver.findElement(By.xpath("//input[@id='submitSave']")).click();
		
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		
		Thread.sleep(3000);
		
		WebElement newstatus = driver.findElement(By.xpath("//*[@id=\"timesheet_status\"]/h2"));
		System.out.println(newstatus.getText());
		
		
		driver.close();
		
		
		
}
}
