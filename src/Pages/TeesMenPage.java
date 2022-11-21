package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class TeesMenPage {

    private WebDriver webDriver;


    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/strong[2]")
    private WebElement listBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]")
    private WebElement sortByBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
    private WebElement styleBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]")
    private WebElement sizeBtnTee;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]")
    private WebElement priceBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]")
    private WebElement colorBtnTee;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]")
    private WebElement materialBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[6]/div[1]")
    private WebElement ecoCollectionBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]")
    private WebElement performanceFabric;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[8]/div[1]")
    private WebElement erinRecBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[9]/div[1]")
    private WebElement newBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[10]/div[1]")
    private WebElement saleBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[11]/div[1]")
    private WebElement patternBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[12]/div[1]")
    private WebElement climateBtn;
    public TeesMenPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickOnListBtn() {
      listBtn.click();
    }
    public void clickOnSortByBtn() {
        sortByBtn.click();
    }
    public void selectProductName() {
        Select prodName = new Select(sortByBtn);
        prodName.selectByVisibleText("Product Name");

    }
    public void selectPrice() {
        Select price = new Select(sortByBtn);
        price.selectByVisibleText("Price");
    }
    public void clickOnStyleBtn() {
        styleBtn.click();
    }
    public void clickOnSizeBtn() {
        sizeBtnTee.click();
    }
    public void clickOnPriceBtn() {
        priceBtn.click();
    }
    public void clickOnColorBtn() {
        colorBtnTee.click();
    }
    public void clickOnMaterialBtn() {
        materialBtn.click();
    }
    public void clickOnEcoCollectionBtn() {
        ecoCollectionBtn.click();
    }
    public void clickOnPerformanceFabricBtn() {
        performanceFabric.click();
    }
    public void clickOnSaleBtn() {
        saleBtn.click();
    }
    public void clickOnErinRecomnends() {
        erinRecBtn.click();
    }
    public void clickOnNewBtn() {
        newBtn.click();
    }
    public void clickOnPatternBtn() {
        patternBtn.click();
    }
    public void clickOnClimateBtn() {
        climateBtn.click();
    }
}
