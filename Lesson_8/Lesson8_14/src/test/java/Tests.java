import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings{

    private final String login = "admin";
    private final String password = "admin";


    @Test
    public void checkingLink(){
        CheckingLinks checkingLinks = PageFactory.initElements(driver, CheckingLinks.class);
        checkingLinks.logIn(login, password);
        checkingLinks.editCountry();
    }
}
