package test.proj;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	
	String url;
	WebDriver driver;
	
	@Before
	public void iniciar() {
		url = "https://www.expresso.pe.gov.br/login.php";
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\alan_\\eclipse-workspace\\test.proj\\drivers\\chrome\\90\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void consultar() {
		
		driver.get(url);
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("user")).sendKeys(Keys.chord("Admin"));
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys(Keys.chord("Admin"));
		
		driver.findElement(By.className("button")).click();
		
		String esperado = "Bad login or password*";
		assertEquals(esperado, driver.findElement(By.xpath("//*[@id=\"mensagem\"]/font")).getText());
				
	}
	
	@After
	public void finalizar() {
		driver.quit();	
		
	}
	

	

}
