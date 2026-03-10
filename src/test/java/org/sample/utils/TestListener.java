package org.sample.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.sample.tests.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("------- TEST FAILED: " + result.getName() + " -------");
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        if (driver != null) {
            ScreenshotUtils.capture(driver, result.getName());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Suite: " + context.getName());
    }
}