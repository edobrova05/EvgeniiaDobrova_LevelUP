package homework_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class AbstractMailTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    static void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver();
        context.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //public void exit() {
        //driver.findElement(By.partialLinkText("evgeniia.dobrova")).click();
        //driver.findElement(By.xpath("//a[contains(., 'Выйти')]")).click();
    //}



    /*@AfterSuite
    public void tearDown() {
        driver.quit();
    }*/

}
