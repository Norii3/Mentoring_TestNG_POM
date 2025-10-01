package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DPSearchPageParallelTesting;
import utilities.Driver;

import java.time.Duration;

public class F17T02_DataProviderParallel {
    /*
    Task 2: Data Provider Parallel Execution
    Objective:
    Implement a data-driven test that runs search functionality with multiple search terms inparallel.
    Requirements:
    Create a data provider with at least 5 different search terms
    Enable parallel execution for the data provider
    Create a test method that accepts search terms and validates results
    Configure XML file with data-provider-thread-count of 2
    Expected Output:
    Each search term should be tested simultaneously in separate threads.
     */

    @Test(dataProvider = "searchTerms")
    void dPParallelTest(String searchTerm){

        DPSearchPageParallelTesting searchPage = new DPSearchPageParallelTesting();

        Driver.getDriver().get("https://www.bing.com");
        searchPage
                .clickSearchBox()
                .enterSearchTerms(searchTerm)
                .assertSearchResult();

        Driver.closeDriver();

    }

    @DataProvider(name = "searchTerms", parallel = true)
    public Object[][] dPSearchTerms(){
        return new Object[][]{
                {"hello"},
                {"book"},
                {"water"},
                {"moon"},
                {"tree"}
        };
    }
}
