package org.sample.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.sample.steps.HomeSteps;
import org.sample.utils.Constants;

public class HealthTest extends BaseTest {

    @Test(description = "Verify Home Page is loading properly")
    public void verifyHomePageLoading() {
        HomeSteps homeSteps = new HomeSteps();
        homeSteps.navigateToHomePage();
        String title = homeSteps.getPageTitle();
        Assert.assertTrue(title.contains(Constants.HOME_PAGE_TITLE),
                "The page title did not contain the expected value: " + Constants.HOME_PAGE_TITLE);
    }

}
