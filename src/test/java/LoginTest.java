import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v142.network.model.TrustTokenOperationDone;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    @Test
    public void checkLogin() {
        WebDriver browser = new ChromeDriver();
        browser.get("Https://www.saucedemo.com/");
        browser.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        String title = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, "Products");
        browser.quit();
    }
    @Test
    public void checkIncorrectLogin() {
        WebDriver browser = new ChromeDriver();
        browser.get("Https://www.saucedemo.com/");
        browser.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauc");
        browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        boolean isErrorMsgDisplayed = browser.findElement(By.xpath("//*[@data-test='error']")).isDisplayed();
        assertTrue(isErrorMsgDisplayed, "The error message fails to appear");
        browser.quit();
    }
}
