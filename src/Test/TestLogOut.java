package Test;

import Pages.HomePage;
import Pages.LogIn;
import Pages.Registracija;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogOut {

    private WebDriver webDriver;
    private HomePage homePage;
    private LogIn logIn;
    private Registracija registracija;

    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        logIn = new LogIn(webDriver);
        registracija = new Registracija(webDriver);
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://magento.softwaretestingboard.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testLogOut () throws InterruptedException {

        homePage.clickSignInBtn();
        logIn.clickLogIn();
        logIn.inputEmailLogIn("roni_cost@example.com");
        logIn.inputPassLogIn("roni_cost3@example.com");
        logIn.clickSignInBtn();
        logIn.inputEmailLogIn("pmarkovic287@gmail.com");
        logIn.inputPassLogIn("Huge2222");

        //Needed to manually add captcha into box
        Thread.sleep(20000);
        logIn.clickSecondSignIn();
        Thread.sleep(3000);
        //Validating Log in
        Assert.assertTrue(logIn.getModalWelcome().contains("Welcome,"));
        registracija.clickWelcomeButton();
        registracija.clickSignOutButton();
        Assert.assertEquals(registracija.getModalsIGNoUT(), "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/");
    }
}
