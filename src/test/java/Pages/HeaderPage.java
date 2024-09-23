package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    WebDriver driver;
    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "sign-in-button")
    WebElement signInButton;

    @FindBy(id = "login-username-input-box")
    WebElement usernameInputBox;
    @FindBy(id = "login-password-input-box")
    WebElement passwordInputBox;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public void clickSignInButton () {
        signInButton.click();
    }

    public void enterEmail(String email){
        usernameInputBox.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInputBox.sendKeys(password);
    }

    public void clickLoginButton () {
        loginButton.click();
    }
}
