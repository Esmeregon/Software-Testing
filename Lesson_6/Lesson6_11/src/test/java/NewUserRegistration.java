import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewUserRegistration {

    public WebDriver driver;
    public WebDriverWait wait;


//Подтягиваем драйвер
    public NewUserRegistration(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }


//Селекторы
    @FindBy(xpath = "//h3[contains(text(), 'Most Popular')]")
    WebElement mostPopularCategories;

    @FindBy(xpath = "//h1")
    WebElement createAccountPage;

    private final By newUserLink = By.linkText("New customers click here");
    private final By firstNameField = By.xpath("//input[@name = 'firstname']");
    private final By lastNameField = By.xpath("//input[@name = 'lastname']");
    private final By address1field = By.xpath("//input[@name = 'address1']");
    private final By postcodeField = By.xpath("//input[@name = 'postcode']");
    private final By cityField = By.xpath("//input[@name = 'city']");
    private final By emailField = By.xpath("//input[@name = 'email']");
    private final By phoneField = By.xpath("//input[@name = 'phone']");
    private final By passwordField = By.xpath("//input[@name = 'password']");
    private final By confirmPasswordField = By.xpath("//input[@name = 'confirmed_password']");
    private final By createAccountButton = By.xpath("//button[@name = 'create_account']");

    private final By logOutButton = By.linkText("Logout");

    private final By notifyMessage = By.xpath("//div[@class = 'notice success']");

    private final By loginButton = By.xpath("//button[@name= 'login']");

    private final By countryField = By.xpath("//select[@name='country_code']");
    private final By zoneCodeField = By.xpath("//select[@name='zone_code']");


//Заходим в учебное приложение
    public void goToLitecart(){
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOf(mostPopularCategories));
    }

//Создаем нового пользователя
    public void createNewUser(NewUser newUser){
        driver.findElement(newUserLink).click();
        wait.until(ExpectedConditions.visibilityOf(createAccountPage));
        driver.findElement(firstNameField).sendKeys(newUser.firstName);
        driver.findElement(lastNameField).sendKeys(newUser.lastName);
        driver.findElement(address1field).sendKeys(newUser.address);
        ((JavascriptExecutor)driver).executeScript("arguments[0].selectedIndex = 224; arguments[0].dispatchEvent(new Event('change'))" , driver.findElement(countryField));
        ((JavascriptExecutor)driver).executeScript("arguments[0].selectedIndex = 20; arguments[0].dispatchEvent(new Event('change'))" , driver.findElement(zoneCodeField));
        driver.findElement(postcodeField).sendKeys(newUser.postcode);
        driver.findElement(cityField).sendKeys(newUser.city);
        driver.findElement(emailField).sendKeys(newUser.email);
        driver.findElement(phoneField).sendKeys(newUser.phone);
        driver.findElement(passwordField).sendKeys(newUser.password);
        driver.findElement(confirmPasswordField).sendKeys(newUser.password);
        driver.findElement(createAccountButton).click();
        Assert.assertEquals("Your customer account has been created.", driver.findElement(notifyMessage).getText());
    }

//Выходим из учетной записи
    public void logOut(){
        driver.findElement(logOutButton).click();
        Assert.assertEquals("You are now logged out.", driver.findElement(notifyMessage).getText());
    }

//Заходим под созданной учетной записью
    public void logIn(NewUser newUser){
        driver.findElement(emailField).sendKeys(newUser.email);
        driver.findElement(passwordField).sendKeys(newUser.password);
        driver.findElement(loginButton).click();
        Assert.assertEquals("You are now logged in as " + newUser.firstName + " " + newUser.lastName + ".", driver.findElement(notifyMessage).getText());
    }

}
