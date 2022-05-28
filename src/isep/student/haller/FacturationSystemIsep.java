package isep.student.haller;

import java.util.List;

public class FacturationSystemIsep implements FacturationSystem {

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
        product.setTaxValue(product.getInitialCost()*((taxPercent)/100)); // TAX VALUE CALCULATION
        product.setTaxValue((Math.ceil(product.getTaxValue()/0.05))*0.05); // ROUND TO SUPERIOR 0.05 USING MATH.CEIL()
        product.setCostWithTaxes(product.getInitialCost()+product.getTaxValue()); // ADDING TAX VALUE TO PRODUCT COST

        // CORRECTING FLOAT ERRORS (.99999 and .00001 ISSUES CAUSED BY "* 2 ^ EXP" DOUBLE REPRESENTATION):
        product.setTaxValue(DoubleHandler.correctFloatValue(product.getTaxValue()));
        product.setCostWithTaxes(DoubleHandler.correctFloatValue(product.getCostWithTaxes()));

    }

    public void calculateTotal(List<Product> productList) {
        for (Product product: productList) {
            calculateProductCostWithTaxes(product);
        }
    }
}
