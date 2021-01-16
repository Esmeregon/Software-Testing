import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {

    public WebDriver driver;
    public WebDriverWait wait;

//Подтягиваем драйвер
    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы корзины
    private final By removeButton = By.xpath("//button[@name= 'remove_cart_item']");
    private final By emptyCartMessage = By.xpath("//em");
    private final By products = By.xpath("//li[@class='shortcut']");
    private final By cartItems = By.xpath("//td[@class='item']");
    private final By itemName = By.xpath("//a/strong");
    private final By checkoutButton = By.linkText("Checkout »");

//Переходим в корзину
    public void goToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }

//Удаление продуктов из корзины
    public void productRemoval(){
        List<WebElement> removedItems = driver.findElements(cartItems);
        for (int i = 0; i < removedItems.size(); i++){
            if (removedItems.size() > 1){
                List<WebElement>items = driver.findElements(products);
                wait.until(ExpectedConditions.elementToBeClickable(products));
                items.get(0).click();
                wait.until(ExpectedConditions.elementToBeClickable(removeButton));
                driver.findElement(removeButton).click();
                wait.until(ExpectedConditions.stalenessOf(removedItems.get(0)));
                wait.until(ExpectedConditions.stalenessOf(items.get(0)));
                removedItems = driver.findElements(cartItems);
                driver.findElements(products);
                Assert.assertEquals(driver.findElement(itemName).getText(), removedItems.get(0).getText());
            }
            if (removedItems.size() == 1){
                wait.until(ExpectedConditions.elementToBeClickable(removeButton));
                driver.findElement(removeButton).click();
                Assert.assertEquals("There are no items in your cart.", driver.findElement(emptyCartMessage).getText());
            }
        }
    }
}
