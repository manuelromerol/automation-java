package org.sample.steps;

import org.openqa.selenium.WebDriver;
import org.sample.pages.HomePage;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
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
