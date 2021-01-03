import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings{

    private final String login = "admin";
    private final String password = "admin";

    public String name = "Duck Detective";
    public String code = "r75678";
    public String quantity = "35";
    public String shortDescription = "Duck Detective";
    public String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque dui non consequat sollicitudin. Sed pretium tortor ac auctor molestie. Nulla facilisi. Maecenas pulvinar nibh vitae lectus vehicula semper. Donec et aliquet velit. Curabitur non ullamcorper mauris. In hac habitasse platea dictumst. Phasellus ut pretium justo, sit amet bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, viverra nisi. Morbi sit amet adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. Proin justo massa, convallis vitae consectetur sit amet, facilisis id libero.";
    public String price = "25";

    NewProduct newProduct = new NewProduct(name, code, quantity, shortDescription, description, price);

    @Test
    public void addingANewProduct(){
        AddingANewProduct addingANewProduct = PageFactory.initElements(driver,AddingANewProduct.class);
        addingANewProduct.logIn(login, password);
        addingANewProduct.openAddNewProduct();
        addingANewProduct.productCreation(newProduct);
        addingANewProduct.productCreationConfirmation(newProduct);
    }
}
