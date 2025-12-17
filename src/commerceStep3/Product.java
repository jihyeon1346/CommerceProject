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

    // 리스트 표시용
    public String toString()
    {
        return name + " | " + String.format("%,d", price) + "원 | " + description;
    }
    // 선택 표시용
    public String toDetailString() {
        return name + " | " + String.format("%,d", price) + "원 | " + description + " | 재고: " + stock + "개";
    }



}
