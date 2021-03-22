import java.awt.AWTException;
import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.Assert;
public class BookingFlight {
	public static void main(String[] args) throws AWTException, InterruptedException {
String cwd = Paths.get("").toAbsolutePath().toString();
		String filePath = cwd + "/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);

		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
driver.findElement(By.xpath("//a[contains(text(),'Delhi')]")).click();
driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
List<WebElement> cities=driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//div[@class='search_options_menucontent']//a"));
for(WebElement city: cities){
      Assert.assertFalse(city.getText().equals("Delhi (DEL)"));
}
 driver.quit();
}
	
}