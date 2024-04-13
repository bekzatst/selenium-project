import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SearchProduct {
//
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, String> shops = new HashMap<>();

        driver.get("https://www.sulpak.kz/");
        WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Да")));
        element1.click();
        Thread.sleep(1000);
        WebElement searchSulpak = driver.findElement(By.id("evinent-search"));
        searchSulpak.sendKeys("Iphone 13 128Gb Midnight");
        searchSulpak.sendKeys(Keys.ENTER);
        WebElement price11 = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product__item-price")));
        js.executeScript("window.scrollBy(0, 500)");
        String price1 = price11.getText();
        shops.put("Sulpak", price1);
        Thread.sleep(5000);


        driver.get("https://www.mechta.kz");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='cursor-pointer']")));
        driver.findElement(By.cssSelector("div[class='cursor-pointer']")).click();
        Thread.sleep(2000);
        WebElement searchMechta = driver.findElement(By.cssSelector("input[class^='q-field__native']"));
        searchMechta.sendKeys("Iphone 13 128Gb Midnight");
        searchMechta.sendKeys(Keys.ENTER);
        WebElement price22 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".text-bold.text-ts5.text-color1")));
        String price2 = price22.getText();
        shops.put("Mechta", price2);
        Thread.sleep(5000);

        driver.get("https://kaspi.kz/");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 1000)");
        driver.findElement(By.cssSelector("a[href='https://kaspi.kz/shop/c/smartphones%20and%20gadgets/?source=kaspikz']")).click();
        WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dialog__close")));
        element3.click();
        Thread.sleep(1000);
        WebElement searchKaspi = driver.findElement(By.className("search-bar__input"));
        searchKaspi.sendKeys("Iphone 13 128Gb Midnight");
        searchKaspi.sendKeys(Keys.ENTER);
        WebElement price33 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='item-card__prices-price']")));
        String price3 = price33.getText();
        shops.put("Kaspi", price3);
        Thread.sleep(5000);


        driver.get("https://alser.kz/");
        WebElement element4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class^='green-text']")));
        element4.click();
        Thread.sleep(2000);
        WebElement searchAlser = driver.findElement(By.cssSelector("input[class^='header-main__input']"));
        searchAlser.sendKeys("Iphone 13 128Gb Midnight");
        searchAlser.sendKeys(Keys.ENTER);
        WebElement price44 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='digi-product-price-variant']")));
        String price4 = price44.getText();
        shops.put("Alser", price4);
        Thread.sleep(5000);

        driver.get("https://sanmi.kz/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class^='top-btn']")).click();
        Thread.sleep(1000);
        WebElement searchSanmi = driver.findElement(By.id("title-search-input"));
        searchSanmi.sendKeys("Iphone 13 128Gb черный");
        searchSanmi.sendKeys(Keys.ENTER);
        WebElement price55 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='price_value']")));
        js.executeScript("window.scrollBy(0, 100)");
        String price5 = price55.getText();
        shops.put("Sanmi", price5);
        Thread.sleep(5000);


        driver.get("https://www.dns-shop.kz/");
        WebElement searchDns = driver.findElement(By.name("q"));
        Thread.sleep(1000);
        searchDns.sendKeys("Iphone 13 128Gb черный");
        searchDns.sendKeys(Keys.ENTER);
        WebElement price66 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='product-buy__price']")));
        js.executeScript("window.scrollBy(0, 300)");
        String price6 = price66.getText();
        shops.put("DNS-shop", price6);
        Thread.sleep(5000);

        System.out.print(shops);

        driver.quit();

    }
}
