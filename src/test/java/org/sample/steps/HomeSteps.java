package org.sample.steps;

import org.sample.pages.HomePage;
import org.sample.pages.PageManager;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps() {
        this.homePage = PageManager.getPages().getHomePage();
    }

    public void navigateToHomePage() {
        homePage.navigateToHomePage();
    }

    public String getPageTitle() {
        String title = homePage.getPageTitle();
        System.out.println("Title: " + title);
        return title;
    }

    public void searchBook(String term) {
        homePage.searchBook(term);
    }

    public void openFirstBookListed() {
        homePage.openFirstBook();
    }

    public int getNumberOfBooksDisplayed() {
        return homePage.getVisibleBookCount();
    }
}
