package org.makak.test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.makak.page.LoginPage;
import org.makak.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Login")
@Story("Test for invalid login.")
public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    @Description("Test using invalid usernames for login.")
    public void testInvalidLogin(String username, String password, boolean shouldLogin) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        // Hata mesajı kontrolü
        String errorText = loginPage.getErrorMessage();
        Assert.assertTrue(errorText.contains("Username and password do not match"), "Hata mesajı bekleniyor!");
    }
}
