package parallelTests;

import BaseClass.Base;
import Utils.AdbUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class runParallel extends Base {
    //private ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    //bootstrap number
//    runParallel()
//    {
//        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
//    }
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEXT']")
//    public MobileElement nextButton;

    @Parameters({"udid"})
    @BeforeMethod
    public void setUp(String udid) {
        initDriver(udid);
    }

    @Test
    synchronized public void login() throws IOException {
        AdbUtility adbUtility = new AdbUtility();
//        logger.info("Image path is :" + imagePath);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.DAYS.SECONDS);
//        driver.findElement(By.xpath("//android.widget.TextView[@text='NEXT']")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@text='NEXT']")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@text='GET STARTED']")).click();
//        MobileElement loginButton = (MobileElement) driver.findElementByImage(adbUtility.getReferenceImageB64(imagePath));
//        ((AndroidDriver) driver).setSetting(Setting.UPDATE_IMAGE_ELEMENT_POSITION, true);
//        loginButton.click();
//        driver.findElementByAccessibilityId("login_via_username_btn").click();
//        driver.findElementByAccessibilityId("enter_username").sendKeys("testdealer@cars24.com");
//        driver.findElementByAccessibilityId("enter_password").sendKeys("123456");
//        driver.findElementByAccessibilityId("login_btn").click();
    }

    @AfterMethod
    public void tearDown() {
        stopSession();
    }
}
