package Pages;

import Helpers.Strings_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {

    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement logInBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[2]/div[1]/input[1]")
    private WebElement emailLogIn;
    @FindBy(css = "#pass")
    private WebElement paswordLogIn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")
    private WebElement signInBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[5]/div[1]/button[1]/span[1]")
    private WebElement secondSignIn;
    public LogIn (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickLogIn () {
        logInBtn.click();
    }

    public void inputEmailLogIn(String email) {
        emailLogIn.sendKeys(email);
    }
    public void inputPassLogIn (String pass) {
        paswordLogIn.sendKeys(pass);
    }
    public  void clickSignInBtn () {
        signInBtn.click();
    }
    public void clickSecondSignIn(){
        secondSignIn.click();
    }

    public String getModalErrorText() {
       WebElement actualErrorText = webDriver.findElement(By.id(Strings_Pages.MODAL_ERROR_MESSAGE_ID));
       return actualErrorText.getText();
    }
    public String getModalErrorTitlePass() {
        WebElement actualErrorText = webDriver.findElement(By.id(Strings_Pages.MODAL_LOG_IN_ERROR_PASS_ID));
        return actualErrorText.getText();
    }
    public String getModalErrorBadInput(){
        WebElement actualErrorText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_ERROR_UPPERCASE_EMAIL_XPATH));
        return actualErrorText.getText();
    }
    public String getModalWelcome(){
        WebElement actualText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_WELCOME_XPATH));
        return actualText.getText();
    }
    public void callLogIn()  {

        clickLogIn();
        inputEmailLogIn("pmarkovic287@gmail.com");
        inputPassLogIn("Huge2222");
        //Manually input captcha
        clickSignInBtn();
    }

}
