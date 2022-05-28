import java.util.List;

public class FacturationSystem_TPFinal implements FacturationSystem {

    public String getName() {
        return "Système de facturation imposé par le sujet du TP FINAL de Clean Code.";
    }

    public void calculateProductCostWithTaxes(Product product) {
        double taxPercent = 0;

        // TP FINAL SUBJECT'S RULE N°1 :
        if(product.isImported()) {
            taxPercent+=5;
        }

        // TP FINAL SUBJECT'S RULE N°2 :
        taxPercent+=product.getClassification().getTaxPercentage();

        // TP FINAL SUBJECT'S RULE N°3 :
        // calcul de la tax value à partir du taxPercent en pourcentage
        product.setTaxValue(product.getInitialCost()*((taxPercent)/100));
        // arrondi au 0.05 supérieur en utilisant Math.ceil()
        product.setTaxValue((Math.ceil(product.getTaxValue()/0.05))*0.05);
        // ajout de la tax value au product's cost with taxes
        product.setCostWithTaxes(product.getInitialCost()+ product.getTaxValue());

    }

    public void calculateTotal(List<Product> productList) {
        for (Product product:
             productList) {
            calculateProductCostWithTaxes(product);
        }
    }
}
