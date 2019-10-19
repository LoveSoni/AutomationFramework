package BaseClass;

import Constants.Constants;
import Utils.PropertyReader;

import java.io.IOException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;
import org.omg.SendingContext.RunTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Base {
    public AppiumDriver appDriver;
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

    public void initDriver() {
        startSession();
        String configFilePath = System.getProperty("user.dir") + constants.slash + "src" + constants.slash + "main" + constants.slash + "resources" + File.separator + "config.properties";
        String capabilities = propertyReader.getValue("platformName", configFilePath);
        appDriver = new AndroidDriver(getAppiumURL(), clientCapabilities(capabilities));
    }

    public URL getAppiumURL() {
        return appiumDriverLocalService.getUrl();
    }

    public void stopSession() {
        appiumDriverLocalService.stop();
    }

    public DesiredCapabilities clientCapabilities(String typeCapabilities) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        if (typeCapabilities.equalsIgnoreCase("android")) {
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, constants.DEALER_APP_PATH);
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "");
        } else {
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        }
        return desiredCapabilities;
    }

    public void getConnetedDeviceList() {
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            logger.info("Output is :" + process.getInputStream().toString());
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Base base = new Base();
        base.getConnetedDeviceList();
    }
}
