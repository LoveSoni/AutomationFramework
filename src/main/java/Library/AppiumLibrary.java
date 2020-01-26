package Library;

import BaseClass.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * author Love
 */

public class AppiumLibrary extends Base {

    private AppiumDriver driver;
    private LocatorsUtil locatorsUtil;
    private Logger logger = Logger.getLogger(AppiumLibrary.class);

    public AppiumLibrary() {
        driver = super.driver.getMobileDriver();
        locatorsUtil = new LocatorsUtil();
    }

    public void clickIfPresent(String locator) {
        if (isElementPresent(locator, 10)) {
            getElement(locator).click();
        }
    }

    public void click(String locator)
    {
        isElementPresent(locator,10);
        getElement(locator).click();
    }

    public boolean isElementPresent(String locator)
    {
        boolean isPresent = false;
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        try{
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locatorsUtil.getElement(locator)));
            isPresent = true;
        }catch (TimeoutException e)
        {
           logger.error(e.getMessage());
        }
        return isPresent;
    }

    public String getText(String locator)
    {
        return getElement(locator).getText();
    }

    public void closeKeyboard()
    {
        driver.hideKeyboard();
    }

    public void pressBack()
    {
        driver.navigate().back();
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
            logger.error(exception.getMessage());
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
