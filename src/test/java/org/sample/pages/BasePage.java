package org.sample.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = d ->
                ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilAllElementsAreVisible(List<WebElement> element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void sendText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        element.clear();
        element.sendKeys(text);
    }
}
