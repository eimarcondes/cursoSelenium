import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrador.RSI9999\\Desktop\\Donwloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().setSize(new Dimension(1200,765));
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
