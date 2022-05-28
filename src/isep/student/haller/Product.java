package isep.student.haller;

public class Product {

    // PRODUCT DEFINING :

    private String name;
    private double initialCost;
    private Classification classification;
    private boolean isImported;


    public Product() {
    }

    public Product(String name, double initialCost, Classification productType, boolean isImported) {
        this.name = name;
        this.initialCost = initialCost;
        this.classification = productType;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public double getInitialCost() {
        return initialCost;
    }

    public Classification getClassification() {
        return classification;
    }

    public boolean isImported() {
        return isImported;
    }


    // COST WITH TVA INCLUDED :

    private double taxValue;
    private double costWithTaxes;

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public double getCostWithTaxes() {
        return costWithTaxes;
    }

    public void setCostWithTaxes(double costWithTaxes) {
        this.costWithTaxes = costWithTaxes;
    }

    @Override
    public String toString() {
        return "\n  isep.student.haller.Product{" +
                "name='" + name + '\'' +
                ", cost=" + initialCost +
                ", classification=" + classification +
                ", isImported=" + isImported +
                ", taxValue=" + taxValue +
                ", costWithTaxes=" + costWithTaxes +
                '}';
    }
}
