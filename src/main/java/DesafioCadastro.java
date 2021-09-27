import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastro{
	
	private WebDriver driver;
	
	@Before
	public void inicia() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrador.RSI9999\\Desktop\\Donwloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:\\" + System.getProperty("user.dir") + "\\src\\main\\resources\\componentes.html");
	}
	
	@Test
	public void encerra() {
		driver.quit();
	}
	public void DesafioCadastroCompleto() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Marcondes");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");
		//WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		//Select combo = new Select(element);
		//combo.selectByValue("superior");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
		//WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		//Select combo2 = new Select(elemento);
		//combo2.selectByValue("futebol");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Marcondes"));
		Assert.assertEquals("Sobrenome: Santos", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes:", driver.findElement(By.id("descSugestoes")).getText());
	}
	
}
