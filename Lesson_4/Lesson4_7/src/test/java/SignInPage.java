import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SignInPage extends SeleniumSettings {


    private final WebDriver driver;
    private final WebDriverWait wait;


//Подтягиваем драйвер
    public SignInPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Используемые селекторы
    @FindBy(id = "box-login")
    WebElement signInForm;

    private final By adminPage = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Appearence')]");

    private final By loginField = By.xpath("//input[@name='username']");

    private final By passwordField = By.xpath("//input[@name='password']");

    private final By loginButton = By.xpath("//button[@name='login']");



//Открываем страницу авторизации
    public void logIn(String login, String password){
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(adminPage));
    }

}
