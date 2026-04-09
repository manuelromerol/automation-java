package org.sample.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.sample.utils.Constants;
import org.sample.utils.DriverManager;

public class HomePage extends BasePage {
    @FindBy(id = "searchBox")
    private WebElement searchBookInput;

    @FindBy(css = "table tbody > tr")
    private List<WebElement> booksItems;

    @FindBy(css = "table tbody > tr a")
    private List<WebElement> bookLinks;

    public HomePage() {
        super();
    }

    public HomePage navigateToHomePage() {
        DriverManager.getDriver().get(Constants.HOME_PAGE_URL);
        waitForPageToLoad();
        waitUntilElementIsVisible(searchBookInput);
        return this;
    }

    public String getPageTitle() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
        return DriverManager.getDriver().getTitle();
    }

    public HomePage searchBook(String term) {
        sendText(searchBookInput, term);
        return this;
    }

    public HomePage openFirstBook() {
        if (!bookLinks.isEmpty()) {
            waitAndClick(bookLinks.get(0));
        }
        return this;
    }

    public int getVisibleBookCount() {
        waitUntilAllElementsAreVisible(bookLinks);
        return (int) booksItems.stream()
                .filter(row -> !row.getText().trim().isEmpty())
                .count();
    }
}
