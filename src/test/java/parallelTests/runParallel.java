package parallelTests;

import BaseClass.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class runParallel extends Base {
    @BeforeMethod
    public void setUp() {
        initDriver();
    }

    @Test
    public void login() {

    }

    @AfterMethod
    public void tearDown() {
        stopSession();
    }
}
