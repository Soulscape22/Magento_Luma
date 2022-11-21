package Pages;

import Helpers.Strings_Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewProductPage {

    private WebDriver webDriver;

    private Actions action;

    private WebDriverWait wdwait;


    @FindBy(id = "tab-label-additional-title")
    private WebElement moreInformation;
    @FindBy(id = "tab-label-reviews-title")
    private WebElement reviewsBtn;
    @FindBy(id = "Rating_1_label")
    private WebElement oneStar;
    @FindBy(id = "Rating_2_label")
    private WebElement twoStars;
    @FindBy(id = "Rating_3_label")
    private WebElement threeStars;
    @FindBy(id = "Rating_4_label")
    private WebElement fourStars;
    @FindBy(id = "Rating_5_label")
    private WebElement fiveStars;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[1]/div[6]/div[2]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private WebElement nickName;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[1]/div[6]/div[2]/div[2]/form[1]/fieldset[1]/div[2]/div[1]/input[1]")
    private WebElement summary;
    @FindBy(id = "review_field")
    private WebElement review;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[1]/div[6]/div[2]/div[2]/form[1]/div[1]/div[1]/button[1]/span[1]")
    private WebElement submit;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[1]/div[5]/div[1]/a[2]/span[1]")
    private WebElement compareBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[1]/div[5]/div[1]/a[1]/span[1]")
    private WebElement wishListBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[2]/div[1]/input[1]")
    private WebElement emailLogInReview;
    @FindBy(css = "#pass")
    private WebElement paswordLogInReview;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")
    private WebElement signInBtnReview;


    public ReviewProductPage(WebDriver webDriver, Actions action, WebDriverWait wdwait) {
        this.webDriver = webDriver;
        this.action = action;
        this.wdwait = wdwait;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickOnMoreInformationTab() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", moreInformation);
        moreInformation.click();
    }
    public void clickOnReviewsTab(){
        reviewsBtn.click();
    }
    public void clickOnOneStar() {
       action.click(oneStar).perform();
    }
    public void clickOnTwoStars() {
       action.click(twoStars).perform();
    }
    public void clickOnThreeStars() {
        action.click(threeStars).perform();
    }
    public void clickOnFourStars() {
        action.click(fourStars).perform();
    }
    public void clickOnFiveStars() {
        action.click(fiveStars).perform();
    }
    public void inputNickName(String nick) {
        nickName.sendKeys(nick);
    }
    public void inputSummary(String summaryField) {
        summary.sendKeys(summaryField);
    }
    public void inputReview(String reviewField) {
        review.sendKeys(reviewField);
    }
    public void clickSubmit(){
        action.click(submit).perform();
    }

    public String getModalReviewTitle(){
        WebElement reviewTitle;
        reviewTitle = wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings_Pages.MODAL_AFTER_REVIEW_TITLE_XPATH)));
        return reviewTitle.getText();
    }
    public void clickCompareList() {
        compareBtn.click();
    }
    public String getCompareListLink(){
        WebElement linkText = webDriver.findElement(By.xpath(Strings_Pages.COMPARE_LIST_LINK_XPATH));
        return linkText.getAttribute("href");
    }
    public void clickWishListBtn () {
        wishListBtn.click();
    }
    public void inputEmailLogIn(String email) {
        emailLogInReview.sendKeys(email);
    }
    public void inputPassLogIn (String pass) {
        paswordLogInReview.sendKeys(pass);
    }
    public  void clickSignInBtn () {
        signInBtnReview.click();
    }

    public String getWishListHeader() {
        WebElement wishListText  = wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Strings_Pages.WISH_LIST_CONFIRMED_XPATH)));
        return wishListText.getText();
    }
}
