public enum ProductTypes {


    UNCLASSIFIED(10),
    FOOD(0),
    BOOK(0),
    MEDS(0),
    ;

    private int taxPercentage;

    ProductTypes(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }
}
