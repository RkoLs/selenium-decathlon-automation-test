package decathlon.automation.executa;

import org.openqa.selenium.chrome.ChromeDriver;

import decathlon.automation.drivers.DriverFactory;

public class Executa extends DriverFactory {

	public static void inicarTeste() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.decathlon.com.br/");
	}

	public static void finalizarTeste() {
		driver.quit();
	}

	

}
