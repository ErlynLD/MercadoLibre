package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import utils.PropertiesManager;

import java.io.IOException;
import java.time.Duration;

public class ResultsHook extends BasePage {

    @Before
    public void setupDriver() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(PropertiesManager.getProperty("implicitWait"))));
    }

    @After
    public void tearDown() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {

        }
    }
}
