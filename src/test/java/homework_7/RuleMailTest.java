package homework_7;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static utils.SleepUtils.sleep;

public class RuleMailTest extends AbstractMailTest{

    @Test
    public void checkTestFolderTest(){
        MailRuEmailPage write = new MailRuMainPage(driver)
                .open()
                .enterEmail("evgeniia.dobrova")
                .clickToEnterPassword()
                .enterPassword("122333janed")
                .clickToLogin()
                .writeEmail()
                .fillInRecipient()
                .fillInTestTheme()
                .fillInMailBody()
                .sendMail()
                .closeMessage()
                .openFolder("Отправленные")
                .checkLastMail()
                .openFolder("Тест")
                .checkLastMail();

        sleep(2500);

        MailRuEmailPage mailBody = new MailFolderPage(driver).checkDrafts();
        sleep(2500);

        assertEquals(mailBody.MYEMAIL, mailBody.checkSentRecipient());
        assertEquals(mailBody.TESTTOPIC, mailBody.checkSentTheme());
        assertEquals(mailBody.TEXT, mailBody.checkSentLetter());
        sleep(2500);


    }
}
