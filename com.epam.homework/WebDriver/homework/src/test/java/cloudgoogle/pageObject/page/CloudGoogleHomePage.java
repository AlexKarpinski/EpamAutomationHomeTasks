package cloudgoogle.pageObject.page;

import cloudgoogle.waits.CustomConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CloudGoogleHomePage extends BasePage{

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchInputButton;

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement resultsPageButton;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 20)
                .until(CustomConditions.completedWait(driver));
        return this;
    }

    public CloudGoogleCalculatorPage searchResult(String text) {
        click(searchInputButton);
        searchInputButton.sendKeys(text);
        searchInputButton.sendKeys(Keys.ENTER);
        click(resultsPageButton);
        isLoadComplete();
        return new CloudGoogleCalculatorPage(driver);
    }
}