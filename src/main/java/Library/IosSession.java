package Library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IosSession extends SessionManager {
    private AppiumDriver driver;

    @Override
    public void initiateDriver(){
        driver = new IOSDriver(getIOSCapabilities());
    }
    @Override
    public void quitDriver() {
        driver.quit();
    }

    public DesiredCapabilities getIOSCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        return desiredCapabilities;
    }
}





