import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class OlgaKorolenkoTest {

    //    TC_1_1  - Тест кейс:
    //    //1. Открыть страницу https://openweathermap.org/
    //    //2. Набрать в строке поиска город Paris
    //    //3. Нажать пункт меню Search
    //    //4. Из выпадающего списка выбрать Paris, FR
    //    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searthCityField = driver.findElement(
                By.xpath("//div[@id ='weather-widget']//input[@placeholder= 'Search city']"));
        searthCityField.click();
        searthCityField.sendKeys(cityName);
        Thread.sleep(5000);

        WebElement searthButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searthButton.click();
        Thread.sleep(1000);

        WebElement parisFRChouiceIdDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() ='Paris, FR ']")
        );
        parisFRChouiceIdDropdownMenu.click();
        Thread.sleep(5000);

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(3000);
        String actualResult = h2CityCountryHeader.getText();
        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();

    }
//                Шаблон
//    @Test
//
//    public void test_name(){
//        System.setProperty("webdriver.chrome.driver", "\u202AD:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        driver.quit();
//    }

//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой страницы
// OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testGuiderUrAndHeader() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResultUrl = "https://openweathermap.org/guide";

        driver.get(url);

        WebElement guideElementInMenu = driver.findElement(
                By.xpath("//a[@href ='/guide']")
        );

        Thread.sleep(5000);
        guideElementInMenu.click();

        String actualResultUrl = driver.getCurrentUrl();
        String actualResultTitle = driver.getTitle();

        Assert.assertEquals(actualResultUrl,expectedResultUrl);
        Assert.assertEquals(actualResultTitle,expectedResultTitle);

        driver.quit();
    }


}


