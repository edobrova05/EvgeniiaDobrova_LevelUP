package homework_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class MailConfigurations {

    protected final String USERNAME = "eedobrova";
    protected final String MY_EMAIL = USERNAME + "@bk.ru";
    protected final String PASSWORD = "testmail23456";
    protected final String URL = "https://mail.ru";

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 20);
        WebElement login = driver.findElement(By.cssSelector("[name='login']"));
        login.sendKeys(USERNAME);
        WebElement domain = driver.findElement(By.cssSelector("[name='domain']"));
        domain.click();
        WebElement domainBk = driver.findElement(By.cssSelector("[value='@bk.ru']"));
        domainBk.click();
        driver.findElement(By.cssSelector("[data-testid='enter-password']")).click();
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("[data-testid='login-to-mail']")).click();
    }

    @AfterMethod
    public void exit() {
        driver.findElement(By.cssSelector("div[aria-label='eedobrova@bk.ru']")).click();
        driver.findElement(By.xpath("//*[text() = 'Выйти']")).click();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();

}

}
