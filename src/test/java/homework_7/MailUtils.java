package homework_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailUtils {

    protected final String USERNAME = "eedobrova";
    protected final String MYEMAIL = USERNAME + "@bk.ru";
    protected final String PASSWORD = "testmail23456";
    protected final String URL = "https://mail.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;
}
