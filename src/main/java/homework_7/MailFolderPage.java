package homework_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.SleepUtils.sleep;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MailFolderPage extends AbstractMailRuPage{

    protected MailFolderPage(WebDriver driver) {
        super(driver);
    }

    public MailRuEmailPage checkDrafts(){
        wait.until(presenceOfElementLocated(By.className("llc__container"))).click();
        sleep(2500);
        return new MailRuEmailPage(driver);
    }

    public MailFolderPage checkMailSent(){
        wait.until(invisibilityOfElementLocated(By.className("llc__container")));
        return this;
    }

    public MailRuEmailPage checkLastMail(){
        wait.until(visibilityOfElementLocated(By.className("llc__container")));
        sleep(2500);
        return new MailRuEmailPage(driver);
    }
}
