import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
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
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][]{
			{"","","", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
			{"Marcondes","","", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
			{"Marcondes","Santos","", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
			{"Marcondes","Santos","Masculino", Arrays.asList("Carne", "Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?"},
			{"Marcondes","Santos","Masculino", Arrays.asList("Carne"), new String[] {"Futebol", "O que eh esporte?"}, "Voce faz esporte ou nao?"},
		});
	}
	
	@Test
	public void deveValidarCadastro() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);
		if(sexo.equals("Masculino")) {
			page.setSexoMasculino();
		}
		if(sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if(comidas.contains("Carne")) page.setCarne();
		if(comidas.contains("Pizza")) page.setPizza();
		if(comidas.contains("Vegetariano")) page.setVegetariano();
		page.setEsporte(esportes);
		page.cadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
}