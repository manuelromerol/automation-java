package org.sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelDemo {

    WebDriver driver = null;

    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Test Execution 1" + Thread.currentThread().getId());
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("Test Execution 2" + Thread.currentThread().getId());
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("https://gmail.com");
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

