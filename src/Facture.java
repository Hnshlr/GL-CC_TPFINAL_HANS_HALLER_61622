import java.util.List;

public class Facture {

    ShoppingCart shoppingCart;
    private double taxPrice;
    private double totalPrice;

    public Facture(ShoppingCart shoppingCart, FacturationSystem facturationSystem) {
        this.shoppingCart=shoppingCart;
        this.taxPrice = 0;
        this.totalPrice = 0;

        facturationSystem.calculateTotal(shoppingCart.products);
        for (Product product:
                shoppingCart.products) {
            totalPrice+=product.getCostWithTaxes();
            taxPrice+=Math.floor((product.getCostWithTaxes()- product.getCost())*100)/100;
        }
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String ticketDeCaisse() {
        return "Facture{" +
                "shoppingCart=" + shoppingCart +
                ", taxPrice=" + taxPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
