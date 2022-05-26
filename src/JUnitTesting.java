import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitTesting {

    FacturationSystem facturationSystem = new FacturationSystem();

    Product importedPerfumeBottle = new Product("Imported bottle of perfume",27.99,ProductTypes.UNCLASSIFIED,true);
    Product perfumeBottle = new Product("Bottle of perfume",18.99,ProductTypes.UNCLASSIFIED,false);
    Product migrainePills = new Product("Box of migraine pills",9.75,ProductTypes.MEDS,false);
    Product importedChocolateBox = new Product("Imported box of chocolate",11.25,ProductTypes.FOOD,true);

    ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(Arrays.asList(importedPerfumeBottle, perfumeBottle, migrainePills, importedChocolateBox)));

    Facture facture = new Facture(shoppingCart,facturationSystem);
    double expectedTotal = 74.68;


    @Test
    public void shoppingCart_test1() {
        System.out.println(facture.ticketDeCaisse());
        assertEquals(expectedTotal,facture.getTotalPrice());
    }

}
