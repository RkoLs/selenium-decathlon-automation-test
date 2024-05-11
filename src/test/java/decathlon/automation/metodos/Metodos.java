package decathlon.automation.metodos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import decathlon.automation.drivers.DriverFactory;

public class Metodos extends DriverFactory {
	private static final String SCREENSHOTS_DIR = "evidencias.teste/";

	public static void captureScreenshot(String screenshotName) {
	    WebDriver driver = DriverFactory.driver;
	    if (driver instanceof TakesScreenshot) {
	        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
	        File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR + screenshotName + ".png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static void clicar(By elemento) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(elemento).click();
	}

	public static void preencherCampo(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public static void pressionarEnter(By elemento) {
		driver.findElement(elemento).sendKeys(Keys.ENTER);
	}

	public static String capturarTexto(By elemento) {
		String texto = driver.findElement(elemento).getText();
		captureScreenshot("capturarTexto_" + elemento.toString().replaceAll("[^a-zA-Z0-9]", ""));
		return texto;
	}

	public static void aceitarCookies() {
		clicar(By.xpath("//button[normalize-space()='Aceitar']"));
	}

	public static void pesquisarProduto() {
		clicar(By.xpath("//input[@placeholder='Pesquise por um produto ou esporte']"));
		preencherCampo(By.xpath("//input[@placeholder='Pesquise por um produto ou esporte']"),
				"tenis corrida adidas adizero 12");
		captureScreenshot("pesquisarProduto");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pressionarEnter(By.xpath("//input[@placeholder='Pesquise por um produto ou esporte']"));

	}

	public static void selecionarProduto() {
		clicar(By.xpath(
				"//img[@data-src='https://decathlonstore.vtexassets.com/unsafe/302x302/center/middle/https%3A%2F%2Fdecathlonpro.vtexassets.com%2Farquivos%2Fids%2F65808190%2F-tn-adidas-boston-12-m-az-uk-11---eu-46-39-br1.jpg%3Fv%3D638328182983300000']"));
		captureScreenshot("selecionarProduto");
	}

	public static void selecionarTamanho() {
		captureScreenshot("selecionarTamanho");
		clicar(By.xpath("//button[normalize-space()='44 BR']"));
		captureScreenshot("selecionarTamanho");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void adicionarAoCarrinho() {
		clicar(By.xpath("//button[normalize-space()='Adicionar ao carrinho']"));
	}

	public static void preencherCEP() {
		clicar(By.xpath("//input[@id='inputCep']"));
		preencherCampo(By.xpath("//input[@id='inputCep']"), "69403-586");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		captureScreenshot("preencherCEP");
		clicar(By.xpath("//button[normalize-space()='Consultar frete']"));
	}

	public static void consultarCarrinho() {
		clicar(By.xpath("//*[@id='BagCartOutline']/ancestor::button"));
		try {
			Thread.sleep(1000);//
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clicar(By.xpath("//*[@id='BagCartOutline']/ancestor::button"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clicar(By.xpath("//*[@id='BagCartOutline']/ancestor::button"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		captureScreenshot("consultarCarrinho");
	}

}