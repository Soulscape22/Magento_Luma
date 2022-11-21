package Test;

import Pages.TeesMenPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTeesMenPage {

    private WebDriver webDriver;
    private TeesMenPage teesMenPage;

    @BeforeMethod
    public void configure() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Win\\Desktop\\ITBootcamp\\Chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        teesMenPage = new TeesMenPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/tees-men.html");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testButtonsOnTeesMenPage () {

        teesMenPage.clickOnListBtn();
        teesMenPage.clickOnSortByBtn();
        teesMenPage.selectProductName();
        teesMenPage.selectPrice();
        teesMenPage.clickOnStyleBtn();
        teesMenPage.clickOnSizeBtn();
        teesMenPage.clickOnPriceBtn();
        teesMenPage.clickOnColorBtn();
        teesMenPage.clickOnMaterialBtn();
        teesMenPage.clickOnEcoCollectionBtn();
        teesMenPage.clickOnPerformanceFabricBtn();
        teesMenPage.clickOnErinRecomnends();
        teesMenPage.clickOnSaleBtn();
        teesMenPage.clickOnNewBtn();
        teesMenPage.clickOnPatternBtn();
        teesMenPage.clickOnClimateBtn();
    }
}
