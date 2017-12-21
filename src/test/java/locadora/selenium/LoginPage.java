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
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author jhonatan
 */
public class LoginPage {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpTest() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//        driver = new ChromeDriver();
        driver.get("http://localhost:8084/locadora/");
    }

    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest() {
//        driver.quit();
    }

    // Testa título "Locadora".
    @Test
    public void testeTituloDaPagina() {
        assertEquals("Locadora", driver.getTitle());
    }

    @Test
    public void testeLogin() {

        WebElement element;

        element = driver.findElement(By.id("j_username"));

        element.sendKeys("jhon");

        element = driver.findElement(By.id("j_password"));

        element.sendKeys("123");

        driver.findElement(By.id("btnLogar")).click();
    }

}
