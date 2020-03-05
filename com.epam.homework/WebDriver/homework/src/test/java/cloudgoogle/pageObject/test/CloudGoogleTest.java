package cloudgoogle.pageObject.test;

import cloudgoogle.pageObject.page.CloudGoogleCalculatorPage;
import cloudgoogle.pageObject.page.CloudGoogleCalculatorResultsPage;
import cloudgoogle.pageObject.page.CloudGoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class CloudGoogleTest {

    private WebDriver driver;
    private CloudGoogleCalculatorPage cloudGoogleCalculatorPage;
    private CloudGoogleCalculatorResultsPage cloudGoogleCalculatorResultsPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        driver = new ChromeDriver();
        cloudGoogleCalculatorPage = new CloudGoogleHomePage(driver)
                .openPage()
                .searchResult("Google Cloud Platform Pricing Calculator");
        cloudGoogleCalculatorResultsPage = cloudGoogleCalculatorPage
                .createCalculatorResultsPageWithTerms();
    }

    @Test
    public void addEstimateWithVMClass() {
        assertTrue(cloudGoogleCalculatorResultsPage.getSearchResultValueOfVmClass().contains("regular"));
    }

    @Test
    public void addEstimateWithInstanceType() {
        assertTrue(cloudGoogleCalculatorResultsPage.getTextSearchResultValueOfInstanceType().contains("n1-standard-8"));
    }

    @Test
    public void addEstimateWithRegion() {
        assertTrue(cloudGoogleCalculatorResultsPage.getTextSearchResultValueOfRegion().contains("Frankfurt"));
    }

    @Test
    public void addEstimateWithLocalSSD() {
        assertTrue(cloudGoogleCalculatorResultsPage.getTextSearchResultValueOfLocalSSD().contains("2x375 GB"));
    }

    @Test
    public void addEstimateWithCommitmentTerm() {
        assertTrue(cloudGoogleCalculatorResultsPage.getTextSearchResultValueOfCommitmentTerm().contains("1 Year"));
    }

    @Test
    public void addEstimateWithCostMonth() {
        assertTrue(cloudGoogleCalculatorResultsPage.getTextSearchResultValueOfCostMonth().contains("1,082.77"));

    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}