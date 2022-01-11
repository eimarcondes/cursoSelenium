import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroIterasys {
	
	public WebDriver driver;
	
	@Before
	public void inicia() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrador.RSI9999\\Desktop\\Donwloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.iterasys.com.br/");
	}
	
	public void clicar(By by) {
		driver.findElement(by).click();
	}
	
	public void escrever(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		String texto = driver.findElement(by).getText();
		return texto;
	}
	
	@After
	public void encerra() {
		driver.quit();
	}
	
	@Test
	public void CadastrarIterasys() {
		clicar(By.linkText("Login"));
		escrever(By.id("email"), "marcondes.kollassuano@gmail.com");
		escrever(By.id("senha"), "Keeggo@2021");
		clicar(By.id("btn_login"));
		Assert.assertEquals("Meus Cursos - Iterasys", driver.getTitle());
	}
}
