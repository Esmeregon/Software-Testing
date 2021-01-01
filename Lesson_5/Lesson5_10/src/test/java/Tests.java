import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings{


//Тест, проверяющий, что на главной странице и на странице товара совпадает текст названия товара
    @Test
    public void sameProductNames(){
        Litecart litecart = PageFactory.initElements(driver, Litecart.class);
        litecart.goToLitecart();
        litecart.comparisonOfProductNames();
    }

//Тест, проверяющий, что на главной странице и на странице товара совпадают цены (обычная и акционная)
    @Test
    public void sameProductPrice(){
        Litecart litecart = PageFactory.initElements(driver, Litecart.class);
        litecart.goToLitecart();
        litecart.productPriceComparison();
    }

/*
    Тест, проверяющий, что обычная цена зачёркнутая и серая
    ("серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
    (цвета проверяются на каждой странице независимо, при этом цвета на разных страницах могут не совпадать)
*/
    @Test
    public void regularPriceCheck(){
        Litecart litecart = PageFactory.initElements(driver, Litecart.class);
        litecart.goToLitecart();
        litecart.regularPriceCheck();
    }

/*
    Тест, проверяющий, что акционная жирная и красная
    ("красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
    (цвета проверяются на каждой странице независимо, при этом цвета на разных страницах могут не совпадать)
*/
    @Test
    public void campaignPriceCheck(){
        Litecart litecart = PageFactory.initElements(driver, Litecart.class);
        litecart.goToLitecart();
        litecart.campaignPriceCheck();
    }

//Тест, проверяющий, что акционная цена крупнее, чем обычная (независимая проверка на каждой странице)
    @Test
    public void priceComparison(){
        Litecart litecart = PageFactory.initElements(driver, Litecart.class);
        litecart.goToLitecart();
        litecart.priceComparison();
    }
}
