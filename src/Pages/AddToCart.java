package Pages;


import Helpers.Strings_Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart {

    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[6]/div[1]/a[1]/span[1]/span[1]/img[1]")
    private WebElement blueTee;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[6]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]")
    private WebElement sizeCart;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[6]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]")
    private WebElement colorCart;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[6]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]")
    private WebElement addToCartBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[2]/a[1]")
    private WebElement deleteBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/a[1]")
    private WebElement viewCart;
    @FindBy(xpath = "/html[1]/body[1]/div[4]/aside[2]/div[2]/footer[1]/button[2]/span[1]")
    private WebElement alertBtnOk;
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement alertBtnCancel;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[11]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]")
    private WebElement sizeHelios;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[11]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]")
    private WebElement colorHeliosBlack;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[11]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]")
    private WebElement addToCartHelios;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]")
    private WebElement sizeBtnLogan;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]")
    private WebElement colorLogan;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[3]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]/span[1]")
    private WebElement addToCartLogan;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/input[1]")
    private WebElement quantity;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/button[1]/span[1]")
    private WebElement update;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/a[1]/span[1]")
    private WebElement viewEditCart;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]")
    private WebElement quantityEditCart;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/form[1]/div[2]/button[2]/span[1]")
    private WebElement updateShoppingCart;

    public AddToCart(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void hoverOnBlueTee() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", blueTee);
    }
    public void clickSize() {
        sizeCart.click();
    }
    public void clickColor() {
        colorCart.click();
    }

    public void clickAddToCart() {
        addToCartBtn.click();
    }
    public void clickViewCart() {
        viewCart.click();
    }
    public String getImage(){
        WebElement linkText = webDriver.findElement(By.xpath(Strings_Test.IMAGE_VIEW_CART));
        String actualText = linkText.getAttribute("src");
        return  actualText;
    }
    public void callClickOnTeeAttributes(){
        hoverOnBlueTee();
        clickSize();
        clickColor();
    }
    public void clickButtonDeleteFromCart () {
        deleteBtn.click();
    }
    public void clickOnALertBtnOk() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(alertBtnOk)).click();
    }
    public void clickOnAlertBtnCancel(){
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(alertBtnCancel)).click();
    }
    public String getMessageEmptyCart() {
        WebElement actualText = webDriver.findElement(By.xpath(Strings_Test.MESSAGE_NO_ITEMS_IN_SHOPPING_CART_XPATH));
        return actualText.getText();
    }
    public void clickOnSizeLogan() {
        sizeBtnLogan.click();
    }
    public void clickOnColorLogan(){
        colorLogan.click();
    }
    public void clickAddToCartLogan(){
        addToCartLogan.click();
    }
    public void callAddToCartLogan(){
        clickOnSizeLogan();
        clickOnColorLogan();
        clickAddToCartLogan();
    }
    public void clickOnSizeHelios(){
        sizeHelios.click();
    }
    public void clickOnColorHelios(){
        colorHeliosBlack.click();
    }
    public void clickAddToCartBtnHelios(){
        addToCartHelios.click();
    }
    public void callAddToCartHelios(){
        clickOnSizeHelios();
        clickOnColorHelios();
        clickAddToCartBtnHelios();
    }
    public void clickViewEditCart(){
        viewEditCart.click();
    }
    public void updateQuantityCart(String number){
        quantityEditCart.clear();
        quantityEditCart.sendKeys(Keys.chord(Keys.CONTROL, "a"), number);
    }

    public void updateQuantity(String number) {
        quantity.clear();
        quantity.sendKeys(Keys.chord(Keys.CONTROL, "a"), number);
        update.click();
    }
    public void updateShoppingCart(){
        updateShoppingCart.click();
    }
}
