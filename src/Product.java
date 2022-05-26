public class Product {

    // PRODUCT DEFINING :

    private String name;
    private double cost;
    private ProductTypes classification;
    private boolean isImported;


    public Product() {
    }

    public Product(String name, double cost, ProductTypes productType, boolean isImported) {
        this.name = name;
        this.cost = cost;
        this.classification = productType;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public ProductTypes getClassification() {
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
}
