package Pages;


import Helpers.Strings_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registracija {

    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private WebElement firstName;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[1]/div[2]/div[1]/input[1]")
    private WebElement lastName;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]")
    private WebElement emailReg;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[2]/div[2]/div[1]/input[1]")
    private WebElement passwordReg;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[2]/div[3]/div[1]/input[1]")
    private WebElement confirmPassword;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]")
    private WebElement createAcc;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")
    private WebElement welcomeBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement signOutBtn;
    public Registracija(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }


    public void inputName (String nameReg) {
        firstName.sendKeys(nameReg);
    }
    public void inputLastName (String lastNameReg) {
        lastName.sendKeys(lastNameReg);
    }
    public void inputEmail (String regEmail){
        emailReg.sendKeys(regEmail);
    }
    public void inputPassword (String password){
        passwordReg.sendKeys(password);
    }
    public void inputConfirmPassword (String password2) {
        confirmPassword.sendKeys(password2);
    }
    public void clickCreateAccount(){
        createAcc.click();
    }
    public String getModalRegistracija() {
        WebElement text = webDriver.findElement(By.xpath(Strings_Pages.MODAL_KOD_XPATH));
        return text.getText();
    }

    public String getModalFirstName(){
        WebElement actualText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_FIRST_NAME_ALERT_ID));
        return actualText.getText();
    }

    public String getModalLastName() {
        WebElement actualText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_LAST_NAME_ALERT_ID));
        return actualText.getText();
    }

    public String getModalPassword() {
        WebElement actualText = webDriver.findElement(By.id(Strings_Pages.MODAL_ALERT_PASSWROD_ID));
        return actualText.getText();
    }
    public String getModalErrorTextName() {
        WebElement actualErrorText = webDriver.findElement(By.id(Strings_Pages.MODAL_FIRST_NAME_ALERT_ID));
        return actualErrorText.getText();
    }
    public String getModalErrorTextLastName() {
        WebElement actualErrorText = webDriver.findElement(By.id(Strings_Pages.MODAL_LAST_NAME_ALERT_ID));
        return actualErrorText.getText();
    }
    public String getModalErrorTextEmail() {
        WebElement actualErrorText = webDriver.findElement(By.id(Strings_Pages.MODAL_ERROR_EMAIL_ID));
        return actualErrorText.getText();
    }
    public String getModalErrorTextPass(){
        WebElement actualErrorText = webDriver.findElement(By.id(Strings_Pages.MODAL_ERROR_PASS_ID));
        return actualErrorText.getText();
    }
    public String getModalErrorTextConfirmPass(){
        WebElement actualErrorText = webDriver.findElement(By.id(Strings_Pages.MODAL_ERROR_CONFIRM_PASS_ID));
        return actualErrorText.getText();
    }
    public void clickWelcomeButton(){
        welcomeBtn.click();
    }
    public void clickSignOutButton() {
        signOutBtn.click();
    }
    public String getModalsIGNoUT() {
        String actualText = webDriver.getCurrentUrl();
        return actualText;
    }

}
