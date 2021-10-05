import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioCadastro{
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicia() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrador.RSI9999\\Desktop\\Donwloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:\\" + System.getProperty("user.dir") + "\\src\\main\\resources\\componentes.html");
	dsl = new DSL(driver);
	page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void encerra() {
		driver.quit();
	}
	
	@Test
	public void DesafioCadastroCompleto() {
		page.setNome("Marcondes");
		page.setSobrenome("Santos");
		page.setSexoMasculino();
		page.setPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.cadastrar();
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Marcondes"));
		Assert.assertEquals("Sobrenome: Santos", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Futebol", page.obterEsportesCadastro());
	}
}
