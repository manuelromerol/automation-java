package org.sample.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sample.pages.PageManager;
import org.sample.pages.PageObjectsCentral;
import org.sample.steps.StepManager;
import org.sample.steps.StepObjectsCentral;
import org.sample.utils.ConfigReader;
import org.sample.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Dynamically set headless mode based on the properties file
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        // 1. Initialize local driver
        WebDriver driverInstance = new ChromeDriver(options);

        // 2. Register Driver Manager in ThreadLocal Manager
        DriverManager.setDriver(driverInstance);

        // 3. Register Page Manager in ThreadLocal Manager
        PageManager.setPages(new PageObjectsCentral());

        // 4. Register Steps Manager in ThreadLocal Manager
        StepManager.setSteps(new StepObjectsCentral());

        if (isHeadless) {
            DriverManager.getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        } else {
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}