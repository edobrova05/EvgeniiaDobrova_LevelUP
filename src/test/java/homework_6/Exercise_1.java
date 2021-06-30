package homework_6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static utils.SleepUtils.sleep;

public class Exercise_1 extends MailConfigurations {

    @Test
    public void sendMailTest() {

        String expectedTitle = "Входящие - Почта Mail.ru";
        sleep(2500);
        Object assertEquals;
        assertEquals(driver.getTitle(), expectedTitle);

        WebElement writeMail = driver.findElement(By.className("compose-button__txt"));
        writeMail.click();
        sleep(2500);

        //заполнить поле email
        WebElement recipient = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[data-name='to'] input"))));
        recipient.sendKeys(MYEMAIL);
        sleep(2500);
        String expectedRecipient = recipient.getText();

        //заполнить тему письма
        WebElement theme = wait.until(ExpectedConditions.elementToBeClickable((By.name("Subject"))));
        theme.sendKeys("Homework 6");
        String expectedTheme = theme.getText();
        sleep(2500);

        //заполнить поле письма
        WebElement letter = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[role='textbox']"))));
        letter.sendKeys("Exercise 1");
        String expectedLetter = letter.getText();
        sleep(2500);

        //сохранить письмо
        WebElement buttonSave = driver.findElement(By.cssSelector("span[title='Сохранить']"));
        buttonSave.click();
        sleep(2500);

        // закрыть
        WebElement close = driver.findElement(By.cssSelector("button[title='Закрыть']"));
        close.click();
        sleep(2500);

        //открыть черновики
        WebElement drafts = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/drafts/']")));
        drafts.click();
        sleep(2500);

        //проверить, что письмо сохранилось там
        WebElement checkDraft = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("llc__container")));
        checkDraft.click();
        sleep(2500);

        String actualRecipient = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[data-name='to'] input")))).getText();
        String actualTheme = wait.until(ExpectedConditions.elementToBeClickable((By.name("Subject")))).getText();
        String actualLetter = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div[role='textbox']")))).getText();

        assertEquals(actualRecipient, expectedRecipient);
        assertEquals(actualTheme, expectedTheme);
        assertEquals(actualLetter, expectedLetter);
        sleep(2500);

        //отправить письмо
        WebElement sendMail = driver.findElement(By.cssSelector("span[title='Отправить']"));
        sendMail.click();
        sleep(2500);

        //закрыть сообщение
        WebElement closeMessage = driver.findElement(By.cssSelector("span[title='Закрыть']"));
        closeMessage.click();
        sleep(2500);

        boolean actualSentText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='У вас нет незаконченных']/.."))).isDisplayed();
        assertTrue(actualSentText);
        sleep(2500);

        driver.findElement(By.xpath("//*[text()='Отправленные']/..")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("llc__container")));

        List<WebElement> elements = driver.findElements(By.cssSelector("[class='llc__item llc__item_title']"));
        Assert.assertTrue(elements.get(0).getText().contains(expectedTheme));

    }
}
