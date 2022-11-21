package Pages;

import Helpers.Strings_Pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProceedToCheckOut {

    private WebDriver webDriver;
    private Faker faker;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/button[1]")
    private WebElement checkOutBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private WebElement emailAcc;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[1]/div[1]/input[1]")
    private WebElement fistNameAccount;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[2]/div[1]/input[1]")
    private WebElement lastNameAcc;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement addressAcc;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[4]/div[1]/input[1]")
    private WebElement cityAcc;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[7]/div[1]/input[1]")
    private WebElement postalCode;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[9]/div[1]/input[1]")
    private WebElement phoneNumber;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[8]/div[1]/select[1]")
    private WebElement countryAcc;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]/span[1]")
    private WebElement nextBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
    private WebElement shippingMethod;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[2]/div[1]/div[8]/div[1]/select[1]")
    private WebElement stateCountry;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]/span[1]")
    private WebElement placeOrder;
    @FindBy(linkText = "Zoltan Gym Tee")
    private WebElement zoltanTeeLink;

    public ProceedToCheckOut(WebDriver webDriver, Faker faker){
        this.webDriver = webDriver;
        this.faker = faker;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickOnCheckOut(){
        checkOutBtn.click();
    }
    public void inputEmailForAccount(String email){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")));
        emailAcc.sendKeys(email);
    }
    public void inputfirstNameAcc(String firstName) {
        fistNameAccount.sendKeys(firstName);
    }
    public void inputLastNameAcc(String lastName){
        lastNameAcc.sendKeys(lastName);
    }
    public void inputstreetAddressAcc(String address){addressAcc.sendKeys(address);
    }
    public void inputCityAcc(String city) {
        cityAcc.sendKeys(city);
    }

    public void inputZipCode(int zip){
        postalCode.sendKeys(String.valueOf(zip));
    }
    public void inputPhoneNumber (int phone) {
        phoneNumber.sendKeys(String.valueOf(phone));
    }
    public void clickOnShippingMethod(){
        shippingMethod.click();
    }

    public void clickOnCountry(){
        Actions action = new Actions(webDriver);
        action.moveToElement(countryAcc).perform();
        countryAcc.click();
    }
    public void selectCountry(){
        Select country = new Select(stateCountry);
        country.selectByVisibleText("Serbia");
    }
    public void clickOnNext(){
        nextBtn.click();
    }
    public String getModalPaymentMethod () {
        WebElement paymentText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_HEADER_PAYMENT_METOD_XPATH));
        return paymentText.getText();
    }
    public void clickOnTheBtnPlaceOrder () {
        placeOrder.click();
    }
    public boolean getModalThankYouHeader() {
        WebElement thankYouText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_HEADER_THANK_YOU_XPATH));
        String potvrda = thankYouText.getText();
        if (potvrda.equals("Thank you for your purchase!")){
            return true;
        }
        return false;
    }
    public void callInputAllInformationsInCheckOut () throws InterruptedException {

        inputEmailForAccount(faker.internet().emailAddress());
        inputfirstNameAcc(faker.name().firstName());
        inputLastNameAcc(faker.name().lastName());
        inputstreetAddressAcc(faker.address().fullAddress());
        inputCityAcc("Beograd");
        inputZipCode(11070);
        inputPhoneNumber(012457442);
        clickOnShippingMethod();
        Thread.sleep(2000);
        clickOnCountry();
        selectCountry();
        clickOnNext();
    }
    public String getAttributeHrefZoltanTee() {
        return zoltanTeeLink.getAttribute("href");
    }
    public boolean getModalButtonProceedToCheckOut() {
        WebElement actualText = webDriver.findElement(By.id(Strings_Pages.PROCEED_TO_CHECKOUT_BUTTON_ID));
        return actualText.isDisplayed();
    }
}
