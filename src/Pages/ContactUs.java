package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactUs {

    private WebDriver wd;
    private WebDriverWait wait;


    @FindBy(xpath = "/html[1]/body[1]/div[2]/footer[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement contactUsLink;
    @FindBy(xpath = "//input[@id='input_3']")
    private WebElement nameField;
    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[1]/ul[1]/li[3]/div[1]/input[1]")
    private WebElement emailField;
    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[1]/ul[1]/li[4]/div[1]/input[1]")
    private WebElement contactNumberField;
    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[1]/ul[1]/li[5]/div[1]/textarea[1]")
    private WebElement messageField;
    @FindBy(tagName = "button")
    private WebElement submitBtn;
    @FindBy(xpath = "/html[1]/body[1]")
    private WebElement thankYoutext;


    public ContactUs(WebDriver webDriver, WebDriverWait wait) {
        this.wd = webDriver;
        this.wait = wait;
        PageFactory.initElements(webDriver, this);
    }


    public void inputNameInForm(String name) {

        wd.switchTo().frame(1);
        //identify element outside frame
        WebElement firstName = wd.findElement(By.name("q3_name"));
        wait = new WebDriverWait(wd, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q3_name")));
        firstName.sendKeys(name);
        firstName.sendKeys(Keys.ENTER);
    }

    public void inputEmailInForm(String email) {
        emailField.sendKeys(email);
    }

    public void inputContactNumberInForm(long number) {
        contactNumberField.sendKeys(String.valueOf(number));
    }

    public void inputMessageFieldInForm(String message) {
        messageField.sendKeys(message);
    }

    public void clickRecaptchaBtn() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/section[1]/div[1]/div[1]/div[1]/iframe[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-anchor"))).click();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='222202192597454']")));
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//body/form[@id='222202192597454']/div[1]/ul[1]/li[6]/div[1]/section[1]/div[1]/div[1]/div[1]/iframe[1]"))).click();

    }

    public String getModalThankYou() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]")));
        return thankYoutext.getText();
    }

}
