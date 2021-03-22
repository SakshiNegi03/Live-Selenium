import java.awt.AWTException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WithoutSignin {
	public static void main(String[] args) throws AWTException, InterruptedException {
		String cwd = Paths.get("").toAbsolutePath().toString();
		String filePath = cwd + "/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);

		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

//maximize window
		driver.manage().window().maximize();

//impicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

// hover over women option
		Actions actions = new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("//a[@title='Women']"));

// Mouse hover menuOption 'women'
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'women'");

// Now Select 'casual dress' from sub menu which has got displayed on mouse
// hover of 'women'
		WebElement subMenuOption = driver
				.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a"));
		subMenuOption.click();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

// scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

// hovering over dress picture
		WebElement dress = driver.findElement(By.xpath("//img[@title='Printed Dress']"));
		actions.moveToElement(dress).perform();
		System.out.println("dress hover done");

// add to cart
		WebElement add = driver.findElement(By.xpath("//span[text()='Add to cart']"));
		add.click();

// proceed to check out
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

// scrolling down
		js.executeScript("window.scrollBy(0,800)");

// proceed to check out 2
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

// validating
		Assert.assertTrue("You cannot checkout without Sign-in",
				driver.getPageSource().contains("Already registered?"));

// Sign in page appear
		System.out.println("please sign in to proceed your order ");

		driver.quit();

	}
}