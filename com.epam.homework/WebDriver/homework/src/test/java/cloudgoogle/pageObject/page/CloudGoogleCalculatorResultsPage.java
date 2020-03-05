package cloudgoogle.pageObject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleCalculatorResultsPage extends BasePage {

    private static final String MAILPAGE_URL = "https://10minutemail.com/";
    private final By iframePath = By.xpath("//*[@id='cloud-site']//iframe");
    private final By myFramePath = By.xpath("//*[@id='myFrame']");

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::div[contains(text(), 'VM class')]")
    private WebElement searchResultValueOfVmClass;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::div[contains(text(), 'Instance type')]")
    private WebElement searchResultValueOfInstanceType;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::div[contains(text(), 'Region')]")
    private WebElement searchResultValueOfRegion;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::div[contains(text(), 'local SSD')]")
    private WebElement searchResultValueOfLocalSSD;

    @FindBy(xpath = "//*[@id='compute']/descendant-or-self::div[contains(text(), 'Commitment term')]")
    private WebElement searchResultValueOfCommitmentTerm;

    @FindBy(xpath = "//*[@id='resultBlock']/descendant-or-self::div[@class='md-list-item-text']//b")
    private WebElement searchResultValueOfCostMonth;

    @FindBy(id = "email_quote")
    private WebElement searchEmailEstimateButton;

    @FindBy(id = "input_427")
    private WebElement searchInputEmail;

    @FindBy(xpath = "//*[@id='dialogContent_433']/descendant-or-self::button[@aria-label='Send Email']")
    private WebElement searchSendEmailButton;


    public CloudGoogleCalculatorResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultValueOfVmClass() {
        return searchResultValueOfVmClass.getText();
    }

    public String getTextSearchResultValueOfInstanceType() {
        return searchResultValueOfInstanceType.getText();
    }

    public String getTextSearchResultValueOfRegion() {
        return searchResultValueOfRegion.getText();
    }

    public String getTextSearchResultValueOfLocalSSD() {
        return searchResultValueOfLocalSSD.getText();
    }

    public String getTextSearchResultValueOfCommitmentTerm() {
        return searchResultValueOfCommitmentTerm.getText();
    }

    public String getTextSearchResultValueOfCostMonth() {
        return searchResultValueOfCostMonth.getText();
    }

    public MailHomePage openPageMailHomePageInNewTab(WebDriver driver) {
        jsExecutorClick(searchEmailEstimateButton);
        createNewTub(MAILPAGE_URL);

        return new MailHomePage(driver);
    }

    public void sendEmail(String mail) {
        driver.switchTo().frame(driver.findElement((iframePath)));
        driver.switchTo().frame(driver.findElement((myFramePath)));
        jsExecutorClick(searchInputEmail);
        searchInputEmail.sendKeys(mail);
        jsExecutorClick(searchSendEmailButton);
    }
}
