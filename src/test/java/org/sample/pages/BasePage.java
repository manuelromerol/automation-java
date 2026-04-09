package org.sample.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sample.utils.DriverManager;

import java.util.List;

public abstract class BasePage {
    protected WebDriverWait wait;

    public BasePage() {
        this.wait = DriverManager.getWait();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = d ->
                ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
        this.wait.until(pageLoadCondition);
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilAllElementsAreVisible(List<WebElement> element) {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void waitAndClick(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected String getText(WebElement element) {
        return this.wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void sendText(WebElement element, String text) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        this.wait.until(ExpectedConditions.elementToBeClickable(element));

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        element.clear();
        element.sendKeys(text);
    }
}
