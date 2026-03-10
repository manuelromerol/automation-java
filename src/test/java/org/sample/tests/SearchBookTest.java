package org.sample.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import org.sample.steps.HomeSteps;
import org.sample.utils.Constants;
import org.sample.steps.BookDetailsSteps;

public class SearchBookTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(priority = 1, description = "Search a book")
    public void searchABook() {
        HomeSteps homeSteps = new HomeSteps(driver);
        homeSteps.navigateToHomePage();
        homeSteps.searchBook("Git");

        int bookCount = homeSteps.getNumberOfBooksDisplayed();
        Assert.assertTrue(bookCount > 0,
                "Search failed: No books were displayed for the term 'Git'.");
        System.out.println("Search successful. Found " + bookCount + " book(s).");
    }

    @Test(priority = 2, description = "Verify book ISBN")
    public void verifyBookIsbn() {
        HomeSteps homeSteps = new HomeSteps(driver);
        BookDetailsSteps bookSteps = new BookDetailsSteps(driver);

        // TODO: Comment following two lines when running in parallel
        homeSteps.navigateToHomePage();
        homeSteps.searchBook("Git");
        homeSteps.openFirstBookListed();

        String bookIsbn = bookSteps.getBookIsbn();
        Assert.assertEquals(bookIsbn, Constants.MAIN_ISBN,
                "The ISBN on the details page does not match the expected constant.");

        bookSteps.returnToBookStorePage();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
