package org.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookDetailsPage extends BasePage{
    @FindBy(css = "div[id^='ISBN'] #userName-value")
    private WebElement isbnLabel;

    @FindBy(id = "addNewRecordButton")
    private WebElement backToBookStoreButton;

    public BookDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getISBN() {
        return getText(isbnLabel);
    }

    public void goBackToBookStorePage() {
        waitAndClick(backToBookStoreButton);
    }
}
