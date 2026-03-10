package org.sample.steps;

import org.openqa.selenium.WebDriver;
import org.sample.pages.BookDetailsPage;

public class BookDetailsSteps {
    private final BookDetailsPage bookDetailsPage;

    public BookDetailsSteps(WebDriver driver) {
        this.bookDetailsPage = new BookDetailsPage(driver);
    }

    public String getBookIsbn() {
        return bookDetailsPage.getISBN();
    }

    public void returnToBookStorePage() {
        bookDetailsPage.goBackToBookStorePage();
    }
}
