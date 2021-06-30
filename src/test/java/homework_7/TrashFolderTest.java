package homework_7;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static utils.SleepUtils.sleep;

public class TrashFolderTest extends AbstractMailTest{

    @Test
    public void createAndDeleteMailTest(){

        MailRuEmailPage write = new MailRuMainPage(driver)
                .open()
                .enterEmail("evgeniia.dobrova")
                .clickToEnterPassword()
                .enterPassword("122333janed")
                .clickToLogin()
                .writeEmail()
                .fillInRecipient()
                .fillInTheme()
                .fillInMailBody()
                .sendMail()
                .closeMessage()
                .openFolder("Входящие")
                .checkLastMail()
                .openLastMail();


        assertEquals(write.MYEMAIL, write.checkSentRecipient());
        assertEquals(write.TOPIC, write.checkSentTheme());
        assertEquals(write.TEXT, write.checkSentLetter());
        sleep(2500);

        write
                .deleteMail()
                .openFolder("Корзина")
                .checkLastMail();

    }
}
