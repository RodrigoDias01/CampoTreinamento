package test;
import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest  {
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Rodrigo");
		page.setSobrenome("Dias");
		page.setSexoMasculino();
		page.setComidaFrango();
		page.setEscolaridade("Superior");
		page.setEsportes("Karate");
		page.cadastrar();
		
		//Este assert verifica se é verdadeiro que o resultado inicia com Cadastrado
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Rodrigo", page.obterNomeCadastro());
		Assert.assertEquals("Dias", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Frango", page.obterSexoComidaCadastro());
		Assert.assertEquals("superior", page.obterEscolaridadeCadstro());
		Assert.assertEquals("Karate", page.obterEsporteCadstro());
	}
}
