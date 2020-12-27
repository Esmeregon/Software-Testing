import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StartPage extends SeleniumSettings {

    private final WebDriver driver;
    private final WebDriverWait wait;


//Подтягиваем драйвер
    public StartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Используемые селеторы
    @FindBy(xpath = "//h3[contains(text(), 'Most Popular')]")
    WebElement mostPopularCategories;

    private final By product = By.xpath("//div[@class='image-wrapper']");


//Заъодим на главную страницу litecart
    public void goToLitecart(){
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOf(mostPopularCategories));
    }

//Находим все товары и добавляем их массив products. В цикле проверяем наличие у каждого товара одного стикера
    public void checkingStickers(){
        List<WebElement>products = driver.findElements(product);
        for(WebElement product : products) {
            Assert.assertEquals(product.findElements(By.className("sticker")).size(),1);
        }
    }

}
