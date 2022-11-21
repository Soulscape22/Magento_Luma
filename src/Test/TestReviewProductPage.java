package Test;

import Helpers.Strings_Test;
import Pages.ReviewProductPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestReviewProductPage {

    private WebDriver webDriver;
    private Faker faker;
    ReviewProductPage reviewProductPage;
    WebDriverWait wdwait;


    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        faker = new Faker();
        wdwait = new WebDriverWait(webDriver, 20);
        reviewProductPage = new ReviewProductPage(webDriver, new Actions(webDriver), wdwait);
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://magento.softwaretestingboard.com/zoltan-gym-tee.html");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testClickReviewStarsAndFillInFields () {

        reviewProductPage.clickOnMoreInformationTab();
        reviewProductPage.clickOnReviewsTab();
        reviewProductPage.clickOnOneStar();
        reviewProductPage.clickOnTwoStars();
        reviewProductPage.clickOnThreeStars();
        reviewProductPage.clickOnFourStars();
        reviewProductPage.clickOnFiveStars();
        //Fill in review fields and submit review
        reviewProductPage.clickOnReviewsTab();
        reviewProductPage.inputNickName(faker.starTrek().character());
        reviewProductPage.inputSummary("Very comfortable tee");
        reviewProductPage.inputReview("Excellent");
        reviewProductPage.clickSubmit();
        Assert.assertEquals(reviewProductPage.getModalReviewTitle(), Strings_Test.MODAL_REVIEW_TEXT, "The text should be the same");
    }

    @Test
    public void testAddToCompareListAndWishList () throws InterruptedException {

        reviewProductPage.clickCompareList();
        Thread.sleep(2000);
        //Validation of added product to Compare List
        Assert.assertEquals(reviewProductPage.getCompareListLink(), Strings_Test.COMPARE_LIST_LINK, "Link should be the same");
        reviewProductPage.clickWishListBtn();
        reviewProductPage.inputEmailLogIn("pmarkovic287@gmail.com");
        reviewProductPage.inputPassLogIn("Huge2222");
        reviewProductPage.clickSignInBtn();
        //Validation of added product in Wish List
        Assert.assertTrue(reviewProductPage.getWishListHeader().contains(Strings_Test.WISH_LIST_CONFIRMATION_TEXT));

    }
}
