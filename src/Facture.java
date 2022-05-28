public class Facture {

    FacturationSystem facturationSystem;
    ShoppingCart shoppingCart;
    private double totalTax;
    private double totalPrice;

    public Facture(ShoppingCart shoppingCart, FacturationSystem facturationSystem) {
        this.facturationSystem = facturationSystem;
        this.shoppingCart=shoppingCart;
        this.totalTax = 0;
        this.totalPrice = 0;

        // CALCULATING PRODUCTS'S "FINAL PRICE WITH TAX" USING PROVIDED FACTURATION SYSTEM :
        this.facturationSystem.calculateTotal(shoppingCart.products);

        // CALCULATING FACTURE'S TOTAL PRICE AND TOTAL TAX :
        for (Product product:
                shoppingCart.products) {
            totalPrice+=product.getCostWithTaxes();
            totalTax+=product.getTaxValue();
        }

        // USING MATH.CEIL() AND MATH.FLOOR() TO AVOID .99999 and .00001 AFTER TOTAL PRICE AND TOTAL TAX CALCULATION :
        totalPrice=Math.ceil(totalPrice*100)/100;
        totalTax=Math.floor(totalTax*100)/100;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "\n shoppingCart=" + shoppingCart.toString() +
                ",\n totalTax=" + totalTax +
                ",\n totalPrice=" + totalPrice +
                "\n}";
    }
}
