package org.sample.pages;

public class PageObjectsCentral {
    private HomePage homePage;
    private BookDetailsPage bookDetailsPage;

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage() : homePage;
    }

    public BookDetailsPage getBookDetailsPage() {
        return (bookDetailsPage == null) ? bookDetailsPage = new BookDetailsPage() : bookDetailsPage;
    }
}
