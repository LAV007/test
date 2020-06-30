package ru.russianpost;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Класс предназначен для ...
 */
public class WebDriverSettings {

    protected ChromeDriver driver;

    @Before
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects3\\untitled\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void close() {
        //driver.quit(); //закрытие браузера
    }
}
