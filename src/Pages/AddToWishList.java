package Pages;

import Helpers.Strings_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToWishList {

    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[6]/div[1]/div[1]/div[4]/div[1]/div[2]/a[1]")
    private WebElement addToWishListBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[11]/div[1]/a[1]/span[1]/span[1]/img[1]")
    private WebElement image;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[11]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]")
    private WebElement sizeWish;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[11]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]")
    private WebElement colorWish;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[11]/div[1]/div[1]/div[4]/div[1]/div[2]/a[1]")
    private WebElement assToWishListBtn2;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[3]/div[3]/div[2]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/a[1]")
    private WebElement removeBtn;
    public AddToWishList(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

   public void clickToWishListBtn(){
        addToWishListBtn.click();
   }
   public String getModalTitleWishList() {
        WebElement visiableText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_ADDED_TO_WISH_LIST_XPATH));
        return visiableText.getText();
   }
   public void clickBack() {
      webDriver.navigate().back();
   }
   public void scrollDown() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", image);
   }
   public void clickSizeNColor(){
       sizeWish.click();
       colorWish.click();
       assToWishListBtn2.click();
   }
   public String getMessageContinueShopping(){
       WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings_Pages.MESSAGE_CONTINUE_SHOPPING_XPATH)));
        WebElement visiableText = webDriver.findElement(By.xpath(Strings_Pages.MESSAGE_CONTINUE_SHOPPING_XPATH));
        return visiableText.getText();
   }
   public void callAddToWishList() {
       clickToWishListBtn();
       clickBack();
       scrollDown();
       clickSizeNColor();
   }
   public void clickRemoveFromWishListBtn() {

       JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
       javascriptExecutor.executeScript("window.scrollBy(0, 1000)");
       WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
       wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
   }
   public boolean getModalRemovedFromWishlist(){
       WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings_Pages.MODAL_REMOVED_FROM_WISHLIST_XPATH)));
        WebElement actualText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_REMOVED_FROM_WISHLIST_XPATH));
        if (actualText.equals("Zoltan Gym Tee has been removed from your Wish List.")){
            return true;
        }
        return false;
   }
   public String getModalRemoved() {
       WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings_Pages.MODAL_REMOVED_FROM_WISHLIST_XPATH)));
       WebElement actualText = webDriver.findElement(By.xpath(Strings_Pages.MODAL_REMOVED_FROM_WISHLIST_XPATH));
       return actualText.getText();
   }
}
