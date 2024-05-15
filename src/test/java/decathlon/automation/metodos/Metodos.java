package decathlon.automation.metodos;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import decathlon.automation.drivers.DriverFactory;

public class Metodos extends DriverFactory {
    private static final String SCREENSHOTS_DIR = "evidencias.teste/";

    public static void captureScreenshot(String screenshotName) {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void esperarEClicar(By locator, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(locator));
        elemento.click();
    }

    public static void clicar(By elemento) {
        esperarEClicar(elemento, 10);
    }

    public static void preencherCampo(By elemento, String texto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.elementToBeClickable(elemento));
        campo.clear();
        campo.sendKeys(texto);
    }

    public static void pressionarEnter(By elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.elementToBeClickable(elemento));
        campo.sendKeys(Keys.ENTER);
    }

    public static String capturarTexto(By elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.elementToBeClickable(elemento));
        String texto = campo.getText();
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
        pressionarEnter(By.xpath("//input[@placeholder='Pesquise por um produto ou esporte']"));
    }

    public static void selecionarProduto() {
        clicar(By.xpath(
                "//img[@data-src='https://decathlonstore.vtexassets.com/unsafe/302x302/center/middle/"
                + "https%3A%2F%2Fdecathlonpro.vtexassets.com%2Farquivos%2Fids%2F65808190%2F-tn-adidas-boston-12-m-az-uk-11---eu-46-39-br1.jpg"
                + "%3Fv%3D638328182983300000']"));
        captureScreenshot("selecionarProduto");
    }

    public static void selecionarTamanho() {
        captureScreenshot("selecionarTamanho");
        clicar(By.xpath("//button[normalize-space()='44 BR']"));
        captureScreenshot("selecionarTamanho");
    }

    public static void adicionarAoCarrinho() {
        clicar(By.xpath("//button[normalize-space()='Adicionar ao carrinho']"));
    }

    public static void preencherCEP() {
        clicar(By.xpath("//input[@id='inputCep']"));
        preencherCampo(By.xpath("//input[@id='inputCep']"), "69403-586");
        captureScreenshot("preencherCEP");
        clicar(By.xpath("//button[normalize-space()='Consultar frete']"));
    }

    public static void consultarCarrinho() {
        By carrinhoButton = By.xpath("//*[@id='BagCartOutline']/ancestor::button");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 0; i < 3; i++) {
            clicar(carrinhoButton);
            wait.until(ExpectedConditions.visibilityOfElementLocated(carrinhoButton));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='FINALIZAR COMPRA']")));
        captureScreenshot("consultarCarrinho");
    }
}
