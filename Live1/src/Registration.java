import java.awt.AWTException;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	public static void main(String[] args) throws AWTException, InterruptedException {
		String cwd = Paths.get("").toAbsolutePath().toString();
		String filePath = cwd + "/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);

		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();

// email create
		driver.findElement(By.id("email_create")).sendKeys("s@a.com");

//submit button 
		driver.findElement(By.id("SubmitCreate")).click();

		Thread.sleep(5000);

// selecting gender
		driver.findElement(By.id("id_gender2")).click();

//customer frist name 
		WebElement firstName = driver.findElement(By.name("customer_firstname"));// finding the web element using name
																					// locator
		firstName.sendKeys("Sakshi");

//customer last name
		WebElement lastName = driver.findElement(By.name("customer_lastname"));// finding the web element using name
																				// locator
		lastName.sendKeys("Negi");

//enter password 
		WebElement Password = driver.findElement(By.id("passwd"));// finding the web element using id locator
		Password.sendKeys("test@123");

// dropdown day
		WebElement staticDropdown = driver.findElement(By.id("days"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);

// dropdown month
		WebElement staticdrop = driver.findElement(By.id("months"));
		Select drop = new Select(staticdrop);
		drop.selectByIndex(3);

// years
		WebElement staticdrops = driver.findElement(By.id("years"));
		Select drops = new Select(staticdrops);
		drops.selectByIndex(23);

// your address

//first name
		WebElement fName = driver.findElement(By.id("firstname"));// finding the web element using name locator
		fName.sendKeys("SAKSHI");

		Thread.sleep(4000);

//last name
		WebElement lName = driver.findElement(By.id("lastname"));// finding the web element using name locator
		lName.sendKeys("Negi");

//comapny name
		WebElement cmp = driver.findElement(By.id("company"));// finding the web element using name locator
		cmp.sendKeys("TTN");

//address1
		driver.findElement(By.id("address1")).sendKeys("abc");

//address2
		driver.findElement(By.id("address2")).sendKeys("efg");

//city
		driver.findElement(By.id("city")).sendKeys("Delhi");

// state drop
		WebElement staticState = driver.findElement(By.id("id_state"));
		Select drop1 = new Select(staticState);
		drop1.selectByIndex(10);

// postcode
		driver.findElement(By.id("postcode")).sendKeys("11004");

// additional
		driver.findElement(By.id("other")).sendKeys("123456778");

// home phone 
		driver.findElement(By.id("phone")).sendKeys("3456789");

//mobile phone 
		driver.findElement(By.id("phone_mobile")).sendKeys("345678901");

// alias
		driver.findElement(By.id("alias")).sendKeys("lkjhgh");

// submit
		driver.findElement(By.id("submitAccount")).click();

		Thread.sleep(3000);

		WebElement ele = driver.findElement(By.className("info-account"));
		ele.getText();
		System.out.println(ele);
		
		driver.quit();

	}
}