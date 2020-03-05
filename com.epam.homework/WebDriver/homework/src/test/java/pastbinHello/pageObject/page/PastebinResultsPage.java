package pastbinHello.pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PastebinResultsPage {

    private WebDriver driver;
    private String text;
    private String name;

    public PastebinResultsPage(WebDriver driver, String text, String name) {
        this.driver = driver;
        this.text = text;
        this.name = name;
        PageFactory.initElements(driver, this);
    }
}
