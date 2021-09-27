import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteAlert {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicia() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrador.RSI9999\\Desktop\\Donwloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:\\" + System.getProperty("user.dir") + "\\src\\main\\resources\\componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void encerra() {
		driver.quit();
	}
	
	@Test
	public void DeveInteragirComAlertSimples() {
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Alert Simples", texto);
		
		dsl.escrever("elementosForm:Nome", texto);
		Assert.assertEquals(dsl.obterValorCampo("elementosForm:nome"), texto);
	}
	
	@Test
	public void DeveInteragirComAlertConfirmar() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoEAceita());
	}
			
	@Test
	public void DeveInteragirComPrompt() {
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("Marcondes");
		alerta.accept();
		Assert.assertEquals("Era Marcondes?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
	}
}