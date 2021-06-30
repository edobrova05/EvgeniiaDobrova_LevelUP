package homework_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class MailRuMainPage extends AbstractMailRuPage {

    @FindBy(css = "[name='login']")
    private WebElement emailInput;

    @FindBy(css = "select[name='domain']")
    private WebElement chooseDomain;

    @FindBy(css = "[value='@bk.ru']")
    private WebElement domainBk;

    @FindBy(css = "[data-testid='enter-password']")
    private WebElement enterPasswordButton;

    @FindBy(css = "[data-testid='password-input']")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid='login-to-mail']")
    private WebElement loginButton;

    protected MailRuMainPage(WebDriver driver) {
        super(driver);
    }

    public MailRuMainPage open(){
        driver.navigate().to("https://mail.ru");
        return this;
    }

    public MailRuMainPage enterEmail (String email){
        wait.until(visibilityOf(emailInput)).sendKeys(email);
        return this;
    }

    public MailRuMainPage clickToEnterPassword() {
        wait.until(elementToBeClickable(enterPasswordButton)).click();
        return this;
    }

    public MailRuMainPage enterPassword (String password){
        wait.until(visibilityOf(passwordInput)).sendKeys(password);
        return this;
    }


    public MailRuEmailPage clickToLogin (){
        wait.until(elementToBeClickable(loginButton)).click();
        return new MailRuEmailPage(driver);
    }
}
