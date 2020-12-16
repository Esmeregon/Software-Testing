import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchInBrowser {

    private WebDriver driver;
    private WebDriverWait wait;

//Подтягиваем драйвер
    public SearchInBrowser(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

// Используемые селекторы
    @FindBy(id = "tpblock-mainbody")
    private WebElement pageBody;

    @FindBy(xpath = "//span[text()='Тренинги']")
    private WebElement trainingsLink;

    @FindBy(id = "jsn-logo-desktop")
    private WebElement trainingsLogo;


//Открываем сайт software-testing.ru
    public void openURL(){
        driver.get("https://software-testing.ru");
        wait.until(ExpectedConditions.visibilityOf(pageBody));
    }


//Переходим на страничку тренингов
    public void trainingsPage(){
        trainingsLink.click();
        wait.until(ExpectedConditions.visibilityOf(trainingsLogo));
    }
}
