package org.sample.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    /**
     * Captures a screenshot and saves it to the target/screenshots folder.
     * @param driver The active WebDriver instance
     * @param testName The name of the test (used for the filename)
     * @return The absolute path of the saved screenshot
     */
    public static String capture(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String fileName = testName + "_" + timestamp + ".png";
        String destinationPath = System.getProperty("user.dir") + "/target/screenshots/" + fileName;
        File destination = new File(destinationPath);

        try {
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        return destinationPath;
    }
}