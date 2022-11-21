package Test;

import Helpers.Strings_Test;
import Pages.AddToCart;
import Pages.HomePage;
import Pages.ProceedToCheckOut;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAddToCart {

    private WebDriver webDriver;
    private AddToCart addToCart;
    private HomePage homePage;
    private ProceedToCheckOut proceedToCheckOut;
    private Faker faker;


    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        addToCart = new AddToCart(webDriver);
        homePage = new HomePage(webDriver);
        faker = new Faker();
        proceedToCheckOut = new ProceedToCheckOut(webDriver,faker);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to(Strings_Test.URL);
    }

    @Test
    public void testAddToCart() throws InterruptedException {

        homePage.callAddTeeToWishListAddToCart();
        addToCart.callClickOnTeeAttributes();
        addToCart.clickAddToCart();
        Thread.sleep(5000);
        addToCart.clickViewCart();
        Thread.sleep(5000);
        Assert.assertEquals(addToCart.getImage(), Strings_Test.LINK_URL_VIEW_CART_TEE, "The end of Url shoud be 'ms06-blue_main_1.jpg'");
    }

    @Test
    public void testProceedToCheckOut() throws InterruptedException {


        homePage.callAddTeeToWishListAddToCart();
        addToCart.callClickOnTeeAttributes();
        addToCart.clickAddToCart();
        Thread.sleep(5000);
        addToCart.clickViewCart();
        Thread.sleep(5000);
        proceedToCheckOut.clickOnCheckOut();
        //Create Account or Sign In
        Thread.sleep(5000);
        proceedToCheckOut.callInputAllInformationsInCheckOut();
        //After registration assert aiming page Payment Method
        Assert.assertEquals(proceedToCheckOut.getModalPaymentMethod(), Strings_Test.MODAL_PAYMENT_TEXT, "The text should be the same");
        Thread.sleep(5000);
        proceedToCheckOut.clickOnTheBtnPlaceOrder();
        //At the end asserting Thank you page
        Thread.sleep(3000);
        Assert.assertTrue(proceedToCheckOut.getModalThankYouHeader(), "The message should be true");
    }

    @Test
    public void testDeleteItemFromCart() throws InterruptedException {

        homePage.callAddTeeToWishListAddToCart();
        addToCart.callClickOnTeeAttributes();
        addToCart.clickAddToCart();
        Thread.sleep(5000);
        addToCart.clickViewCart();
        addToCart.clickButtonDeleteFromCart();
        addToCart.clickOnALertBtnOk();
        Thread.sleep(3000);
        Assert.assertEquals(addToCart.getMessageEmptyCart(), Strings_Test.MESSAGE_EMPTY_CART_TEXT);
    }
    @Test
    public void testCancelDeleteItemFromCart() throws InterruptedException {

        homePage.callAddTeeToWishListAddToCart();
        addToCart.callClickOnTeeAttributes();
        addToCart.clickAddToCart();
        Thread.sleep(5000);
        addToCart.clickViewCart();
        addToCart.clickButtonDeleteFromCart();
        addToCart.clickOnAlertBtnCancel();
        Assert.assertEquals(addToCart.getImage(), Strings_Test.LINK_URL_VIEW_CART_TEE, "The end of Url shoud be 'ms06-blue_main_1.jpg'");
    }
    @Test
    public void testAddMultipleItemsToCart() throws InterruptedException {

        homePage.callAddTeeToWishListAddToCart();
        addToCart.callAddToCartLogan();
        addToCart.callClickOnTeeAttributes();
        addToCart.clickAddToCart();
        addToCart.callAddToCartHelios();
        Thread.sleep(3000);
        addToCart.clickViewCart();
        Assert.assertEquals(proceedToCheckOut.getAttributeHrefZoltanTee(), Strings_Test.LINK_ZOLTAN_TEE);
        Assert.assertTrue(proceedToCheckOut.getModalButtonProceedToCheckOut(), "The boolean should be true");
    }
    @Test
    public void testChangeQuantityInCart() throws InterruptedException {

        homePage.callAddTeeToWishListAddToCart();
        addToCart.callAddToCartLogan();
        addToCart.callClickOnTeeAttributes();
        addToCart.clickAddToCart();
        addToCart.callAddToCartHelios();
        Thread.sleep(3000);
        addToCart.clickViewCart();
        addToCart.updateQuantity(Strings_Test.number);
    }
    @Test
    public void testEditCart() throws InterruptedException {
        homePage.callAddTeeToWishListAddToCart();
        addToCart.callAddToCartLogan();
        addToCart.callClickOnTeeAttributes();
        addToCart.clickAddToCart();
        addToCart.callAddToCartHelios();
        Thread.sleep(3000);
        addToCart.clickViewCart();
        addToCart.clickViewEditCart();
        addToCart.updateQuantityCart(Strings_Test.number);
        addToCart.updateShoppingCart();
    }
}