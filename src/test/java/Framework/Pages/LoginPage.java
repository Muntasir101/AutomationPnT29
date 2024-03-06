package Framework.Pages;

import Framework.Locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private WebElement EmailAddress;
    private WebElement Password_field;
    private WebElement LoginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        initializeElements();
    }

    private void initializeElements(){
        EmailAddress = driver.findElement(By.cssSelector(LoginPageLocators.EMAIL_INPUT_FIELD_CSS));
        Password_field = driver.findElement(By.cssSelector(LoginPageLocators.PASSWORD_INPUT_FIELD_CSS));
        LoginButton = driver.findElement(By.cssSelector(LoginPageLocators.LOGIN_BUTTON_CSS));
    }

    public void enterEmailAddress(String email){
        EmailAddress.clear();
        EmailAddress.sendKeys(email);
    }
    public void enterPassword(String password){
        Password_field.clear();
        Password_field.sendKeys(password);
    }
    public void clickLoginButton(){
        LoginButton.click();
    }

}
