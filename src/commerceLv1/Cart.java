package commerceLv1;

import java.util.ArrayList;
import java.util.List;

public class Cart
{

        private List<Product> cart;


        public Cart()
        {
            this.cart = new ArrayList<>();
        }
        public List<Product> getCart()
        {
            return cart;
        }

        public int getCartCount()
        {
            return cart.size();
        }

        public void addCart(Product product)
        {
            cart.add(product);
        }


}
