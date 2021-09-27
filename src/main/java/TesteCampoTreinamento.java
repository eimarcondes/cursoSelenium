import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
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
	public void teste() {
		dsl.escrever("elementosForm:nome", "Teste de escrita");
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
	}

	@Test
	public void deveInteragirComTextArea() {
		dsl.escrever("elementosForm:sugestoes", "Teste de escrita dois");
		Assert.assertEquals("Teste de escrita dois", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void deveInteragirComRadioButtom(){
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
	}

	@Test
	public void deveInteragirComRadioButtom2() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:3"));
	}
	
	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "Doutorado");
		Assert.assertEquals("Doutorado", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		java.util.List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
			
		boolean encontrou = false;
		for(WebElement option: options ) {
			if(option.getText().equals("Doutorado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		java.util.List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
		
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao","O que eh esporte?")));
	}
	
	@Test
	public void deveInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test
	public void deveInteragirComLinks() {
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}
}