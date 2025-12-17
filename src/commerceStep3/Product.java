package commerceStep3;

public class Product
{
    private String name;
    private int price;
    private String description;
    private int stock;

    public  Product(String name, int price, String description, int stock)
    {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public String  getName()
    {

        return this.name;
    }

    public String toString()
    {
        return name + " | " + String.format("%,d", price) + "원 | " + description;
    }



}
