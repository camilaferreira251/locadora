/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.selenium;

import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author jhonatan
 */
public class AluguelPage {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpTest() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://localhost:8084/locadora/restrito/aluguel/visualizarVeiculos.xhtml");
    }

    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest() {
//        driver.quit();
    }

    @Test
    public void testeCadastrar() {

        WebElement element;

        List<WebElement> veiculos
                = driver.findElements(By.className("btnVisVeicAlug"));

        if (veiculos != null) {
            veiculos.get(0).click();
            
            element = driver.findElement(By.id("formAluguel:dateFrmAlugInic"));
            element.sendKeys("01/01/01");

            element = driver.findElement(By.id("formAluguel:dateFrmAlugFim"));
            element.sendKeys("03/01/01");

            driver.findElement(By.id("formAluguel:btnFrmAlugCanc")).click();
        }
    }
}
