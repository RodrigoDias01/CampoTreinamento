package test;
import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.DSL;

public class TesteAlert {

	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	@After
	public void finaliza() {
		killDriver();

	}

	@Test
	public void deveIntjeragircomAlertSimples(){
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceito();
		Assert.assertEquals("Alert Simples", texto);
		
		dsl.escrever("Alert Simples", texto);
	}
	
	@Test
	public void deveIntjeragircomAlertConfirm(){		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceito());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceito());
		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENegado());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENegado());
	}
	
	@Test
	public void deveIntjeragircomAlertPrompt(){
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceito());
		Assert.assertEquals("Digite um numero", dsl.alertaObterTextoEAceito());
	}
}

