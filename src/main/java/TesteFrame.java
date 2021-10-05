import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrame {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicia(){
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
	public void deveInteragirComFrame() {
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", msg);
		Assert.assertEquals("Frame OK!", msg);
		}
	
	@Test
	public void deveInteragirComFramEncondido() {
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
}
