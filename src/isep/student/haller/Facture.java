package isep.student.haller;

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

        // CORRECTING FLOAT ERRORS (.99999 and .00001 ISSUES CAUSED BY "* 2 ^ EXP" DOUBLE REPRESENTATION)   :
        totalPrice=DoubleHandler.correctFloatValue(totalPrice);
        totalTax=DoubleHandler.correctFloatValue(totalTax);
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "isep.student.haller.Facture{" +
                "\n shoppingCart=" + shoppingCart.toString() +
                ",\n totalTax=" + totalTax +
                ",\n totalPrice=" + totalPrice +
                "\n}";
    }

    public String ticketDeCaisse() {
        for (Product product: shoppingCart.products) {
            System.out.println(product.getName()+" : "+product.getInitialCost());
        }
        System.out.println("Montant des taxes : "+totalTax);
        System.out.println("Total : "+totalPrice);
        return null;
    }
}
