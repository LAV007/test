package ru.russianpost;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Класс предназначен для инициализации драйвера
 */
public class WebDriverSettings {

    protected ChromeDriver driver;

    @Before
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //указываю размер для окна браузера
        driver.manage().window().setSize(new Dimension(800, 600));
    }

    @After
    public void close() {
        driver.quit(); //закрытие браузера
    }
}
