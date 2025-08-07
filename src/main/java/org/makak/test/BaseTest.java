package org.makak.test;

import io.qameta.allure.Attachment;
import org.makak.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Test başarısız olduğunda ekran görüntüsü al
            saveScreenshot(driver);
        }
        DriverManager.quitDriver();
    }

    @Attachment(value = "Ekran Görüntüsü", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        // TakesScreenshot arayüzünü kullanarak ekran görüntüsünü al
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
