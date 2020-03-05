package pastbinTest.pageObject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pastbinTest.pageObject.page.PastebinHomePage;

import static org.testng.Assert.assertTrue;

public class PastbinTest {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        new PastebinHomePage(driver)
                .openPage()
                .createNewPasteForTerms(driver, "git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force", "how to gain dominance among developers");
    }

    @Test
    public void createNewPasteWithName() {
        assertTrue(driver.getTitle().contains("how to gain dominance among developers"));
    }

    @Test
    public void createNewPasteWithContent() {
        assertTrue(driver.findElement(By.xpath("//*[@id='paste_code']"))
                .getText()
                .contains("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force"));
    }

    @Test
    public void createNewPasteWithSyntaxHighlighting() {
        assertTrue(driver.findElement(By.xpath("//*[@id='code_buttons']/span[2]/a"))
                .getText()
                .contains("Bash"));
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        //  driver.quit();
        //  driver = null;
    }
}
