package pastbinHello.pageObject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastbinHello.pageObject.page.PastebinHomePage;

public class PastbinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test(description = "Create new Paste with terms")
    public void commonSearchTermResultsAreNotEmpty() {

       new PastebinHomePage(driver)
               .openPage()
               .createNewPasteForTerms(driver, "Hello from WebDriver", "helloweb");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
