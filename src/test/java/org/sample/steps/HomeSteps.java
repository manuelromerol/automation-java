package org.sample.steps;

import org.sample.pages.HomePage;
import org.sample.pages.PageManager;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps() {
        this.homePage = PageManager.getPages().getHomePage();
    }

    public HomeSteps navigateToHomePage() {
        homePage.navigateToHomePage();
        return this;
    }

    public String getPageTitle() {
        String title = homePage.getPageTitle();
        System.out.println("Title: " + title);
        return title;
    }

    public HomeSteps searchBook(String term) {
        homePage.searchBook(term);
        return this;
    }

    public HomeSteps openFirstBookListed() {
        homePage.openFirstBook();
        return this;
    }

    public int getNumberOfBooksDisplayed() {
        return homePage.getVisibleBookCount();
    }
}
