import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckCart {

    public WebDriver driver;
    public WebDriverWait wait;

//Подтягиваем драйвер
    public CheckCart(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы главной страницы учебного приложения
    private final By mostPopularCategories = By.xpath("//h3[contains(text(), 'Most Popular')]");
    private final By product = By.xpath("//div[@class = 'image-wrapper']");
    private final By checkoutButton = By.linkText("Checkout »");
//Селекторы страницы продукта
    private final By addToCartButton = By.xpath("//button[@name= 'add_cart_product']");
    private final By productCount = By.xpath("//span[@class= 'quantity']");
    private final By optionsMenu = By.xpath("//select[@name='options[Size]']");
//Селекторы корзины
    private final By removeButton = By.xpath("//button[@name= 'remove_cart_item']");
    private final By emptyCartMessage = By.xpath("//em");
    private final By products = By.xpath("//li[@class='shortcut']");

//Заходим в учебное приложение
    public void goToLitecart(){
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(mostPopularCategories));
    }

//Добавление продуктов в корзину
    public void addingProducts(){
        for (int item = 0; item < 3; item++){
            driver.findElement(product).click();
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            if (driver.findElement(By.tagName("h1")).getText().contains("Yellow Duck")){
                ((JavascriptExecutor)driver).executeScript("arguments[0].selectedIndex = 1; arguments[0].dispatchEvent(new Event('change'))" , driver.findElement(optionsMenu));
            }
            driver.findElement(addToCartButton).click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(productCount, ""+(item + 1)));
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(mostPopularCategories));
        }
    }

//Переходим в корзину
    public void goToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }

//Удаление продуктов из корзины
    public void productRemoval(){
        while (driver.findElements(products).size() > 0){
            wait.until(ExpectedConditions.elementToBeClickable(removeButton));
            driver.findElement(removeButton).click();
        }
        Assert.assertEquals("There are no items in your cart.", driver.findElement(emptyCartMessage).getText());
    }

}
