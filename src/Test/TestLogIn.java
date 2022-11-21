package Test;

import Helpers.Strings_Test;
import Pages.LogIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogIn {

    private WebDriver webDriver;
    private LogIn logIn;


    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        logIn = new LogIn(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to("https://magento.softwaretestingboard.com/");

    }

    @Test
    public void testLogInHappyPath () throws InterruptedException {

        logIn.clickLogIn();
        logIn.inputEmailLogIn("roni_cost@example.com");
        logIn.inputPassLogIn("roni_cost3@example.com");
        logIn.clickSignInBtn();
        Thread.sleep(20000);
        //Rucno ubaciti captcha kada baci sleep na drugoj log in strani
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Huge2222");
        logIn.clickSecondSignIn();
    }

    @Test
    public void testLogInWithBlankFields(){

        logIn.clickLogIn();
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("");
        logIn.inputPassLogIn("");
        Assert.assertEquals(logIn.getModalErrorText(), Strings_Test.MODAL_LOG_IN_ERROR_TEXT,"Text should be the same");
    }
    @Test
    public void testinputEmailWithNoPassword(){

        logIn.clickLogIn();
        logIn.inputEmailLogIn("test@test.com");
        logIn.inputPassLogIn("");
        logIn.clickSignInBtn();
        Assert.assertEquals(logIn.getModalErrorTitlePass(), Strings_Test.MODAL_LOG_IN_ERROR_TEXT,"The text should be the same");

    }
    @Test
    public void testInputAllUpperCaseInMail () throws InterruptedException {

        logIn.clickLogIn();
        logIn.inputEmailLogIn("MARKO@gmail.com");
        logIn.inputPassLogIn("Petro22");
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("MARKO@gmail.com");
        logIn.inputPassLogIn("Petro22");
        Thread.sleep(10000);
        //Needed to manually input captcha
        logIn.clickSecondSignIn();
        Thread.sleep(3000);
        Assert.assertEquals(logIn.getModalErrorBadInput(), Strings_Test.MODAL_EMAIL_ERROR_WITH_ALL_UPPERCASE_MSG, "The text should be the same");
    }
    @Test
    public void testInputWithoutSpecCharsInPass() throws InterruptedException {

        //Password needs to conatin at least 8 characters, at least one upper case letter and one number
        logIn.clickLogIn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("markoooo");
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("markoooo");
        //Needed to manually input captcha
        Thread.sleep(10000);
        logIn.clickSecondSignIn();
        Thread.sleep(5000);
        Assert.assertTrue(logIn.getModalErrorBadInput().contains(Strings_Test.MODAL_EMAIL_ERROR_WITH_ALL_UPPERCASE_MSG));
    }
    @Test
    public void testInputWithoutUpperCaseInPass() throws InterruptedException {

        //Password needs to conatin at least 8 characters, at least one upper case letter and one number
        logIn.clickLogIn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("marko6789");
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("marko6789");
        //Needed to manually input captcha
        Thread.sleep(10000);
        logIn.clickSecondSignIn();
        Thread.sleep(5000);
        Assert.assertEquals(logIn.getModalErrorBadInput(), Strings_Test.MODAL_EMAIL_ERROR_WITH_ALL_UPPERCASE_MSG);
    }
    @Test
    public void testInputWithoutNumbersInPass() throws InterruptedException {

        //Password needs to conatin ar least 8 characters, at least one upper case letter and one number
        logIn.clickLogIn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Marko!$#");
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Marko!$#");
        //Needed to manually input captcha
        Thread.sleep(10000);
        logIn.clickSecondSignIn();
        Thread.sleep(5000);
        Assert.assertEquals(logIn.getModalErrorBadInput(), Strings_Test.MODAL_EMAIL_ERROR_WITH_ALL_UPPERCASE_MSG);
    }
    @Test
    public void testInputLessThanEightCharsInPass() throws InterruptedException {

        //Password needs to conatin at least 8 characters, at least one upper case letter and one number
        logIn.clickLogIn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Marko79");
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Marko79");
        //Needed to manually input captcha
        Thread.sleep(10000);
        logIn.clickSecondSignIn();
        Thread.sleep(5000);
        Assert.assertEquals(logIn.getModalErrorBadInput(), Strings_Test.MODAL_EMAIL_ERROR_WITH_ALL_UPPERCASE_MSG);

    }
    @Test
    public void testInputMoreThanEightCharsInPass() throws InterruptedException {

        //Password needs to conatin at least 8 characters, at least one upper case letter and one number
        logIn.clickLogIn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Marko79@!");
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Marko79@!");
        //Needed to manually input captcha
        Thread.sleep(10000);
        logIn.clickSecondSignIn();
        Thread.sleep(5000);
        Assert.assertEquals(logIn.getModalErrorBadInput(), Strings_Test.MODAL_EMAIL_ERROR_WITH_ALL_UPPERCASE_MSG);
    }

    @AfterMethod
    public void teardown() {
        webDriver.manage().deleteAllCookies();
        webDriver.close();
        webDriver.quit();
    }
}
