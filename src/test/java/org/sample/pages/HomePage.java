package org.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.sample.utils.Constants;

public class HomePage extends BasePage {
    @FindBy(id = "searchBox")
    private WebElement searchBookInput;

    @FindBy(css = "table tbody > tr")
    private List<WebElement> booksItems;

    @FindBy(css = "table tbody > tr a")
    private List<WebElement> bookLinks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get(Constants.HOME_PAGE_URL);
        waitForPageToLoad();
        waitUntilElementIsVisible(searchBookInput);
    }

    public String getPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
        return driver.getTitle();
    }

    public void searchBook(String term) {
        sendText(searchBookInput, term);
    }

    public void openFirstBook() {
        if (!bookLinks.isEmpty()) {
            waitAndClick(bookLinks.get(0));
        }
    }

    public int getVisibleBookCount() {
        waitUntilAllElementsAreVisible(bookLinks);
        return (int) booksItems.stream()
                .filter(row -> !row.getText().trim().isEmpty())
                .count();
    }
}
