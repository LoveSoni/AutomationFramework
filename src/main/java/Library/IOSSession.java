package Library;

import io.appium.java_client.AppiumDriver;

public class IOSSession extends SessionManager {
    private AppiumDriver driver;

    @Override
    public void quitDriver() {
        driver.quit();
    }
}
