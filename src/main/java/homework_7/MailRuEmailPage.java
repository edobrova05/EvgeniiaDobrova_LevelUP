package homework_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static utils.SleepUtils.sleep;

public class MailRuEmailPage extends AbstractMailRuPage{

    @FindBy(className="compose-button__txt")
    private WebElement writeMailButton;

    @FindBy(css="div[data-name='to'] input")
    private WebElement emailInput;

    @FindBy(css = "[name='Subject']")
    private WebElement theme;

    //@FindBy(css = "div[role='textbox'] br")
    //private WebElement letter;

    @FindBy(css = "span[title='Сохранить']")
    private WebElement saveButton;

    @FindBy(css = "button[title='Закрыть']")
    private WebElement closeButton;

    @FindBy(css = "span[title='Закрыть']")
    private WebElement closeMessageButton;

    @FindBy(css = "span[title='Отправить']")
    private WebElement sendButton;

    @FindBy(xpath = "//*[text() = 'Удалить']")
    private WebElement deleteButton;

    //@FindBy(css = "nav.nav a")
    //protected List<WebElement> folderLinks;

    public String actualRecipient;
    public String actualTheme;
    public String actualLetter;


    protected MailRuEmailPage(WebDriver driver) {
        super(driver);
    }

    public MailRuEmailPage writeEmail(){
        wait.until(elementToBeClickable(writeMailButton)).click();
        return this;
    }

    public MailRuEmailPage fillInRecipient(){
        wait.until(elementToBeClickable(emailInput)).click();
        emailInput.sendKeys(MYEMAIL);
        return this;
    }

    public MailRuEmailPage fillInTheme(){
        wait.until(elementToBeClickable(theme)).click();
        theme.sendKeys(TOPIC);
        return this;
    }

    public MailRuEmailPage fillInTestTheme(){
        wait.until(elementToBeClickable(theme)).click();
        theme.sendKeys(TESTTOPIC);
        return this;
    }

    public MailRuEmailPage fillInMailBody(){
        wait.until(presenceOfElementLocated(By.cssSelector("div[role='textbox'] br"))).sendKeys(TEXT);
        return this;
    }

    public MailRuEmailPage saveMail(){
        wait.until(elementToBeClickable(saveButton)).click();
        return this;
    }

    public MailRuEmailPage closeMail(){
        wait.until(elementToBeClickable(closeButton)).click();
        return this;
    }

    public MailRuEmailPage sendMail(){
        wait.until(elementToBeClickable(sendButton)).click();
        return this;
    }

    public MailRuEmailPage closeMessage(){
        wait.until(elementToBeClickable(closeMessageButton)).click();
        return this;
    }

    public MailRuEmailPage deleteMail(){
        wait.until(elementToBeClickable(deleteButton)).click();
        return this;
    }

    public MailRuEmailPage openLastMail(){
        wait.until(visibilityOfElementLocated(By.cssSelector("[class='llc__item llc__item_correspondent llc__item_unread']"))).click();
        sleep(2500);
        return this;
    }

    /*public MailFolderPage openFolder(String folder) {
        for (WebElement folderLink : folderLinks) {
            if (folderLink.getText().contains(folder)) {
                folderLink.click();
                break;
            }
        }
        return new MailFolderPage(driver);
    }*/


    public String checkRecipient(){
        return wait.until(elementToBeClickable((By.cssSelector("span[class='text--1tHKB']")))).getText();
    }

    public String checkTheme(){
        //return wait.until(visibilityOfElementLocated((By.name("Subject")))).getText();
        return wait.until(elementToBeClickable((By.cssSelector("[name='Subject']")))).getAttribute("value");
    }

    public String checkLetter(){
        return wait.until(visibilityOfElementLocated((By.xpath("//div[@class='js-helper js-readmsg-msg']/div/div/div/div")))).getText();
    }

    //++
    public String checkSentRecipient(){
        return wait.until(elementToBeClickable((By.cssSelector("[class='letter-contact']")))).getAttribute("title");
    }

    //++
    public String checkSentTheme(){
        //return wait.until(visibilityOfElementLocated((By.name("Subject")))).getText();
        return wait.until(elementToBeClickable((By.cssSelector("[class='thread__subject thread__subject_pony-mode']")))).getText();
    }

    public String checkSentLetter(){
        return wait.until(visibilityOfElementLocated((By.cssSelector("[class='letter-body']")))).getText();
    }

}
