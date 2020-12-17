import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

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

    @FindBy(xpath = "//img[@title='My Store']")
    WebElement adminPage;

    private final By loginField = By.xpath("//input[@name='username']");

    private final By passwordField = By.xpath("//input[@name='password']");

    private final By loginButton = By.xpath("//button[@name='login']");

    private final By errorMessage = By.xpath("//div[@class='notice errors']");


//Открываем страницу авторизации
    public void openURL(){
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(ExpectedConditions.visibilityOf(signInForm));
    }

//Заполняем поле логин
    public void fillingLogin(String login){
        driver.findElement(loginField).sendKeys(login);
    }

//Заполняем поле пароль
    public void fillingPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

//Нажимаем кнопку Login
    public void sendAuthData(){
        driver.findElement(loginButton).click();
    }

//Ожидаем открытие страницы Администрирование
    public void waitSuccess(){
        wait.until(ExpectedConditions.visibilityOf(adminPage));
    }

//Получение ошибки "Неверный пароль"
    public void wrongPasswordError(){
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        String error = driver.findElement(errorMessage).getText();
        Assert.assertEquals(error, "Wrong combination of username and password or the account does not exist.");
    }

//Получение ошибки "Неверный логин"
    public void wrongUserError(){
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        String error = driver.findElement(errorMessage).getText();
        Assert.assertEquals(error, "The user could not be found in our database");
    }

//Получение ошибк "Отсутствует логин"
    public void noLoginError(){
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        String error = driver.findElement(errorMessage).getText();
        Assert.assertEquals(error, "You must provide a username");
    }


}
