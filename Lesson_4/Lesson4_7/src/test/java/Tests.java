import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings{

    private final String login = "admin";
    private final String password = "admin";

    @Test
    public void checkingAdminPageMenu() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
        signInPage.logIn(login, password);
        adminPage.checkingMenu();
    }
}
