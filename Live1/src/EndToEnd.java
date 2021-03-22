import java.awt.AWTException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EndToEnd {
	public static void main(String[] args) throws AWTException, InterruptedException {
		String cwd = Paths.get("").toAbsolutePath().toString();
		String filePath = cwd + "/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);

		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//maximize window
		driver.manage().window().maximize();
//impicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Enter Already Register email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("s@a.com");

//Enter Valid Password 
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("test@123");

		driver.findElement(By.id("SubmitLogin")).click();

// hover over women option

		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//a[@title='Women']"));

//Mouse hover menuOption 'women'
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'women'");

//Now Select 'casual dress' from sub menu which has got displayed on mouse hover of 'women'
		WebElement subMenuOption = driver
				.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a"));
		subMenuOption.click();

		Thread.sleep(4000);

//scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

//hovering over dress picture
		WebElement dress = driver.findElement(By.xpath("//img[@title='Printed Dress']"));
		actions.moveToElement(dress).perform();
		System.out.println("dress hover done");

// add to cart 

		WebElement add = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		add.click();

//proceed to check out
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

//scrolling down
		js.executeScript("window.scrollBy(0,800)");

//proceed to check out 2
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

// adding message 
		driver.findElement(By.name("message")).sendKeys("materil should be of fine quality", Keys.ENTER);

//proceed checkout 
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();

//scrolling down
		js.executeScript("window.scrollBy(0,500)");

//checking check box 
		driver.findElement(By.id("cgv")).click();

// process carrier 
		driver.findElement(By.name("processCarrier")).click();

//payment mode
		driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();

//scrolling down
		js.executeScript("window.scrollBy(0,600)");

// confirm order 
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		System.out.println("order is confirmed");

		driver.quit();
		

	}
}