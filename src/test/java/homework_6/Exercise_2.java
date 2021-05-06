package homework_6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.SleepUtils.sleep;

public class Exercise_2 extends MailConfigurations{

    @Test
    public void mailThemeTest(){

        String expectedTitle = "Входящие - Почта Mail.ru";
        sleep(2500);
        Object assertEquals;
        assertEquals(driver.getTitle(), expectedTitle);

        WebElement writeMail = driver.findElement(By.className("compose-button__txt"));
        writeMail.click();
        sleep(2500);

        WebElement recipient = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[data-name='to'] input"))));
        recipient.sendKeys(MYEMAIL);
        sleep(2500);
        String expectedRecipient = recipient.getText();

        WebElement theme = wait.until(ExpectedConditions.elementToBeClickable((By.name("Subject"))));
        theme.sendKeys("Тест");
        String expectedTheme = theme.getText();
        sleep(2500);

        WebElement letter = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[role='textbox']"))));
        letter.sendKeys("Exercise 2");
        String expectedLetter = letter.getText();
        sleep(2500);

        WebElement sendMail = driver.findElement(By.cssSelector("span[title='Отправить']"));
        sendMail.click();

        WebElement closeMessage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Закрыть']")));
        closeMessage.click();
        sleep(2500);

        driver.findElement(By.xpath("//*[text()='Отправленные']/..")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("llc__container")));

        List<WebElement> elements = driver.findElements(By.cssSelector("[class='llc__item llc__item_title']"));
        Assert.assertTrue(elements.get(0).getText().contains(expectedTheme));
        sleep(2500);

        driver.findElement(By.xpath("//*[text()='Тест']/..")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("llc__container")));

        List<WebElement> elements1 = driver.findElements(By.cssSelector("[class='llc__item llc__item_title']"));
        Assert.assertTrue(elements1.get(0).getText().contains(expectedTheme));

        String actualRecipient = driver.findElement(By.xpath("//*[@class='llc__item llc__item_correspondent llc__item_unread']/span")).getAttribute("title");
        assertTrue(actualRecipient.contains(expectedRecipient));

        driver.findElement(By.xpath("//*[@class='llc__item llc__item_correspondent llc__item_unread']/span")).click();
        sleep(2500);

        //String actualTheme = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@class='thread__subject thread__subject_pony-mode']")))).getText();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thread__header")));

        //проблема с actual и expected
        String actualTheme = driver.findElement(By.xpath("//*[@class='thread__subject thread__subject_pony-mode']")).getText();
        assertEquals(actualTheme, expectedTheme);
        sleep(2500);

        String actualLetter = driver.findElement(By.cssSelector("div[class='cl_257521']")).getText();
        assertEquals(actualLetter, expectedLetter);
        sleep(2500);


    }

}
