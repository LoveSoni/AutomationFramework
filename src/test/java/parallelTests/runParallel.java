package parallelTests;

import BaseClass.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class runParallel extends Base {

    runParallel()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEXT']")
    public MobileElement nextButton;

    @Parameters({"udid"})
    @BeforeMethod
    public void setUp(String udid) {
        initDriver(udid);
    }

    @Test
   synchronized public void login() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.DAYS.SECONDS);
        nextButton.click();
        nextButton.click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='GET STARTED']")).click();
        driver.findElementByAccessibilityId("login_via_username_btn").click();
        driver.findElementByAccessibilityId("enter_username").sendKeys("testdealer@cars24.com");
        driver.findElementByAccessibilityId("enter_password").sendKeys("123456");
        driver.findElementByAccessibilityId("login_btn").click();
    }

    @AfterMethod
    public void tearDown() {
        stopSession();
    }
}
