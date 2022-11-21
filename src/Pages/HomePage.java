package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement signInBtnHome;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement createAccbutton;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/a[1]/span[2]")
    private WebElement menBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[1]/a[1]/span[2]")
    private WebElement tops;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[1]/ul[1]/li[3]/a[1]/span[1]")
    private WebElement tees;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/footer[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement contactUsLink;
    @FindBy(linkText = "Write for Us")
    private WebElement writeForUsLink;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickSignInBtn(){
        signInBtnHome.click();
    }

    public void clickRegisterBtn () {
        createAccbutton.click();
    }

    public void hoverOnMenCategory(){
        Actions action = new Actions(webDriver);
        action.moveToElement(menBtn).perform();
    }

    public void hoverOnMenTops() {
        Actions action = new Actions(webDriver);
        action.moveToElement(tops).perform();
    }

    public void clickOnTees(){
        tees.click();
    }

    public void scrollToContactUs() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", contactUsLink);
        contactUsLink.click();
    }
    public void scrollToWriteForUs() {
        Actions skrol = new Actions(webDriver);
        skrol.moveToElement(writeForUsLink).click().perform();
    }
    public void callAddTeeToWishListAddToCart() {
        hoverOnMenCategory();
        hoverOnMenTops();
        clickOnTees();
    }

}
