package cloudgoogle.pageObject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BasePage {
    public WebDriver driver;
    public JavascriptExecutor jsExecutor;

    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void waitClickable(WebElement element) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitPresenceOfAllElements(By elementBy) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
    }

    public void click(WebElement element) {
        waitClickable(element);
        element.click();
    }

    public void jsExecutorClick(WebElement element) {
        waitClickable(element);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void goToTub(int i) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i));
    }

    public void createNewTub(String URL) {
        jsExecutor.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(URL);
    }

    public boolean isLoadComplete() {
        new WebDriverWait(driver, 20);
        return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("loaded")
                || ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete");
    }
}
