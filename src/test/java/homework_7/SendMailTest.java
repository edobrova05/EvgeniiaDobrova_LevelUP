package homework_7;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.SleepUtils.sleep;


public class SendMailTest extends AbstractMailTest {

    @Test
    public void checkDraftsAndSendMailTest(){

        MailFolderPage write = new MailRuMainPage(driver)
                .open()
                .enterEmail("evgeniia.dobrova")
                .clickToEnterPassword()
                .enterPassword("122333janed")
                .clickToLogin()
                .writeEmail()
                .fillInRecipient()
                .fillInTheme()
                .fillInMailBody()
                .saveMail()
                .closeMail()
                .openFolder("Черновики");

        sleep(2500);

        MailRuEmailPage mailBody = new MailFolderPage(driver).checkDrafts();
        sleep(2500);

        assertEquals(mailBody.MYEMAIL, mailBody.checkRecipient());
        assertEquals(mailBody.TOPIC, mailBody.checkTheme());
        assertEquals(mailBody.TEXT, mailBody.checkLetter());
        sleep(2500);

        mailBody
                .sendMail()
                .closeMessage()
                .openFolder("Черновики")
                .checkMailSent()
                .openFolder("Отправленные")
                .checkLastMail();

    }
}
