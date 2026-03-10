package org.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample {
    private WebDriver driver;

//    options = webdriver.ChromeOptions()
//    options.binary_location = r"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"
//    chrome_driver_binary = r"C:/Users/Max/.wdm/chromedriver/75.0.3770.8/win32/chromedriver.exe"
//    driver = webdriver.Chrome(chrome_driver_binary, chrome_options=options)
//            driver.get('http://web.whatsapp.com')

    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        // Add your test steps here
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}