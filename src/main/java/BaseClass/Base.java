package BaseClass;

import Constants.Constants;
import Utils.PropertyReader;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Base {
    public AppiumDriver driver;
    public WebDriver webDriver;
    public Logger logger = Logger.getLogger(Base.class);
    public AppiumServiceBuilder appiumServiceBuilder;
    public AppiumDriverLocalService appiumDriverLocalService;
    public Constants constants = new Constants();
    public PropertyReader propertyReader = new PropertyReader();

    public void startSession() {
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withIPAddress(constants.APPIUM_DEFAULT_IP);
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
        appiumDriverLocalService = appiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
    }

    public void initDriver(String udid) {
        startSession();
        String configFilePath = System.getProperty("user.dir") + constants.slash + "src" + constants.slash + "main" + constants.slash + "resources" + File.separator + "config.properties";
        String capabilities = propertyReader.getValue("platformName", configFilePath);
        driver = new AndroidDriver(getAppiumURL(), clientCapabilities(capabilities, udid));
    }

    public URL getAppiumURL() {
        return appiumDriverLocalService.getUrl();
    }

    public void stopSession() {
        appiumDriverLocalService.stop();
    }

    public DesiredCapabilities clientCapabilities(String typeCapabilities, String udid) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        logger.info("Tests running on udid " + udid);
        if (typeCapabilities.equalsIgnoreCase("android")) {
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, constants.DEALER_APP_PATH);
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        } else {
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        }
        return desiredCapabilities;
    }
}
