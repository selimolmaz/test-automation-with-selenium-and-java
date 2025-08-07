package org.makak.page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Type in username: {username}")
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Type in password: {password}")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Login: {username} / {password}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Get error message.")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
