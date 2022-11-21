package Test;

import Helpers.Strings_Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

public class TestHomePage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(20));
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to("https://magento.softwaretestingboard.com/");

    }

    @Test
    public void testGetURLExample() {

        webDriver.get(Strings_Test.URL);
        //Check title is correct
        Assert.assertEquals(webDriver.getTitle(), "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }
    @Test
    public void testBackForwardRefreshExample() {

        webDriver.navigate().to(Strings_Test.URL);
        wait.until(driver -> driver.getTitle().contentEquals("Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"));
        Assert.assertEquals(webDriver.getTitle(), "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        webDriver.navigate().to(Strings_Test.URL2);
        wait.until(driver -> driver.getTitle().contentEquals("What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"));
        Assert.assertEquals(webDriver.getTitle(), "What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        //Navigate Back
        webDriver.navigate().back();
        wait.until(driver -> driver.getTitle().contentEquals("Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"));
        //Check title is correct
        Assert.assertEquals(webDriver.getTitle(), "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        //Navigate Forward
        webDriver.navigate().forward();
        wait.until(driver -> driver.getTitle().contentEquals("What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"));
        Assert.assertEquals(webDriver.getTitle(), "What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        //Refresh The Page
        webDriver.navigate().refresh();
        wait.until(driver -> driver.getTitle().contentEquals("What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"));
        Assert.assertEquals(webDriver.getTitle(), "What's New Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
    }

}
