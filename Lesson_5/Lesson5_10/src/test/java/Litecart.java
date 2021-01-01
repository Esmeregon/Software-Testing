import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Litecart extends SeleniumSettings{

    public WebDriver driver;
    public WebDriverWait wait;

//Подтягиваем драйвер
    public Litecart(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы
    @FindBy(xpath = "//h3[contains(text(), 'Most Popular')]")
    WebElement mostPopularCategories;

    private final By campaignProductTitle = By.xpath("//a[@title='Yellow Duck']");
    private final By productPageTitle = By.xpath("//h1");

    private final By campaignProductRegularPrice = By.xpath("//a[@title='Yellow Duck']/div[@class= 'price-wrapper']/s[@class ='regular-price']");
    private final By campaignProductCampaignPrice = By.xpath("//a[@title='Yellow Duck']/div[@class= 'price-wrapper']/strong[@class ='campaign-price']");

    private final By productRegularPrice = By.xpath("//s[@class = 'regular-price']");
    private final By productCampaignPrice = By.xpath("//strong[@class = 'campaign-price']");


//Переходим в учебное приложение LiteCart
    public void  goToLitecart(){
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOf(mostPopularCategories));
    }

//Метод, проверяющий, что на главной странице и на странице товара совпадает текст названия товара
    public void comparisonOfProductNames(){
        String mainPageName = driver.findElement(campaignProductTitle).getAttribute("title");
        driver.findElement(campaignProductTitle).click();
        String productPageName = driver.findElement(productPageTitle).getText();
        Assert.assertEquals(mainPageName, productPageName);
    }

//Метод, проверяющий, что на главной странице и на странице товара совпадают цены (обычная и акционная)
    public void productPriceComparison(){
        String mainPageRegularPrice = driver.findElement(campaignProductRegularPrice).getText();
        String mainPageCampaignPrice = driver.findElement(campaignProductCampaignPrice).getText();
        String productPageRegularPrice = driver.findElement(productRegularPrice).getText();
        String productPageCampaignPrice = driver.findElement(productCampaignPrice).getText();
        Assert.assertEquals(mainPageRegularPrice, productPageRegularPrice);
        Assert.assertEquals(mainPageCampaignPrice, productPageCampaignPrice);
    }

//Метод, проверяющий, что обычная цена зачёркнутая и серая
    public void regularPriceCheck(){
        String mainPageRegularPriceColor = driver.findElement(campaignProductRegularPrice).getCssValue("color");
        String productPageRegularPriceColor = driver.findElement(productRegularPrice).getCssValue("color");
        String mainPageRegularPriceDecoration = driver.findElement(campaignProductRegularPrice).getCssValue("text-decoration-line");
        String productPageRegularPriceDecoration = driver.findElement(campaignProductRegularPrice).getCssValue("text-decoration-line");
        Assert.assertTrue(getRedColor(mainPageRegularPriceColor) == getGreenColor(mainPageRegularPriceColor) && getGreenColor(mainPageRegularPriceColor) == getBlueColor(mainPageRegularPriceColor));
        Assert.assertTrue(getRedColor(productPageRegularPriceColor) == getGreenColor(productPageRegularPriceColor) && getGreenColor(productPageRegularPriceColor) == getBlueColor(productPageRegularPriceColor));
        Assert.assertEquals("line-through", mainPageRegularPriceDecoration);
        Assert.assertEquals("line-through", productPageRegularPriceDecoration);
    }

//Метод, проверяющий, что акционная жирная и красная
    public void campaignPriceCheck(){
        String mainPageRegularPriceColor = driver.findElement(campaignProductCampaignPrice).getCssValue("color");
        String productPageRegularPriceColor = driver.findElement(productCampaignPrice).getCssValue("color");
        String mainPageCampaignPriceDecoration = driver.findElement(campaignProductCampaignPrice).getTagName();
        String productPageCampaignPriceDecoration = driver.findElement(productCampaignPrice).getTagName();
        Assert.assertTrue((getGreenColor(mainPageRegularPriceColor) == 0) && (getBlueColor(mainPageRegularPriceColor) == 0));
        Assert.assertTrue((getGreenColor(productPageRegularPriceColor) == 0) && (getBlueColor(productPageRegularPriceColor) == 0));
        Assert.assertEquals("strong", mainPageCampaignPriceDecoration);
        Assert.assertEquals("strong", productPageCampaignPriceDecoration);
    }

//Метод, проверяющий, что акционная цена крупнее, чем обычная
    public void priceComparison(){
        double campaignProductRegularPriceSize = Double.parseDouble(driver.findElement(campaignProductRegularPrice).getCssValue("font-size").substring(0, 2));
        double campaignProductCampaignPriceSize = Double.parseDouble(driver.findElement(campaignProductCampaignPrice).getCssValue("font-size").substring(0, 2));
        double productRegularPriceSize = Double.parseDouble(driver.findElement(productRegularPrice).getCssValue("font-size").substring(0, 2));
        double productCampaignPriceSize = Double.parseDouble(driver.findElement(productCampaignPrice).getCssValue("font-size").substring(0, 2));
        Assert.assertTrue(campaignProductRegularPriceSize < campaignProductCampaignPriceSize);
        Assert.assertTrue(productRegularPriceSize < productCampaignPriceSize);
    }

//Парсер цветов из RGB
    public int getRedColor(String color){
        return Integer.parseInt(String.valueOf(Color.fromString(color).getColor().getRed()));
    }

    public int getGreenColor(String color){
        return Integer.parseInt(String.valueOf(Color.fromString(color).getColor().getGreen()));
    }

    public int getBlueColor(String color){
        return Integer.parseInt(String.valueOf(Color.fromString(color).getColor().getBlue()));
    }


}
