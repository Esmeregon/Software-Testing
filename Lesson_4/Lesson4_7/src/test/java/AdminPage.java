import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class AdminPage extends SeleniumSettings {

    private final WebDriver driver;
    private final WebDriverWait wait;

//Подтягиваем драйвер
    public AdminPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Используемые селекторы
    private final By menuHeaders = By.xpath("//span[@class='name']");

    private final By submenuHeaders = By.cssSelector("[id^=doc-]");

    private final By title = By.tagName("h1");


//Проверка меню страницы администрирования
    public void checkingMenu(){

        List<String>menuItems = getName(driver.findElements(menuHeaders));
        for (String menuItem : menuItems){
            driver.findElement(By.xpath("//span[text()='" + menuItem + "']")).click();
            Assert.assertTrue(driver.findElement(title).isDisplayed());

            List<String>submenuItems = getName(driver.findElements(submenuHeaders));
            for (String submenuItem : submenuItems){
                driver.findElement(By.xpath("//span[text()='" + submenuItem + "']")).click();
                Assert.assertTrue(driver.findElement(title).isDisplayed());
            }
        }

    }

//Преобразуем List<WebElement> в List<String>
    private List<String> getName(List<WebElement>elements){
        List<String>itemNames = new ArrayList<>();
        for (WebElement element : elements){
            itemNames.add(element.getText());
        }
        return itemNames;
    }

}

