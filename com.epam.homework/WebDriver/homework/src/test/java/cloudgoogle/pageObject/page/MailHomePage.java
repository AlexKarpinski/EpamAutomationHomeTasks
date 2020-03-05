package cloudgoogle.pageObject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailHomePage extends BasePage {

    private final By searchMessageID = By.xpath("ui-id-1");

    @FindBy(id = "mailAddress")
    private WebElement searchMailAddress;

    @FindBy(id = "ui-id-1")
    private WebElement searchMessage;

    @FindBy(xpath = "//*[@id='mobilepadding']//h3[contains(text(), 'USD')]")
    private WebElement searchCostFromMessage;


    public MailHomePage(WebDriver driver) {
        super(driver);
    }

    public String copyMailAddress() {
        return searchMailAddress.getAttribute("value");
    }

    public String getCostFromMessage() {
        new WebDriverWait(driver, 300)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy((searchMessageID)));
        jsExecutorClick(searchMessage);

        return searchCostFromMessage.getText();
    }
}