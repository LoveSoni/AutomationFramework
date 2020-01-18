package Library;

import BaseClass.Base;
import Constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumLibrary extends Base {

    private AppiumDriver driver;

    public AppiumLibrary(){
       driver = super.driver.getMobileDriver();
    }

    public void waitForElement(MobileElement element) {
   //     new WebDriverWait(driver, constants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public void click(String element) {

    }

    public void enterText(MobileElement element, String text) {

    }
}
