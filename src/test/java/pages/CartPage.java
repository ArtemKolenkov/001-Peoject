package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By pageTitle = By.xpath("//*[@data-test='title']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(pageTitle).isDisplayed();
    }
}
