package org.makak.drivers;


import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.createDriver(DriverType.EDGE);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}