import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings {

    private final String login = "admin";
    private final String password = "admin";

    @Test
    public void checkingCart() {
        CheckingLog checkingLog = PageFactory.initElements(driver, CheckingLog.class);
        checkingLog.logIn(login, password);
        checkingLog.getLog();
    }
}