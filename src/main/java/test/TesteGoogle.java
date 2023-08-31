package test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 765));
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void teste() {
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new InternetExplorerDriver();
//		"Torna o browser escalavel de altura e largura"
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 765));
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}
}
