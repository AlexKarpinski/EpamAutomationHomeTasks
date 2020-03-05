package pastbinTest.pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pastbinTest.waits.CustomConditions;

public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    @FindBy(id = "paste_code")
    private WebElement searchInputNewPaste;

    @FindBy(xpath = "//*[@id='myform']/descendant-or-self::b[@role='presentation'][2]")
    private WebElement searchInputPasteExpirationMenu;

    @FindBy(xpath = "//*[@class='select2-results__option'][text() = '10 Minutes']")
    private WebElement searchInputPasteExpiration;

    @FindBy(name = "paste_name")
    private WebElement searchInputPasteName;

    @FindBy(xpath = "//*[@id='myform']/descendant-or-self::b[@role='presentation'][1]")
    private WebElement searchInputSyntaxHighlightingMenu;

    @FindBy(xpath = "//*[@class='select2-results__option'][text()='Bash'][@aria-selected='false']")
    private WebElement searchInputSyntaxHighlighting;

    @FindBy(id = "submit")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PastebinResultsPage createNewPasteForTerms(WebDriver driver, String text, String name) {
        searchInputNewPaste.sendKeys(text);
        searchInputPasteExpirationMenu.click();
        searchInputPasteExpiration.click();
        searchInputSyntaxHighlightingMenu.click();
        searchInputSyntaxHighlighting.click();
        searchInputPasteName.sendKeys(name);
        createNewPasteButton.click();
        return new PastebinResultsPage(driver, text, name);
    }

}

