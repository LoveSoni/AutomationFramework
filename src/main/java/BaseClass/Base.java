package BaseClass;

import Library.*;
import Utils.EnvironmentParameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    private SessionManager sessionManager;
    private Driver driver;

    public Base() {
        if (EnvironmentParameters.getPlatformOS().equalsIgnoreCase("android")) {
            sessionManager = new AndroidSession();
        } else if (EnvironmentParameters.getPlatformOS().equalsIgnoreCase("iOS")) {
            sessionManager = new IosSession();
        } else {
            sessionManager = new WebSession();
        }
    }

    @BeforeMethod
    public void setUp(){
        if(sessionManager.getDriver().getWebDriver() == null){
            sessionManager.startAppiumSever();
        }
        sessionManager.initiateDriver();
    }

    @AfterMethod
    public void tearDown(){
        sessionManager.quitDriver();
    }

}
