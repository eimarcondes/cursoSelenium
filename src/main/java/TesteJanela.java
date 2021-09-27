import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteJanela {
	
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
	public void deveInteragirComJanela() {
		dsl.clicarBotao("buttonPopUPEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.sairFrame();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "E agora?");
	}
	
	@Test
	public void deveInteragirComJanelaSemTitulo() {
		dsl.clicarBotao("buttonPopUpHard");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.sairFrame();
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "E agora?");
	}
}