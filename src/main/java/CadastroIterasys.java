import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroIterasys {
	@Test
	public void CadastrarIterasys() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrador.RSI9999\\Desktop\\Donwloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.iterasys.com.br/");
		//WebElement link = driver.findElement(By.linkText("Cadastro"));
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("email")).sendKeys("marcondes.kollassuano@gmail.com");
		driver.findElement(By.id("senha")).sendKeys("Keeggo@2021");
		driver.findElement(By.id("btn_login")).click();
		Assert.assertEquals("Meus Cursos - Iterasys", driver.getTitle());
		driver.quit();
	}
}
