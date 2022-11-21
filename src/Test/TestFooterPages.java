package Test;

import Helpers.Strings_Test;
import Pages.ContactUs;
import Pages.HomePage;
import Pages.WriteForUs;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestFooterPages {

    private WebDriver webDriver;
    private ContactUs contactUs;
    private HomePage homePage;
    private WriteForUs writeForUs;
    private Faker faker;

    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        writeForUs = new WriteForUs(webDriver);
        homePage = new HomePage(webDriver);
        contactUs = new ContactUs(webDriver,new WebDriverWait(webDriver,20));
        faker = new Faker();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to("https://magento.softwaretestingboard.com/");

    }

    @Test
    public void testFormContactUs () throws InterruptedException {

        homePage.scrollToContactUs();
        contactUs.inputNameInForm("Marko");
        contactUs.inputEmailInForm(faker.internet().safeEmailAddress());
        contactUs.inputContactNumberInForm(337345682);
        contactUs.inputMessageFieldInForm("This is Contact Page");
        contactUs.clickRecaptchaBtn();
        //It's needed to manually add captcha
        contactUs.clickSubmitButton();
        Assert.assertTrue(contactUs.getModalThankYou().contains("Thank You!"), "Text should be the same");
    }
    @Test
    public void testFormWriteForUs() throws InterruptedException {

        homePage.scrollToWriteForUs();
        Thread.sleep(3000);
        writeForUs.scrollToForm();
        writeForUs.inputFirstName("Petar");
        writeForUs.inputLastName("Markovic");
        writeForUs.inputMail("test@test.com");
        writeForUs.inputLink();
        writeForUs.uploadDocument(Strings_Test.FILE_PATH);
        writeForUs.uploadImage(Strings_Test.FILE_PATH_IMAGE);
        writeForUs.inputTextBio(Strings_Test.AUTHOR_BIO_TEXT);
        writeForUs.uploadAuthorBioPhoto(Strings_Test.AUTHOR_BIO_PHOTO);
        writeForUs.scrollToSubmitBtn();
        writeForUs.inputTagsORLabels("Selenium, Java OOP, Java Basics","Automation Testing, Manual Testing");
        writeForUs.clickOnLink();
        writeForUs.clickRecaptha();
        Thread.sleep(5000);
        writeForUs.clickOnSubmitBtn();

    }
}
