import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AdminPage extends SeleniumSettings {

    private final WebDriver driver;
    private final WebDriverWait wait;

//Подтягиваем драйвер
    public AdminPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

//Селекторы Appearence
    private final By appearenceMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Appearence')]");

    private final By template = By.xpath("//li[@id='doc-template']");

    private final By logotype = By.xpath("//li[@id='doc-logotype']");

//Селекторы Catalog
    private final By catalogMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Catalog')]");

    private final By catalog = By.xpath("//li[@id='doc-catalog']");

    private final By productGroups = By.xpath("//li[@id='doc-product_groups']");

    private final By optionGroups = By.xpath("//li[@id='doc-option_groups']");

    private final By manufacturers = By.xpath("//li[@id='doc-manufacturers']");

    private final By suppliers = By.xpath("//li[@id='doc-suppliers']");

    private final By deliveryStatuses = By.xpath("//li[@id='doc-delivery_statuses']");

    private final By soldOutStatuses = By.xpath("//li[@id='doc-sold_out_statuses']");

    private final By quantityUnits = By.xpath("//li[@id='doc-quantity_units']");

    private final By catalogCSV = By.xpath("//li[@id='doc-csv']");

//Селекторы Countries
    private final By countriesMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Countries')]");

//Селекторы Currencies
    private final By currenciesMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Currencies')]");

//Селекторы Customers
    private final By customersMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Customers')]");

    private final By customers = By.xpath("//li[@id='doc-customers']");

    private final By customersCSV = By.xpath("//li[@id='doc-csv']");

    private final By newsletter = By.xpath("//li[@id='doc-newsletter']");

//Селекторы Geo Zones
    private final By geoZonesMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Geo Zones')]");

//Селекторы Languages
    private final By languagesMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Languages')]");

    private final By languages = By.xpath("//li[@id='doc-languages']");

    private final By storageEncoding = By.xpath("//li[@id='doc-storage_encoding']");

//Селекторы Modules
    private final By modulesMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Modules')]");

    private final By backgroundJobs = By.xpath("//li[@id='doc-jobs']");

    private final By customerModules = By.xpath("//li[@id='doc-customer']");

    private final By shippingModules = By.xpath("//li[@id='doc-shipping']");

    private final By paymentModules = By.xpath("//li[@id='doc-payment']");

    private final By orderTotalModules = By.xpath("//li[@id='doc-order_total']");

    private final By orderSuccessModules = By.xpath("//li[@id='doc-order_success']");

    private final By orderActionModules = By.xpath("//li[@id='doc-order_action']");

//Селекторы Orders
    private final By ordersMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Orders')]");

    private final By orders = By.xpath("//li[@id='doc-orders']");

    private final By orderStatuses = By.xpath("//li[@id='doc-order_statuses']");

//Селекторы Pages
    private final By pagesMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Pages')]");

//Селекторы Reports
    private final By reportsMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Reports')]");

    private final By monthlySales = By.xpath("//li[@id='doc-monthly_sales']");

    private final By mostSoldProducts = By.xpath("//li[@id='doc-most_sold_products']");

    private final By mostShoppingCustomers = By.xpath("//li[@id='doc-most_shopping_customers']");

//Селекторы Settings
    private final By settingsMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Settings')]");

    private final By storeInfo = By.xpath("//li[@id='doc-store_info']");

    private final By defaults = By.xpath("//li[@id='doc-defaults']");

    private final By general = By.xpath("//li[@id='doc-general']");

    private final By listings = By.xpath("//li[@id='doc-listings']");

    private final By images = By.xpath("//li[@id='doc-images']");

    private final By checkout = By.xpath("//li[@id='doc-checkout']");

    private final By advanced = By.xpath("//li[@id='doc-advanced']");

    private final By security = By.xpath("//li[@id='doc-security']");

//Селекторы Slides
    private final By slidesMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Slides')]");

//Селекторы Tax
    private final By taxMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Tax')]");

    private final By taxClasses = By.xpath("//li[@id='doc-tax_classes']");

    private final By taxRates = By.xpath("//li[@id='doc-tax_rates']");

//Селекторы Translations
    private final By translationsMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Translations')]");

    private final By searchTranslations = By.xpath("//li[@id='doc-search']");

    private final By scanTranslations = By.xpath("//li[@id='doc-scan']");

    private final By CSVTranslations = By.xpath("//li[@id='doc-csv']");

//Селекторы Users
    private final By usersMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'Users')]");

//Селекторы vQmods
    private final By vQmodsMenu = By.xpath("//li[@id='app-']/a/span[contains(text(), 'vQmods')]");

    private final By vQmods = By.xpath("//li[@id='doc-vqmods']");

//Заголовки Appearence
    @FindBy(xpath = "//h1[contains(text(), ' Template')]")
    WebElement templateHeader;

    @FindBy(xpath = "//h1[contains(text(), ' Logotype')]")
    WebElement logotypeHeader;

//Заголовки Catalog
    @FindBy(xpath = "//h1[contains(text(), ' Catalog')]")
    WebElement catalogHeader;

    @FindBy(xpath = "//h1[contains(text(), ' Product Groups')]")
    WebElement productGroupsHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Option Groups')]")
    WebElement optionGroupsHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Manufacturers')]")
    WebElement manufacturersHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Suppliers')]")
    WebElement suppliersHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Delivery Statuses')]")
    WebElement deliveryStatusesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Sold Out Statuses')]")
    WebElement soldOutStatusesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Quantity Units')]")
    WebElement quantityUnitsHeader;

    @FindBy(xpath = "//h1[contains(text(), 'CSV Import/Export')]")
    WebElement catalogCSVHeader;

//Заголовки Countries
    @FindBy(xpath = "//h1[contains(text(), 'Countries')]")
    WebElement countriesMenuHeader;

//Заголовки Currencies
    @FindBy(xpath = "//h1[contains(text(), 'Currencies')]")
    WebElement currenciesMenuHeader;

//Заголовки Customers
    @FindBy(xpath = "//h1[contains(text(), 'Customers')]")
    WebElement customersMenuHeader;

    @FindBy(xpath = "//h1[contains(text(), 'CSV Import/Export')]")
    WebElement customersCSVHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Newsletter')]")
    WebElement newsletterHeader;

//Заголовки Geo Zones
    @FindBy(xpath = "//h1[contains(text(), 'Geo Zones')]")
    WebElement geoZonesHeader;

//Заголовки Languages
    @FindBy(xpath = "//h1[contains(text(), 'Languages')]")
    WebElement languagesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Storage Encoding')]")
    WebElement storageEncodingHeader;

//Заголовки Modules
    @FindBy(xpath = "//h1[contains(text(), 'Job Modules')]")
    WebElement modulesMenuHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Customer Modules')]")
    WebElement customerModulesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Shipping Modules')]")
    WebElement shippingModulesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Payment Modules')]")
    WebElement paymentModulesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Order Total Modules')]")
    WebElement orderTotalModulesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Order Success Modules')]")
    WebElement orderSuccessModulesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Order Action Modules')]")
    WebElement orderActionModulesHeader;

//Заголовки Orders
    @FindBy(xpath = "//h1[contains(text(), 'Orders')]")
    WebElement ordersHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Order Statuses')]")
    WebElement orderStatusesHeader;

//Заголовки Pages
    @FindBy(xpath = "//h1[contains(text(), 'Pages')]")
    WebElement pagesHeader;

//Заголовки Reports
    @FindBy(xpath = "//h1[contains(text(), 'Monthly Sales')]")
    WebElement monthlySalesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Most Sold Products')]")
    WebElement mostSoldProductsHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Most Shopping Customers')]")
    WebElement mostShoppingCustomersHeader;

//Заголовки Settings
    @FindBy(xpath = "//h1[contains(text(), 'Settings')]")
    WebElement settingsHeader;

//Заголовки Slides
    @FindBy(xpath = "//h1[contains(text(), 'Slides')]")
    WebElement slidesHeader;

//Заголовки Tax
    @FindBy(xpath = "//h1[contains(text(), 'Tax Classes')]")
    WebElement taxClassesHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Tax Rates')]")
    WebElement taxRatesHeader;

//Заголовки Translations
    @FindBy(xpath = "//h1[contains(text(), 'Search Translations')]")
    WebElement searchTranslationsHeader;

    @FindBy(xpath = "//h1[contains(text(), 'Scan Files For Translations')]")
    WebElement scanTranslationsHeader;

    @FindBy(xpath = "//h1[contains(text(), 'CSV Import/Export')]")
    WebElement CSVTranslationsHeader;

//Заголовки Users
    @FindBy(xpath = "//h1[contains(text(), 'Users')]")
    WebElement usersHeader;

//Заголовки vQmods
    @FindBy(xpath = "//h1[contains(text(), 'vQmods')]")
    WebElement vQmodsHeader;


//Проверка меню Appearence
    public void checkAppearence() {
        driver.findElement(appearenceMenu).click();
        wait.until(ExpectedConditions.visibilityOf(templateHeader));
        driver.findElement(template).click();
        wait.until(ExpectedConditions.visibilityOf(templateHeader));
        driver.findElement(logotype).click();
        wait.until(ExpectedConditions.visibilityOf(logotypeHeader));
    }

//Проверка меню Catalog
    public void checkCatalog() {
        driver.findElement(catalogMenu).click();
        wait.until(ExpectedConditions.visibilityOf(catalogHeader));
        driver.findElement(catalog).click();
        wait.until(ExpectedConditions.visibilityOf(catalogHeader));
        driver.findElement(productGroups).click();
        wait.until(ExpectedConditions.visibilityOf(productGroupsHeader));
        driver.findElement(optionGroups).click();
        wait.until(ExpectedConditions.visibilityOf(optionGroupsHeader));
        driver.findElement(manufacturers).click();
        wait.until(ExpectedConditions.visibilityOf(manufacturersHeader));
        driver.findElement(suppliers).click();
        wait.until(ExpectedConditions.visibilityOf(suppliersHeader));
        driver.findElement(deliveryStatuses).click();
        wait.until(ExpectedConditions.visibilityOf(deliveryStatusesHeader));
        driver.findElement(soldOutStatuses).click();
        wait.until(ExpectedConditions.visibilityOf(soldOutStatusesHeader));
        driver.findElement(quantityUnits).click();
        wait.until(ExpectedConditions.visibilityOf(quantityUnitsHeader));
        driver.findElement(catalogCSV).click();
        wait.until(ExpectedConditions.visibilityOf(catalogCSVHeader));
    }

//Проверка меню Countries
    public void checkCountries() {
        driver.findElement(countriesMenu).click();
        wait.until(ExpectedConditions.visibilityOf(countriesMenuHeader));
    }

//Проверка меню Currencies
    public void checkCurrencies() {
        driver.findElement(currenciesMenu).click();
        wait.until(ExpectedConditions.visibilityOf(currenciesMenuHeader));
    }

//Проверка меню Customers
    public void checkCustomers() {
        driver.findElement(customersMenu).click();
        wait.until(ExpectedConditions.visibilityOf(customersMenuHeader));
        driver.findElement(customers).click();
        wait.until(ExpectedConditions.visibilityOf(customersMenuHeader));
        driver.findElement(customersCSV).click();
        wait.until(ExpectedConditions.visibilityOf(customersCSVHeader));
        driver.findElement(newsletter).click();
        wait.until(ExpectedConditions.visibilityOf(newsletterHeader));
    }

//Проверка меню Geo Zones
    public void checkGeoZones() {
        driver.findElement(geoZonesMenu).click();
        wait.until(ExpectedConditions.visibilityOf(geoZonesHeader));
    }

//Проверка меню Languages
    public void checkLanguages() {
        driver.findElement(languagesMenu).click();
        wait.until(ExpectedConditions.visibilityOf(languagesHeader));
        driver.findElement(languages).click();
        wait.until(ExpectedConditions.visibilityOf(languagesHeader));
        driver.findElement(storageEncoding).click();
        wait.until(ExpectedConditions.visibilityOf(storageEncodingHeader));
    }

//Проверка меню Modules
    public void checkModules() {
        driver.findElement(modulesMenu).click();
        wait.until(ExpectedConditions.visibilityOf(modulesMenuHeader));
        driver.findElement(backgroundJobs).click();
        wait.until(ExpectedConditions.visibilityOf(modulesMenuHeader));
        driver.findElement(customerModules).click();
        wait.until(ExpectedConditions.visibilityOf(customerModulesHeader));
        driver.findElement(shippingModules).click();
        wait.until(ExpectedConditions.visibilityOf(shippingModulesHeader));
        driver.findElement(paymentModules).click();
        wait.until(ExpectedConditions.visibilityOf(paymentModulesHeader));
        driver.findElement(orderTotalModules).click();
        wait.until(ExpectedConditions.visibilityOf(orderTotalModulesHeader));
        driver.findElement(orderSuccessModules).click();
        wait.until(ExpectedConditions.visibilityOf(orderSuccessModulesHeader));
        driver.findElement(orderActionModules).click();
        wait.until(ExpectedConditions.visibilityOf(orderActionModulesHeader));
    }

//Проверка меню Orders
    public void checkOrders() {
        driver.findElement(ordersMenu).click();
        wait.until(ExpectedConditions.visibilityOf(ordersHeader));
        driver.findElement(orders).click();
        wait.until(ExpectedConditions.visibilityOf(ordersHeader));
        driver.findElement(orderStatuses).click();
        wait.until(ExpectedConditions.visibilityOf(orderStatusesHeader));
    }

//Проверка меню Pages
    public void checkPages() {
        driver.findElement(pagesMenu).click();
        wait.until(ExpectedConditions.visibilityOf(pagesHeader));
    }

//Проверка меню Reports
    public void checkReports() {
        driver.findElement(reportsMenu).click();
        wait.until(ExpectedConditions.visibilityOf(monthlySalesHeader));
        driver.findElement(monthlySales).click();
        wait.until(ExpectedConditions.visibilityOf(monthlySalesHeader));
        driver.findElement(mostSoldProducts).click();
        wait.until(ExpectedConditions.visibilityOf(mostSoldProductsHeader));
        driver.findElement(mostShoppingCustomers).click();
        wait.until(ExpectedConditions.visibilityOf(mostShoppingCustomersHeader));
    }

//Проверка меню Settings
    public void checkSettings() {
        driver.findElement(settingsMenu).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(storeInfo).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(defaults).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(general).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(listings).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(images).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(checkout).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(advanced).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
        driver.findElement(security).click();
        wait.until(ExpectedConditions.visibilityOf(settingsHeader));
    }

//Проверка меню Slides
    public void checkSlides() {
        driver.findElement(slidesMenu).click();
        wait.until(ExpectedConditions.visibilityOf(slidesHeader));
    }

//Проверка меню Tax
    public void checkTax() {
        driver.findElement(taxMenu).click();
        wait.until(ExpectedConditions.visibilityOf(taxClassesHeader));
        driver.findElement(taxClasses).click();
        wait.until(ExpectedConditions.visibilityOf(taxClassesHeader));
        driver.findElement(taxRates).click();
        wait.until(ExpectedConditions.visibilityOf(taxRatesHeader));
    }

//Проверка меню Translations
    public void checkTranslations() {
        driver.findElement(translationsMenu).click();
        wait.until(ExpectedConditions.visibilityOf(searchTranslationsHeader));
        driver.findElement(searchTranslations).click();
        wait.until(ExpectedConditions.visibilityOf(searchTranslationsHeader));
        driver.findElement(scanTranslations).click();
        wait.until(ExpectedConditions.visibilityOf(scanTranslationsHeader));
        driver.findElement(CSVTranslations).click();
        wait.until(ExpectedConditions.visibilityOf(CSVTranslationsHeader));
    }

//Проверка меню Users
    public void checkUsers() {
        driver.findElement(usersMenu).click();
        wait.until(ExpectedConditions.visibilityOf(usersHeader));
    }

//Проверка меню vQmods
    public void checkVQmods() {
        driver.findElement(vQmodsMenu).click();
        wait.until(ExpectedConditions.visibilityOf(vQmodsHeader));
        driver.findElement(vQmods).click();
        wait.until(ExpectedConditions.visibilityOf(vQmodsHeader));
    }

//Проверка меню страницы администрирования
    public void checkingMenu(){
        checkAppearence();
        checkCatalog();
        checkCountries();
        checkCurrencies();
        checkCustomers();
        checkGeoZones();
        checkLanguages();
        checkModules();
        checkOrders();
        checkPages();
        checkReports();
        checkSettings();
        checkSlides();
        checkTax();
        checkTranslations();
        checkUsers();
        checkVQmods();
    }

}
