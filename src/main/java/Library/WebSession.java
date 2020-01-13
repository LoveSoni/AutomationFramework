package Library;

import org.openqa.selenium.WebDriver;

public class WebSession extends SessionManager {
    private WebDriver driver;
    @Override
    public void quitDriver()
    {
        driver.quit();
    }
}
