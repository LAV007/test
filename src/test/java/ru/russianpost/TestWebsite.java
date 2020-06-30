package ru.russianpost;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Класс предназначен для ..
 */
public class TestWebsite extends WebDriverSettings {

    /**
     *         1. Открыть страницу Гугл поиска (https://www.google.com) ---> Страница открыта
     *         2. В поисковике ввести яндекс маркет --> Проверить что первая страница в поиске ссылается на яндекс маркет
     *         3. Перейти по ссылке --> Откроется  яндекс маркет
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
     *         1. Открыть страницу яндекс маркет (https://market.yandex.ru/) ---> Страница открыта
     *         2. В поисковике ввести пылесосы --> произойдет переход на страницу с пылесосами
     *         3. Выполнить нажатие на кнопку Все фильтры --> Выбрать в списке Polaris и Vitek
     *         4. Установить  цену в поле  до = 6000 --> Проверить что появилось окно с отоброжаемым количеством товаров
     *         5. Нажать Показать подходящие --> происходит переход на страницу с товарами
     *         6. Проверить что данные из фильтра  отобразились в настройках с права --> см рис ниже
     */
    @Test
    public void secondTest() {
        //Открыть страницу яндекс маркет (https://market.yandex.ru/)
        driver.get("https://market.yandex.ru/");

        //Проверка соответствия title (Страница открыта)
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));

        //В поисковике ввести пылесосы
        WebElement search = driver.findElement(By.id("header-search"));
        search.sendKeys("пылесосы");
        //произойдет переход на страницу с пылесосами
        search.sendKeys(Keys.ENTER);
        //Кнопки ВСЕ ФИЛЬТРЫ на данном этапе нет, выбираю полностью всю категорию товаров пылесосы
        driver.findElement(By.className("_3nuwI0jgrK")).click();

        //Установить  цену в поле  до = 6000
        WebElement price = driver.findElement(By.id("glpriceto"));
        price.sendKeys("6000");
        price.sendKeys(Keys.ENTER);

        //Выполнить нажатие на кнопку Все фильтры
        WebElement allFilter = driver.findElement(By.id("search-prepack"));
        allFilter.findElement(By.className("_14Uuc5WvKg")).click();


    }
}
