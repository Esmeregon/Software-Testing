import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    public WebDriver driver;
    public WebDriverWait wait;

//Подтягиваем драйвер
    public ProductPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы страницы продукта
    private final By addToCartButton = By.xpath("//button[@name= 'add_cart_product']");
    private final By optionsMenu = By.xpath("//select[@name='options[Size]']");


//Добавление продуктов в корзину
    public void addingProducts(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        if (driver.findElement(By.tagName("h1")).getText().contains("Yellow Duck")){
            ((JavascriptExecutor)driver).executeScript("arguments[0].selectedIndex = 1; arguments[0].dispatchEvent(new Event('change'))" , driver.findElement(optionsMenu));
        }
        driver.findElement(addToCartButton).click();
    }

}
