import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class AddingANewProduct {

    public WebDriver driver;
    public WebDriverWait wait;

    private final String weight = "1";
    private final String width = "6";
    private final String height = "10";
    private final String length = "10";
    private final String attributes = "Colors\n" +
            "Body: Brown\n" +
            "Eyes: Black\n" +
            "Beak: Orange\n" +
            "\n" +
            "Other\n" +
            "Material: Plastic";


//Подтягиваем драйвер
    public AddingANewProduct(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы страницы авторизации
    private final By signInForm = By.id("box-login");
    private final By loginField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@name='login']");
//Селекторы страницы администрирования
    private final By addNewProductButton = By.linkText("Add New Product");
    private final By catalogCategories = By.linkText("Rubber Ducks");
//Селекторы страницы добавления нового продукта
    private final By addNewProductHeader = By.xpath("//h1");
    private final By saveButton = By.xpath("//button[@name='save']");
//Селекторы вкладки General
    private final By generalTab = By.linkText("General");
    private final By nameField = By.xpath("//input[@name='name[en]']");
    private final By codeField = By.xpath("//input[@name='code']");
    private final By quantityField = By.xpath("//input[@name='quantity']");
    private final By imageUploadButton = By.xpath("//input[@name='new_images[]']");
    private final By enabledStatusRadio = By.xpath("//input[@name='status'][@value='1']");
    private final By rootCategoriesCheckbox = By.xpath("//input[@data-name='Root']");
    private final By ducksCategoriesCheckbox = By.xpath("//input[@data-name= 'Rubber Ducks']");
//Селекторы вкладки Information
    private final By informationTab = By.linkText("Information");
    private final By manufacturerField = By.xpath("//select[@name='manufacturer_id']");
    private final By shortDescriptionField = By.xpath("//input[@name='short_description[en]']");
    private final By descriptionField = By.xpath("//div[@class='trumbowyg-editor']");
//Селекторы вкладки Prices
    private final By pricesTab = By.linkText("Prices");
    private final By priceField = By.xpath("//input[@name='prices[USD]']");
//Селекторы вкладки Data
    private final By dataTab = By.linkText("Data");
    private final By skuField = By.xpath("//input[@name='sku']");
    private final By weightField = By.xpath("//input[@name='weight']");
    private final By widthField = By.xpath("//input[@name='dim_x']");
    private final By heightField = By.xpath("//input[@name='dim_y']");
    private final By lengthField = By.xpath("//input[@name='dim_z']");
    private final By attributesField = By.xpath("//textarea[@name='attributes[en]']");



//Открываем страницу авторизации
    public void logIn(String login, String password){
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInForm));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(addNewProductButton));
    }

//Переходим на страницу создания нового продукта
    public void openAddNewProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(addNewProductButton));
        driver.findElement(addNewProductButton).click();
        Assert.assertEquals("Add New Product",driver.findElement(addNewProductHeader).getText());
    }

//Заполнение вкладки General
    public void fillingGeneralTab(NewProduct newProduct){
        driver.findElement(generalTab).click();
        wait.until(ExpectedConditions.elementToBeClickable(enabledStatusRadio));
        driver.findElement(enabledStatusRadio).click();
        driver.findElement(nameField).sendKeys(newProduct.name);
        driver.findElement(codeField).sendKeys(newProduct.code);
        uncheckCheckbox(rootCategoriesCheckbox);
        setCheckbox(ducksCategoriesCheckbox);
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(newProduct.quantity);
        driver.findElement(imageUploadButton).sendKeys(imageSettings());
    }

//Заполнение вкладки Information
    public  void fillingInformationTab(NewProduct newProduct){
        driver.findElement(informationTab).click();
        wait.until(ExpectedConditions.elementToBeClickable(manufacturerField));
        ((JavascriptExecutor)driver).executeScript("arguments[0].selectedIndex = 1; arguments[0].dispatchEvent(new Event('change'))" , driver.findElement(manufacturerField));
        driver.findElement(shortDescriptionField).sendKeys(newProduct.shortDescription);
        driver.findElement(descriptionField).sendKeys(newProduct.description);
    }

//Заполнение вкладки Prices
    public void fillingPricesTab(NewProduct newProduct){
        driver.findElement(pricesTab).click();
        wait.until(ExpectedConditions.elementToBeClickable(priceField));
        driver.findElement(priceField).sendKeys(newProduct.price);

    }

//Заполнение вкладки Data
    public void fillingDataTab(NewProduct newProduct){
        driver.findElement(dataTab).click();
        wait.until(ExpectedConditions.elementToBeClickable(skuField));
        driver.findElement(skuField).sendKeys(newProduct.code.toUpperCase());
        driver.findElement(weightField).clear();
        driver.findElement(weightField).sendKeys(weight);
        driver.findElement(widthField).clear();
        driver.findElement(widthField).sendKeys(width);
        driver.findElement(heightField).clear();
        driver.findElement(heightField).sendKeys(height);
        driver.findElement(lengthField).clear();
        driver.findElement(lengthField).sendKeys(length);
        driver.findElement(attributesField).sendKeys(attributes);
    }

//Заполнение вкладок и подтвержение создания нового продукта
    public void productCreation(NewProduct newProduct){
        fillingGeneralTab(newProduct);
        fillingInformationTab(newProduct);
        fillingDataTab(newProduct);
        fillingPricesTab(newProduct);
        driver.findElement(saveButton).click();
    }

//Проверка созданного продукта
    public void productCreationConfirmation(NewProduct newProduct){
        driver.findElement(catalogCategories).click();
        Assert.assertTrue(driver.findElement(By.linkText(newProduct.name)).isDisplayed());
    }

//Настройка изображения продукта
    public String imageSettings(){
        return new File("src\\test\\resources\\a1aaa5f2da58911c40c1c93a1be3e28c.jpg").getAbsolutePath();
    }

//Работа с чекбоксами
    public void uncheckCheckbox(By element){
        WebElement webElement = driver.findElement(element);
        if (webElement.getAttribute("checked") != null ){
            webElement.click();
        }
    }

    public void setCheckbox(By element){
        WebElement webElement = driver.findElement(element);
        if (webElement.getAttribute("checked") == null){
            webElement.click();
        }
    }

}
