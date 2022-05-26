import java.util.List;

public class FacturationSystem {

    Facture calculateProductCostWithTaxes(Product product) {
        double calculatedTaxPercentage = 0;

        if(product.isImported()) {
            calculatedTaxPercentage+=5;
        }
        calculatedTaxPercentage+=product.getClassification().getTaxPercentage();

        product.setCostWithTaxes(product.getCost()*((100+calculatedTaxPercentage)/100));

        double productCostWithTaxes_roundedToSuperior05 = (Math.ceil(product.getCostWithTaxes()/0.05))*0.05;
        product.setCostWithTaxes(Math.floor(productCostWithTaxes_roundedToSuperior05*100)/100);

        return null;
    }

    Facture calculateTotal(List<Product> productList) {
        for (Product product:
             productList) {
            calculateProductCostWithTaxes(product);
        }
        return null;
    }
}
