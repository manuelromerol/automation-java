package org.sample.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookDetailsPage extends BasePage{
    @FindBy(css = "div[id^='ISBN'] #userName-value")
    private WebElement isbnLabel;

    @FindBy(id = "addNewRecordButton")
    private WebElement backToBookStoreButton;

    public BookDetailsPage() {
        super();
    }

    public String getISBN() {
        return getText(isbnLabel);
    }

    public void goBackToBookStorePage() {
        waitAndClick(backToBookStoreButton);
    }
}
