package cloudgoogle.waits;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomConditions {

    public static ExpectedCondition<Boolean> completedWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
          return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .equals("complete");
            }
        };
    }
}
