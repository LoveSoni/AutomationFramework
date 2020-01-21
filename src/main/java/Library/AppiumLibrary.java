package Library;

import BaseClass.Base;
import Constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumLibrary extends Base {

    private AppiumDriver driver;
    private LocatorsUtil locatorsUtil;

    public AppiumLibrary(){
       driver = super.driver.getMobileDriver();
       locatorsUtil = new LocatorsUtil();
    }

    public void waitForElement(MobileElement element) {
         new WebDriverWait(driver, Constants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public void click(String locator) {
        getElement(locator).click();
    }

    public void enterText(String locator, String text) {
        click(locator);
        getElement(locator).sendKeys(text);
    }

    public MobileElement getElement(String locator)
    {
        return (MobileElement) driver.findElement(locatorsUtil.getElement(locator));
    }
}
