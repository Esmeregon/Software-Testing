import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CheckingLog {

    public WebDriver driver;
    public WebDriverWait wait;

//Подтягиваем драйвер
    public CheckingLog(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }


//Селекторы
    private final By signInForm = By.id("box-login");
    private final By loginField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@name='login']");
    private final By product = By.xpath("//img/following-sibling::*");


//Открываем страницу авторизации
    public void logIn(String login, String password){
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInForm));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(product));
    }


//Прокликиваем продукты и проверяем лог браузера
    public void getLog(){
        List<WebElement> products = driver.findElements(product);
        List<String> productNames = new ArrayList<>();
        for (WebElement webElement : products) {
            productNames.add(webElement.getText());
        }
        wait.until(ExpectedConditions.elementToBeClickable(product));
        for(String productName : productNames){
            driver.findElement(By.linkText(productName)).click();
            driver.navigate().back();
            wait.until(ExpectedConditions.elementToBeClickable(product));
        }
        driver.manage().logs().get("browser").forEach(logEntry -> Assert.assertEquals("", logEntry));
    }

}
