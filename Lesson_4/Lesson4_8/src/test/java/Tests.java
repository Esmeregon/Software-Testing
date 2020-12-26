import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings{

    @Test
    public void checkingStickers(){
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        startPage.goToLitecart();
        startPage.checkingStickers();
    }
}
