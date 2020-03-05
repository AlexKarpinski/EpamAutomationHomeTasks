package pastbinTest.pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pastbinHello.waits.CustomConditions;

public class PastebinResultsPage {

    private WebDriver driver;
    private String text;
    private String name;
    private static String resultsPage_URL;

    public PastebinResultsPage(WebDriver driver, String text, String name) {
        this.driver = driver;
        this.text = text;
        this.name = name;
        PageFactory.initElements(driver, this);
    }

    public PastebinResultsPage openPage() {
        driver.get(resultsPage_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
}


