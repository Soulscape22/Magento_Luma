package Test;

import Helpers.Strings_Test;
import Pages.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAddToWishList {

    private WebDriver webDriver;
    private AddToCart addToCart;
    private HomePage homePage;
    private AddToWishList wishList;
    private LogIn logIn;
    Faker faker;


    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        addToCart = new AddToCart(webDriver);
        homePage = new HomePage(webDriver);
        wishList = new AddToWishList(webDriver);
        logIn = new LogIn(webDriver);
        faker = new Faker();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to(Strings_Test.URL);
    }

    @Test
    public void testAddToWishList() {

        logIn.callLogIn();
        homePage.callAddTeeToWishListAddToCart();
        addToCart.callClickOnTeeAttributes();
        wishList.clickToWishListBtn();
        Assert.assertTrue(wishList.getModalTitleWishList().contains("Wish List"));
    }

    @Test
    public void testAddTwoProductsToWishList(){

        logIn.callLogIn();
        homePage.callAddTeeToWishListAddToCart();
        addToCart.callClickOnTeeAttributes();
        wishList.clickToWishListBtn();
        wishList.clickBack();
        wishList.scrollDown();
        wishList.clickSizeNColor();
        Assert.assertTrue(wishList.getMessageContinueShopping().contains("has been added"));
    }

    @Test
    public void testRemoveFromWishList(){

        logIn.callLogIn();
        homePage.callAddTeeToWishListAddToCart();
        addToCart.callClickOnTeeAttributes();
        wishList.clickToWishListBtn();
        wishList.clickRemoveFromWishListBtn();
        Assert.assertEquals(wishList.getModalRemoved(), "Zoltan Gym Tee has been removed from your Wish List.");
        Assert.assertTrue(wishList.getModalRemovedFromWishlist());
    }
}