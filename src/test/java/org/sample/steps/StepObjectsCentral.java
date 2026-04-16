package org.sample.steps;

public class StepObjectsCentral {
    private HomeSteps homeSteps;
    private BookDetailsSteps bookDetailsSteps;

    public HomeSteps getHomeSteps() {
        return (homeSteps == null) ? homeSteps = new HomeSteps() : homeSteps;
    }

    public BookDetailsSteps getBookDetailsSteps() {
        return (bookDetailsSteps == null) ? bookDetailsSteps = new BookDetailsSteps() : bookDetailsSteps;
    }
}
