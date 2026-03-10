package org.sample.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import org.sample.steps.HomeSteps;
import org.sample.utils.Constants;

public class HealthTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(description = "Verify Home Page is loading properly")
    public void verifyHomePageLoading() {
        HomeSteps homeSteps = new HomeSteps(driver);
        homeSteps.navigateToHomePage();
        String title = homeSteps.getPageTitle();
        Assert.assertTrue(title.contains(Constants.HOME_PAGE_TITLE),
                "The page title did not contain the expected value: " + Constants.HOME_PAGE_TITLE);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
