package BaseClass;

import Constants.Constants;
import Utils.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base{
    public AppiumDriver appDriver;
    public WebDriver webDriver;
    public AppiumServiceBuilder appiumServiceBuilder;
    public AppiumDriverLocalService appiumDriverLocalService;
    public Constants constants;
    public PropertyReader propertyReader;

    public void startSession() {
        propertyReader = new PropertyReader();
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,"info");
        appiumDriverLocalService = appiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
    }

    public void stopSession(){
        appiumDriverLocalService.stop();
    }

    public void serverCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    }

    public DesiredCapabilities androidCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        return desiredCapabilities;
    }

    public DesiredCapabilities iosCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        return desiredCapabilities;
    }

    public static void main(String args[])
    {

    }
}
