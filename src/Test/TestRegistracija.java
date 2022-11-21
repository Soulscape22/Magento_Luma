package Test;

import Helpers.Strings_Test;
import Pages.HomePage;
import Pages.Registracija;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRegistracija {

    private WebDriver webDriver;
    private HomePage homePage;
    private Registracija registracija;
    private Faker faker;

    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        registracija = new Registracija(webDriver);
        faker = new Faker();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://magento.softwaretestingboard.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

   @Test(priority = 50)
    public void registerHappyPath() {

        homePage.clickRegisterBtn();
        registracija.inputName(faker.name().firstName());
        registracija.inputLastName(faker.name().lastName());
        registracija.inputEmail(Faker.instance().bothify("#?#?#?#?##@gmail.com"));
        registracija.inputPassword("Petrosenko2022");
        registracija.inputConfirmPassword("Petrosenko2022");
        registracija.clickCreateAccount();
        Assert.assertEquals(registracija.getModalRegistracija(), Strings_Test.MODAL_REGISTRACIJA, "Text should be the same");
   }

   @Test(priority = 40)
    public void registerUnHappyPathName() throws InterruptedException {

       //Verifikovati da li je moguce se registrovati sa simbolima u imenu
       homePage.clickRegisterBtn();
       registracija.inputName("!#$%&&/*");
       registracija.inputLastName(faker.name().lastName());
       registracija.inputEmail(Faker.instance().bothify("#?#?#??###@gmail.com"));
       registracija.inputPassword("Petrosenko2022");
       registracija.inputConfirmPassword("Petrosenko2022");
       registracija.clickCreateAccount();
       Thread.sleep(10000);
       Assert.assertEquals(registracija.getModalFirstName(), Strings_Test.MODAL_ALERT_FIRST_NAME_TEXT,"Alert text should 'First Name is not valid!'");
   }

   @Test(priority = 30)
    public void registerUnHappyPathLastName() throws InterruptedException {

       //Verifikovati da li je moguce se registrovati sa simbolima u prezimenu
       homePage.clickRegisterBtn();
       registracija.inputName(Faker.instance().letterify("?????"));
       registracija.inputLastName("!#$%&/()=*");
       registracija.inputEmail(Faker.instance().bothify("#?#?#??###@gmail.com"));
       registracija.inputPassword("Petrosenko2022");
       registracija.inputConfirmPassword("Petrosenko2022");
       registracija.clickCreateAccount();
       Thread.sleep(10000);
       Assert.assertEquals(registracija.getModalLastName(), Strings_Test.MODAL_ALERT_LAST_NAME_TEXT,"Alert text should 'Last Name is not valid!'");
   }

    @Test(priority = 10)
    public void registerUnHappyPathPassword() throws InterruptedException {

        //Verifikovati da li je moguce se registrovati sa manje od 8 simbola u lozinki
        homePage.clickRegisterBtn();
        registracija.inputName(Faker.instance().letterify("?????"));
        registracija.inputLastName(faker.name().lastName());
        registracija.inputEmail(Faker.instance().bothify("#?#?#??###@gmail.com"));
        registracija.inputPassword("Petro22");
        registracija.inputConfirmPassword("Petro22");
        registracija.clickCreateAccount();
        Thread.sleep(10000);
        Assert.assertEquals(registracija.getModalPassword(), Strings_Test.MODAL_PASSWORD_ALERT,"Alert text should 'Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.'");
    }
    @Test(priority = 60)
    public void testRegisterWithBlankName() throws InterruptedException {

        homePage.clickRegisterBtn();
        registracija.inputName("");
        registracija.inputLastName("");
        registracija.inputEmail("");
        registracija.inputPassword("");
        registracija.clickCreateAccount();
        Thread.sleep(5000);
        Assert.assertEquals(registracija.getModalErrorTextName(), Strings_Test.MODAL_REGISTER_ERROR_TEXT,"Text should be the same");
    }
    @Test(priority = 70)
    public void testRegisterWithBlankLastName() throws InterruptedException {

        homePage.clickRegisterBtn();
        registracija.inputName("Marko");
        registracija.inputLastName("");
        registracija.inputEmail("");
        registracija.inputPassword("");
        registracija.clickCreateAccount();
        Thread.sleep(5000);
        Assert.assertEquals(registracija.getModalErrorTextLastName(), Strings_Test.MODAL_REGISTER_ERROR_TEXT,"Text should be the same");
    }
    @Test(priority = 80)
    public void testRegisterWithBlankEmail() throws InterruptedException {

        homePage.clickRegisterBtn();
        registracija.inputName("Marko");
        registracija.inputLastName("Rankov");
        registracija.inputEmail("");
        registracija.inputPassword(faker.internet().password());
        registracija.clickCreateAccount();
        Thread.sleep(5000);
        Assert.assertEquals(registracija.getModalErrorTextEmail(), Strings_Test.MODAL_REGISTER_ERROR_TEXT,"Text should be the same");
    }
    @Test(priority = 90)
    public void testRegisterWithBlankPass() throws InterruptedException {
        homePage.clickRegisterBtn();
        registracija.inputName("Marko");
        registracija.inputLastName("Rankov");
        registracija.inputEmail("marko@gmail.com");
        registracija.inputPassword("");
        registracija.clickCreateAccount();
        Thread.sleep(5000);
        Assert.assertEquals(registracija.getModalErrorTextPass(), Strings_Test.MODAL_REGISTER_ERROR_TEXT,"Text should be the same");

    }
    @Test(priority = 100)
    public void testRegisterWithBlankConfirmPass() throws InterruptedException {
        homePage.clickRegisterBtn();
        registracija.inputName("Marko");
        registracija.inputLastName("Rankov");
        registracija.inputEmail("marko@gmail.com");
        registracija.inputPassword("Petro22");
        registracija.inputConfirmPassword("");
        registracija.clickCreateAccount();
        Thread.sleep(5000);
        Assert.assertEquals(registracija.getModalErrorTextConfirmPass(), Strings_Test.MODAL_REGISTER_ERROR_TEXT,"Text should be the same");

    }

    @Test(priority = 110)
    public void testInputPasswordWithLessThenEightChars() throws InterruptedException {

        homePage.clickRegisterBtn();
        registracija.inputName("Marko");
        registracija.inputLastName("Rankov");
        registracija.inputEmail(faker.internet().emailAddress());
        registracija.inputPassword("Marko22");
        Thread.sleep(5000);
        Assert.assertEquals(registracija.getModalErrorTextPass(), Strings_Test.MODAL_PASSWORD_ALERT,"the text should be the same");
    }

    @AfterMethod
    public void teardown() {
        webDriver.manage().deleteAllCookies();
        webDriver.close();
        webDriver.quit();
    }
}
