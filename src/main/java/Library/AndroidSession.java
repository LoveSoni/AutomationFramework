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
    private AppiumDriver driver;
    private Base base;

    @Override
    public void initiateDriver(){
        driver = new AndroidDriver(this.getAppiumServerURL(),getAndroidCapabilities());
    }

    @Override
    public void quitDriver() {
        driver.quit();
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
