package homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.SleepUtils.sleep;

public class Exercise_3 extends MailConfigurations {
    @Test
    public void deleteMailTest() {
        String expectedTitle = "Входящие - Почта Mail.ru";
        sleep(2500);
        assertEquals(driver.getTitle(), expectedTitle);

        WebElement writeMail = driver.findElement(By.className("compose-button__txt"));
        writeMail.click();
        sleep(2500);

        WebElement recipient = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[data-name='to'] input"))));
        recipient.sendKeys(MYEMAIL);
        sleep(2500);
        String expectedRecipient = recipient.getText();

        WebElement theme = wait.until(ExpectedConditions.elementToBeClickable((By.name("Subject"))));
        theme.sendKeys("Homework 6");
        String expectedTheme = theme.getText();
        sleep(2500);

        WebElement letter = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[role='textbox']"))));
        letter.sendKeys("Exercise 3");
        String expectedLetter = letter.getText();
        sleep(2500);

        WebElement sendMail = driver.findElement(By.cssSelector("span[title='Отправить']"));
        sendMail.click();

        WebElement closeMessage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Закрыть']")));
        closeMessage.click();
        sleep(2500);

        driver.findElement(By.xpath("//*[text()='Входящие']/..")).click();
        WebElement incoming = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='mt-h-c__item mt-h-c__item_title']")));
        incoming.click();

        WebElement newMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='llc__item llc__item_correspondent llc__item_unread']")));
        assertTrue(newMail.isDisplayed());
        newMail.click();

        //проблема с actual и expected
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thread__header")));

        String actualTheme = driver.findElement(By.cssSelector("[class='thread__subject thread__subject_pony-mode']")).getText();
        assertEquals(actualTheme, expectedTheme);

        String actualRecipient = driver.findElement(By.className("letter-contact")).getAttribute("title");
        Assert.assertEquals(actualRecipient, expectedRecipient);

        String actualLetter = driver.findElement(By.xpath("//div[@class='js-helper js-readmsg-msg']/div/div/div/div")).getText();
        Assert.assertEquals(actualLetter, expectedLetter);
        sleep(2500);

        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[text() = 'Удалить']")))).click();
        sleep(2500);

        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(., 'Корзина')]")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='llc__item llc__item_title']")));
        sleep(2500);

    }
}
