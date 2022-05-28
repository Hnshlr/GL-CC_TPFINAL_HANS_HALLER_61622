public enum Classification {


    UNCLASSIFIED(10),
    FOOD(0),
    BOOK(0),
    MEDS(0),
    ;

    private final int taxPercentage;

    Classification(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }
}
