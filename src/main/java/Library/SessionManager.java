package Library;

import Constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.net.URL;
import java.util.logging.Logger;

/**
 * author Love
 */

public abstract class SessionManager {
    private AppiumDriverLocalService appiumDriverLocalService;
    private AppiumServiceBuilder appiumServiceBuilder;
    public abstract void quitDriver();

    public abstract void initiateDriver();

    public abstract Driver getDriver();

    public void startAppiumSever() {
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withIPAddress(Constants.APPIUM_DEFAULT_IP);
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();

    }

    public URL getAppiumServerURL() {
        return appiumDriverLocalService.getUrl();
    }

    public void stopAppiumServer() {
        appiumDriverLocalService.stop();
    }

}
