package com.epam.likhanova.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {

    private static final String WEBDRIVER_CHROMEDRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROMEDRIVER_EXE_PATH = ".\\browserdriver\\chromedriver\\chromedriver.exe";
    private static WebDriver driver;

    private DriverProvider() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(WEBDRIVER_CHROMEDRIVER, WEBDRIVER_CHROMEDRIVER_EXE_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
