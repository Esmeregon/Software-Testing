public class NewProduct {

    public String name;
    public String code;
    public String quantity;
    public String price;
    public String shortDescription;
    public String description;

    public NewProduct(String name, String code, String quantity, String shortDescription, String description, String price){
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.shortDescription = shortDescription;
        this.description = description;
        this.price = price;
    }

}
