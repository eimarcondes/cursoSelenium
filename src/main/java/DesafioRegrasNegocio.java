import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioRegrasNegocio {
	
	private WebDriver driver;
			
	@Before
	public void inicializa() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrador.RSI9999\\Desktop\\Donwloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:\\" + System.getProperty("user.dir") + "\\src\\main\\resources\\componentes.html");
	}
	
	@After
	public void encerra() {
			driver.quit();
	}
	
	@Test
	public void TestarNome() {
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alerta = driver.switchTo().alert();
			String texto = alerta.getText();
			Assert.assertEquals("Nome eh obrigatorio", texto);
	}
	@Test
	public void TestarSobrenome() {
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcondes");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alerta = driver.switchTo().alert();
			String texto = alerta.getText();
			Assert.assertEquals("Sobrenome eh obrigatorio", texto);
	}
	@Test
	public void TestarSexo() {
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcondes");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alerta = driver.switchTo().alert();
			String texto = alerta.getText();
			Assert.assertEquals("Sexo eh obrigatorio", texto);
	}
	@Test
	public void TestarComidaFavorita() {
			driver.manage().window().maximize();
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcondes");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alerta = driver.switchTo().alert();
			String texto = alerta.getText();
			Assert.assertEquals("Tem certeza que voce eh vegetariano?", texto);
	}
	@Test
	public void TestarEsportes() {
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcondes");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
			combo.selectByValue("futebol");
			combo.selectByValue("nada");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alerta = driver.switchTo().alert();
			String texto = alerta.getText();
			Assert.assertEquals("Voce faz esporte ou nao?", texto);
	}
}
