package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DriverUtils {

    static WebDriverWait webDriverWait;
    public static void waitForClickability(WebDriver driver, WebElement element) throws IOException {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(PropertiesManager.getProperty("implicitWait"))));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(WebDriver driver, WebElement element) throws IOException {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(PropertiesManager.getProperty("implicitWait"))));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
