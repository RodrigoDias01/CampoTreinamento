package test;
import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.DSL;

public class TestePrimeFaces {
	
	private DSL dsl;

	
	@Before
	public void inicializa() {
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
		
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt344:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt344:console:0"));
		
		dsl.clicarRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt344:console:1"));	
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt343:option", "Option2");		
		Assert.assertEquals("Option2", dsl.obterTexto("j_idt343:option_label"));	
	}
}
