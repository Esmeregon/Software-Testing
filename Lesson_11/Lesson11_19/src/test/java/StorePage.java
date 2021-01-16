import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StorePage {

    public WebDriver driver;
    public WebDriverWait wait;

//Подтягиваем драйвер
    public StorePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы главной страницы учебного приложения
    private final By mostPopularCategories = By.xpath("//h3[contains(text(), 'Most Popular')]");
    private final By product = By.xpath("//div[@class = 'image-wrapper']");
    private final By productCount = By.xpath("//span[@class= 'quantity']");

//Заходим в учебное приложение
    public void goToLitecart(){
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(mostPopularCategories));
    }

//Добавление продуктов в корзину
    public void productSelection(){
        ProductPage productPage = new ProductPage(driver);
        for (int item = 0; item < 3; item++){
            driver.findElement(product).click();
            productPage.addingProducts();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(productCount, ""+(item + 1)));
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(mostPopularCategories));
        }
    }

}
