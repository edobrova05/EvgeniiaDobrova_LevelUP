package homework_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractMailRuPage {


    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final String USERNAME = "evgeniia.dobrova";
    protected final String MYEMAIL = USERNAME + "@mail.ru";
    protected final String PASSWORD = "122333janed";
    protected final String URL = "https://mail.ru";
    protected final String TOPIC = "Homework 7";
    protected final String TESTTOPIC = "Тест";
    protected final String TEXT = "Exercise";

    @FindBy(css = "nav.nav a")
    protected List<WebElement> folderLinks;

    protected AbstractMailRuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public MailFolderPage openFolder(String folder) {
        for (WebElement folderLink : folderLinks) {
            if (folderLink.getText().contains(folder)) {
                folderLink.click();
                break;
            }
        }
        return new MailFolderPage(driver);
    }
}