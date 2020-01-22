package Library;

import BaseClass.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;

public class AppiumLibrary extends Base {

    private AppiumDriver driver;
    private LocatorsUtil locatorsUtil;

    public AppiumLibrary() {
        driver = super.driver.getMobileDriver();
        locatorsUtil = new LocatorsUtil();
    }

    public void click(String locator) {
        if (isElementPresent(locator, 10)) {
            getElement(locator).click();
        }
    }

    public void enterText(String locator, String text) {
        if (isElementPresent(locator, 10)) {
            click(locator);
            getElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(String locator, int time) {
        boolean isPresent = false;
        try {
            waitForElement(locator, time);
            isPresent = true;
        }catch (TimeoutException exception)
        {
            //log exception here
        }
        return isPresent;
    }

    public void waitForElement(String locator, int time) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, time);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locatorsUtil.getElement(locator)));
    }

    public MobileElement getElement(String locator) {
        return (MobileElement) driver.findElement(locatorsUtil.getElement(locator));
    }


}
