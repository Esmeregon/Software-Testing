import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings{

    @Test
    public void checkingCart(){
        StorePage storePage = PageFactory.initElements(driver, StorePage.class);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        storePage.goToLitecart();
        storePage.productSelection();
        cartPage.goToCart();
        cartPage.productRemoval();
    }
}
