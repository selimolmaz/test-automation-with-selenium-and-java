package org.makak.drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(DriverType type) {
        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/java/org/makak/drivers/drivers_src/chromedriver.exe");
                return new ChromeDriver();

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/java/org/makak/drivers/drivers_src/geckodriver.exe");
                return new FirefoxDriver();

            case EDGE:
                System.setProperty("webdriver.edge.driver", "src/main/java/org/makak/drivers/drivers_src/msedgedriver.exe");
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException("Unsupported driver type: " + type);
        }
    }
}
