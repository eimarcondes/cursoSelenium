import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteJanela.class,
	TesteCampoTreinamento.class,
	DesafioCadastro.class,
	DesafioRegrasNegocio.class,
	TesteAlert.class,
	TesteRegrasCadastro.class,
	TesteFrame.class
	})
public class SuiteTeste {

}
