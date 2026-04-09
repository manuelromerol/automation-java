package org.sample.steps;

import org.sample.pages.BookDetailsPage;
import org.sample.pages.PageManager;

public class BookDetailsSteps {
    private final BookDetailsPage bookDetailsPage;

    public BookDetailsSteps() {
        this.bookDetailsPage = PageManager.getPages().getBookDetailsPage();
    }

    public String getBookIsbn() {
        return bookDetailsPage.getISBN();
    }

    public void returnToBookStorePage() {
        bookDetailsPage.goBackToBookStorePage();
    }
}
