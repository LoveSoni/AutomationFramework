package BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
    public AppiumDriver driver;
    public DesiredCapabilities desiredCapabilities;

    public void createSession() {

    }

    public void serverCapabilities() {

    }

    public void androidCapabilities() {
        desiredCapabilities = new DesiredCapabilities();
    }

    public void iosCapabilities() {
        desiredCapabilities = new DesiredCapabilities();
    }
}
