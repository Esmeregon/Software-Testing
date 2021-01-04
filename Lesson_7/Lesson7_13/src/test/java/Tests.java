import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings{

    @Test
    public void checkingCart(){
        CheckCart checkCart = PageFactory.initElements(driver, CheckCart.class);
        checkCart.goToLitecart();
        checkCart.addingProducts();
        checkCart.goToCart();
        checkCart.productRemoval();
    }
}
