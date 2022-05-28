import java.util.List;

public interface FacturationSystem {

    String getName();
    void calculateProductCostWithTaxes(Product product);
    void calculateTotal(List<Product> productList);
}
