package BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
    public AppiumDriver appDriver;
    public WebDriver webDriver;

    public void startSession() {

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
