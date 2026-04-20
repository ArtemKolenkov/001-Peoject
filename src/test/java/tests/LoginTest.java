package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(dataProvider = "incorrectData")
    public void checkLockedUserLogin(String user, String password, String errorMessageText) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error messege fails to appear");
        assertEquals(loginPage.errorMessageText(), errorMessageText, "Epic sadface: Sorry, this user has been locked out.");
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"locked_out_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
