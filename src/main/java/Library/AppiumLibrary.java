package Library;

import BaseClass.Base;
import Constants.Constants;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumLibrary extends Base {
    public Constants constants = new Constants();

    public void waitForElement(MobileElement element) {
        new WebDriverWait(driver, constants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public void click(MobileElement element) {

    }

    public void enterText(MobileElement element, String text) {

    }
}
