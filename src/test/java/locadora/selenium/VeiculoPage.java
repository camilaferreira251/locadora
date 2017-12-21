/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.selenium;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author jhonatan
 */
public class VeiculoPage {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpTest() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8084/locadora/restrito/veiculo/formVeiculo.xhtml");
    }

    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest() {
//        driver.quit();
    }

    @Test
    public void testeCadastrar() {

        WebElement element;

        element = driver.findElement(By.name("placa"));
        element.sendKeys("Placa Teste");

        element = driver.findElement(By.name("modelo"));
        element.sendKeys("Modelo Teste");

        element = driver.findElement(By.name("marca"));
        element.sendKeys("Marca Teste");

        element = driver.findElement(By.name("cor"));
        element.sendKeys("Preto");

        element = driver.findElement(By.name("ano"));
        element.sendKeys("1999");

        element = driver.findElement(By.name("valorDiaria"));
        element.sendKeys("999");

        driver.findElement(By.id("formVeiculo:btnFrmVeicCanc")).click();
    }
}
