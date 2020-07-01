package ru.russianpost;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Класс предназначен для тестирования вебсайтов
 */
public class TestWebsite extends WebDriverSettings {

    /**
     * Метод проверяте открытие сайта google.com и ввод в поле поиска
     */
    @Test
    public void firstTest() {
        //Открыть страницу Гугл поиска (https://www.google.com)
        driver.get("https://google.com/");

        //Проверка соответствия title (Страница открыта)
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Google"));

        //В поисковике ввести яндекс маркет
        driver.findElement(By.name("q")).sendKeys("яндекс маркет");
        driver.findElement(By.name("btnK")).click();

        //Проверить что первая страница в поиске ссылается на яндекс маркет
        String yandexMarket = driver.findElement(By.cssSelector("cite")).getText();
        Assert.assertTrue(yandexMarket.equals("market.yandex.ru"));

        //Перейти по ссылке --> Откроется  яндекс маркет
        driver.get("https://" + yandexMarket + "/");
    }

    /**
     *  Метод проверяет радоту Яндекс.Маркет
     */
    @Test
    public void secondTest() {
        //Открыть страницу яндекс маркет (https://market.yandex.ru/)
        driver.get("https://market.yandex.ru/");

        //Проверка соответствия title (Страница открыта)
        Assert.assertEquals(driver.getTitle(), "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов");

        //В поисковике ввести пылесосы
        WebElement search = driver.findElement(By.id("header-search"));
        search.clear();
        search.sendKeys("пылесосы");
        //произойдет переход на страницу с пылесосами
        search.sendKeys(Keys.ENTER); //очищием поле перед записью
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ждем загрузки странички

        //Установить  цену в поле  до = 6000
        WebElement price = driver.findElement(By.id("glpriceto"));
        price.clear();
        price.sendKeys("6000");
        price.sendKeys(Keys.ENTER);

        //ждем загрузки странички
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-prepack")));

        //Select vacuumCleaner
        driver.findElement(By.cssSelector("[href=\"/catalog--pylesosy/83796/list?onstock=0&local-offers-first=0&priceto=6000&hid=16302535&text=%D0%BF%D1%8B%D0%BB%D0%B5%D1%81%D0%BE%D1%81%D1%8B&cvredirect=3&track=srch_ddl\"]")).click();

        //Open all
        driver.findElement(By.cssSelector("[href=\"/catalog--pylesosy/83796/filters?onstock=0&local-offers-first=0&priceto=6000&hid=16302535&text=%D0%BF%D1%8B%D0%BB%D0%B5%D1%81%D0%BE%D1%81%D1%8B\"]")).click();

        //Выбрать в списке Vitek
        driver.findElement(By.cssSelector("[for=\"glf-7893318-152837\"]")).click();

        //Нажать Показать подходящие
        driver.findElement(By.cssSelector("[href=\"/catalog--pylesosy/83796/list?hid=16302535&text=%D0%BF%D1%8B%D0%BB%D0%B5%D1%81%D0%BE%D1%81%D1%8B&glfilter=7893318%3A152837&onstock=0&local-offers-first=0&priceto=6000\"]")).click();

        //Проверка соответствия цены в поле до
        //Assert.assertEquals(driver.findElement(By.id("glpriceto")).getText(), "6000");
    }
}
