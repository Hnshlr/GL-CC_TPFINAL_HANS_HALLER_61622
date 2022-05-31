package isep.student.haller;

@FunctionalInterface
public interface FacturationSystem {

    void calculateProductCostWithTaxes(Product product);
}
