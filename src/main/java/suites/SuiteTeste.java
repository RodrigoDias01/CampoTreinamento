package suites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.AfterClass;

import core.DriverFactory;
import test.TesteAlert;
import test.TesteCadastro;
import test.TesteCampoTreinamento;
import test.TesteFramesEJanelas;
import test.TesteGoogle;
import test.TesteRegrasCadastro;
import test.TesteSincronismo;


@RunWith(Suite.class)
@SuiteClasses({
	TesteAlert.class,
	TesteCadastro.class,
	TesteCampoTreinamento.class,
	TesteFramesEJanelas.class,
	TesteGoogle.class,
	TesteRegrasCadastro.class,
	TesteSincronismo.class
	
})
public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
	
}
	