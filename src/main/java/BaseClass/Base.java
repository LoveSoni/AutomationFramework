package BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
    public AppiumDriver appDriver;
    public WebDriver webDriver;
    public AppiumServiceBuilder appiumServiceBuilder;
    public AppiumDriverLocalService appiumDriverLocalService;

    public void startSession() {
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,"info");
    }

    public void serverCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    }

    public void androidCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
    }

    public void iosCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
    }
}
