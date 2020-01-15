package Library;

import BaseClass.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidSession extends SessionManager {
    private AppiumDriver appiumDriver;
    private Base base;
    private Driver driver;

    @Override
    public void initiateDriver(){
        appiumDriver = new AndroidDriver(this.getAppiumServerURL(),getAndroidCapabilities());
        driver = new Driver(appiumDriver);
    }

    @Override
    public void quitDriver() {
        appiumDriver.quit();
    }

    @Override
    public Driver getDriver(){
        return driver;
    }

    public DesiredCapabilities getAndroidCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"samsung");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"5200cb5a439c16a5");
        return desiredCapabilities;
    }


}
