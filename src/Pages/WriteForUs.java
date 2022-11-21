package Pages;

import Helpers.Strings_Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WriteForUs {

    private WebDriver webDriver;


    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/span[2]/input[1]")
    private WebElement lastName;
    @FindBy(id = "input_3")
    private WebElement email;
    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[1]/ul[1]/li[3]/div[1]/input[1]")
    private WebElement linkedLn;
    @FindBy(id = "input_14")
    private WebElement clickChooseFile;
    @FindBy(id = "input_16")
    private WebElement clickChooseImage;
    @FindBy(id = "input_6")
    private WebElement authorBio;
    @FindBy(id = "input_13")
    private WebElement clickAuthorBioPhoto;
    @FindBy(id = "input_11")
    private WebElement tags;
    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[1]/ul[1]/li[11]/div[1]/div[1]/button[1]")
    private WebElement submitBtn;

    public WriteForUs(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void scrollToForm() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("scroll(0,1200)", "");
    }

    public void inputFirstName(String name) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt
                (By.xpath("//iframe[@id='222202263308443']")));
        WebElement visibleAfter = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first_1']")));
        visibleAfter.sendKeys(name);
    }

    public void inputLastName(String name) {
        lastName.sendKeys(name);
    }

    public void inputMail(String mail) {
        email.sendKeys(mail);
    }

    public void inputLink() {
        linkedLn.sendKeys(Strings_Pages.LINKEDLN_LINK);
    }

    public void uploadDocument (String filePath) {

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click()", clickChooseFile);
        clickChooseFile.sendKeys(filePath);
    }
    public void uploadImage (String filePath) {

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click()", clickChooseImage);
        clickChooseImage.sendKeys(filePath);
    }
    public void inputTextBio(String text) {
        authorBio.sendKeys(text);
    }
    public void uploadAuthorBioPhoto(String filePath){
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click()", clickAuthorBioPhoto);
        clickAuthorBioPhoto.sendKeys(filePath);
    }
    public void inputTagsORLabels(String tag, String labels) {
        tags.sendKeys(tag, labels);
    }
    public void clickOnLink(){
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        webDriver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[9]/div[1]/div[1]/a[1]")).sendKeys(selectLinkOpeninNewTab);
    }
    public void scrollToSubmitBtn(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", submitBtn);
    }
    public void clickRecaptha(){

        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt
                (By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[10]/div[1]/section[1]/div[1]/div[1]/div[1]/iframe[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-anchor"))).click();
    }
    public void clickOnSubmitBtn(){
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(20));

        webDriver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt
                (By.xpath("/html/body/div/div/div/div[1]/main/article/div/iframe")));

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector(".button.main")));
        submit.click();
    }
}
