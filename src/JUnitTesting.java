import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitTesting {

    // GENERATING TP FINAL SCENARIO AND PARAMETERS :

    FacturationSystem_TPFinal facturationSystemTPFinal = new FacturationSystem_TPFinal();

    Product importedPerfumeBottle = new Product("Imported bottle of perfume",27.99, Classification.UNCLASSIFIED,true);
    Product perfumeBottle = new Product("Bottle of perfume",18.99, Classification.UNCLASSIFIED,false);
    Product migrainePills = new Product("Box of migraine pills",9.75, Classification.MEDS,false);
    Product importedChocolateBox = new Product("Imported box of chocolate",11.25, Classification.FOOD,true);

    ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(Arrays.asList(importedPerfumeBottle, perfumeBottle, migrainePills, importedChocolateBox)));

    Facture facture = new Facture(shoppingCart, facturationSystemTPFinal);
    double expectedTotal = 74.68;
    double expectTaxTotal = 6.70;


    @Test
    public void tests_usingShoppingCartExample() {
        System.out.println("Now using: "+facture.facturationSystem.getName()+"\n");
        System.out.println(facture.toString());
        test_If_ShoppingCartTotal_Equals_ExpectedTotal();
        test_If_ShoppingCartTaxTotal_Equals_ExpectedTotal();
    }

    @Test
    public void test_If_ShoppingCartTotal_Equals_ExpectedTotal() {
        assertEquals(expectedTotal,facture.getTotalPrice());
    }

    @Test
    public void test_If_ShoppingCartTaxTotal_Equals_ExpectedTotal() {
        assertEquals(expectTaxTotal,facture.getTotalTax());
    }

}
