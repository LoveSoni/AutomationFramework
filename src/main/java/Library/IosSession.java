package Library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IosSession extends SessionManager {
    private AppiumDriver driver;

    @Override
    public void initiateDriver(){
        driver = new IOSDriver(this.getAppiumServerURL(),getIOSCapabilities());
    }
    @Override
    public void quitDriver() {
        driver.quit();
    }

    public DesiredCapabilities getIOSCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"135bc7eea69bb01a6639c83db105061df7c7853a");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.4.1");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iphone6s");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        return desiredCapabilities;
    }
}





