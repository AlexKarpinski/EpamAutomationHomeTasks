package cloudgoogle.pageObject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleCalculatorPage extends BasePage{

    private final By iframePath = By.xpath("//*[@id='cloud-site']//iframe");
    private final By myFramePath = By.xpath("//*[@id='myFrame']");

    @FindBy(xpath = "//*[@id='input_55']")
    private WebElement searchInputInstances;

    @FindBy(xpath = "//div//label[text()='Machine type']/following-sibling::md-select//span[@class = 'md-select-icon']")
    private WebElement searchInputInstanceType;

    @FindBy(xpath = "//*[@id='select_option_207']/descendant-or-self::div[@class = 'md-text ng-binding']")
    private WebElement inputInstanceType;

    @FindBy(xpath = "//*[@id='mainForm']//md-checkbox[@aria-label='Add GPUs']")
    private WebElement searchCheckboxAddGPUs;

    @FindBy(xpath = "//*[@id='select_value_label_323']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement searchInputButtonNumberOfGPUs;

    @FindBy(xpath = "//*[@id='select_option_331']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement inputButtonNumberOfGPUs;

    @FindBy(xpath = "//*[@id='select_value_label_324']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement searchInputGPUs;

    @FindBy(xpath = "//*[@id='select_option_337']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement inputGPUs;

    @FindBy(xpath = "//*[@id='select_value_label_165']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement searchInputLocalSSD;

    @FindBy(xpath = "//*[@id='select_option_228']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement inputLocalSSD;

    @FindBy(xpath = "//*[@id='select_value_label_52']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement searchInputDatacenterLocation;

    @FindBy(xpath = "//*[@id='select_option_176']/descendant-or-self::div[@class='md-text ng-binding']")
    private WebElement inputDatacenterLocation;

    @FindBy(xpath = "//*[@id='select_value_label_53']/descendant-or-self::div[@class='md-text']")
    private WebElement searchInputCommitedUsage;

    @FindBy(xpath = "//*[@id='select_option_86']/descendant-or-self::div[@class='md-text']")
    private WebElement inputCommitedUsage;

    @FindBy(xpath = "//*[@id='mainForm']//button[@aria-label='Add to Estimate'][@ng-disabled='ComputeEngineForm.$invalid || !listingCtrl.isGceAvailable']")
    private WebElement searchAddEstimateButton;

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleCalculatorResultsPage createCalculatorResultsPageWithTerms() throws InterruptedException {
        isLoadComplete();
        waitPresenceOfAllElements(iframePath);
        driver.switchTo().frame(driver.findElement((iframePath)));
        waitPresenceOfAllElements(myFramePath);
        driver.switchTo().frame(driver.findElement(myFramePath));
        jsExecutorClick(searchInputInstances);
        searchInputInstances.sendKeys("4");
        jsExecutorClick(searchInputInstanceType);
        jsExecutorClick(inputInstanceType);
        jsExecutorClick(searchCheckboxAddGPUs);
        jsExecutorClick(searchInputButtonNumberOfGPUs);
        jsExecutorClick(inputButtonNumberOfGPUs);
        jsExecutorClick(searchInputGPUs);
        jsExecutorClick(inputGPUs);
        jsExecutorClick(searchInputLocalSSD);
        jsExecutorClick(inputLocalSSD);
        jsExecutorClick(searchInputDatacenterLocation);
        jsExecutorClick(inputDatacenterLocation);
        jsExecutorClick(searchInputCommitedUsage);
        jsExecutorClick(inputCommitedUsage);
        jsExecutorClick(searchAddEstimateButton);
        return new CloudGoogleCalculatorResultsPage(driver);
    }
}