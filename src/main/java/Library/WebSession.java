package Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * author Love
 */

public class WebSession extends SessionManager {
    private WebDriver webDriver;
    private Driver driver;

    @Override
    public void initiateDriver(){
        WebDriverManager.chromedriver().setup();;
        webDriver = new ChromeDriver();
        driver = new Driver(webDriver);
    }

    @Override
    public Driver getDriver(){
        return driver;
    }

    public void quitDriver(){
        webDriver.quit();
    }
}
