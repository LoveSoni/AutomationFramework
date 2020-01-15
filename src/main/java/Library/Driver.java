package Library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

public class Driver {
    private AppiumDriver appiumDriver;

    private WebDriver webDriver;

    public Driver(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public Driver(AppiumDriver appiumDriver)
    {
        this.appiumDriver = appiumDriver;
    }

    public AppiumDriver getMobileDriver(){
        return appiumDriver;
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

}
