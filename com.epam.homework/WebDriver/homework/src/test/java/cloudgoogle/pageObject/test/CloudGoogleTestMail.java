package cloudgoogle.pageObject.test;

import cloudgoogle.pageObject.page.CloudGoogleCalculatorPage;
import cloudgoogle.pageObject.page.CloudGoogleCalculatorResultsPage;
import cloudgoogle.pageObject.page.CloudGoogleHomePage;
import cloudgoogle.pageObject.page.MailHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CloudGoogleTestMail {

    private WebDriver driver;
    private CloudGoogleCalculatorPage cloudGoogleCalculatorPage;
    private CloudGoogleCalculatorResultsPage cloudGoogleCalculatorResultsPage;
    private MailHomePage mailHomePage;
    private String mailAddress;
    private String costValueFromGoogleCalculator;
    private String costValueFromMailMessage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        driver = new ChromeDriver();
        cloudGoogleCalculatorPage = new CloudGoogleHomePage(driver)
                .openPage()
                .searchResult("Google Cloud Platform Pricing Calculator");
        cloudGoogleCalculatorResultsPage = cloudGoogleCalculatorPage
                .createCalculatorResultsPageWithTerms();
        costValueFromGoogleCalculator = cloudGoogleCalculatorResultsPage.getTextSearchResultValueOfCostMonth();
        mailHomePage = cloudGoogleCalculatorResultsPage.openPageMailHomePageInNewTab(driver);
        mailAddress = mailHomePage.copyMailAddress();
        mailHomePage.goToTub(0);
        cloudGoogleCalculatorResultsPage.sendEmail(mailAddress);
        cloudGoogleCalculatorResultsPage.goToTub(1);
        costValueFromMailMessage = mailHomePage.getCostFromMessage();
    }

    @Test
    public void costMonthEqualsCostMonthFromMailMessage() {
        assertTrue(costValueFromGoogleCalculator.contains(costValueFromMailMessage));
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}