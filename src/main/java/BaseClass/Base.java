package BaseClass;

import Constants.Constants;
import Utils.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Base {
    public AppiumDriver appDriver;
    public WebDriver webDriver;
    public AppiumServiceBuilder appiumServiceBuilder;
    public AppiumDriverLocalService appiumDriverLocalService;
    public Constants constants;
    public PropertyReader propertyReader = new PropertyReader();

    public void startSession() {
        constants = new Constants();
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingAnyFreePort();
        ///Users/love/Documents/AutomationFramework/src/main/resources/config.properties
        String configFilePath = System.getProperty("user.dir") + constants.slash + "src" + constants.slash + "main" + constants.slash + "resources" + File.separator + "config.properties";
        String capabilities = propertyReader.getValue("platformName", configFilePath);
        appiumServiceBuilder.withCapabilities(clientCapabilities(capabilities));
        appiumServiceBuilder.withIPAddress("127.0.0.1");//TODO Remove hardcoded value
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
        appiumDriverLocalService = appiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
    }

    public void stopSession() {
        appiumDriverLocalService.stop();
    }

    public void serverCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    }

    public DesiredCapabilities clientCapabilities(String typeCapabilities) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if (typeCapabilities.equalsIgnoreCase("android")) {
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        } else {
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        }
        return desiredCapabilities;
    }

    public static void main(String args[]) {
        Base base = new Base();
        base.startSession();
    }
}
