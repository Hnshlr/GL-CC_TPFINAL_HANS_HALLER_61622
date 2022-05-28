package isep.student.haller;

import java.util.List;

public class ShoppingCart {
    List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "isep.student.haller.ShoppingCart{" +
                "products=" + products +
                '}';
    }
}
