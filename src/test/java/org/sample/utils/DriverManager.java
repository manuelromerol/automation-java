package org.sample.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waitThread = new ThreadLocal<>();

    public static WebDriver getDriver() { return driverThread.get(); }

    public static WebDriverWait getWait() { return waitThread.get(); }

    public static void setDriver(WebDriver driver) {
        driverThread.set(driver);
        // Automatically initialize the wait when the driver is set
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
        waitThread.set(new WebDriverWait(driver, Duration.ofSeconds(timeout)));
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
            waitThread.remove();
        }
    }
}