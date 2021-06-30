package homework_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class MailConfigurations {

    protected final String USERNAME = "eedobrova";
    protected final String MYEMAIL = USERNAME + "@bk.ru";
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
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

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
       WebElement mailClose = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='eedobrova@bk.ru']")));
       mailClose.click();

       WebElement goOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-click-counter='75068944']")));
       goOut.click();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();

}

}
