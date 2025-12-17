package commerceStep3;

import java.util.ArrayList;
import java.util.List;

public class CategoryProduct
{
    private String categoryName;
    private List<Product> products;


    public CategoryProduct(String categoryName)
    {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }
    public String getCategoryName()
    {
        return categoryName;
    }
    public List<Product> getProducts()
    {
        return products;
    }

    public int getProductCount()
    {
        return products.size();
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }
}
