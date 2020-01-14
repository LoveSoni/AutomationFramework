package Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSession extends SessionManager {
    private WebDriver driver;
    @Override
    public void initiateDriver(){
        driver = new ChromeDriver();
    }
    public void quitDriver()
    {
        driver.quit();
    }
}
