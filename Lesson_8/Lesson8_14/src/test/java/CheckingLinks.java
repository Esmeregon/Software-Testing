import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class CheckingLinks {

    public WebDriver driver;
    public WebDriverWait wait;

//Подтягиваем драйвер
    public CheckingLinks(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы страницы авторизации
    private final By signInForm = By.id("box-login");
    private final By loginField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@name='login']");
//Селекторы страницы Countries
    private final By editButton = By.xpath("//a[@title='Edit']");
//Селекторы страницы редактирования
    private final By linkButton = By.xpath("//i[@class='fa fa-external-link']");

//Открываем страницу авторизации
    public void logIn(String login, String password){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInForm));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
    }

//Проверка ссылок
    public void editCountry(){
        driver.findElement(editButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(linkButton));
        String mainWindow = driver.getWindowHandle();
        List<WebElement>links = driver.findElements(linkButton);
        for (WebElement link : links) {
            link.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String>windows = driver.getWindowHandles();
            windows.remove(mainWindow);
            String newWindow = windows.iterator().next();
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

}
