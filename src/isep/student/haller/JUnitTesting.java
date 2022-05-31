package isep.student.haller;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitTesting {

    // GENERATING TP FINAL SCENARIO AND PARAMETERS :

    FacturationSystemIsep facturationSystemIsep = new FacturationSystemIsep();

    Product importedPerfumeBottle = new Product("1 flacon de parfum importé",27.99, Classification.UNCLASSIFIED,true);
    Product perfumeBottle = new Product("1 flacon de parfum",18.99, Classification.UNCLASSIFIED,false);
    Product migrainePills = new Product("1 boite de pilule contre la migraine",9.75, Classification.MEDS,false);
    Product importedChocolateBox = new Product("1 boite de chocolats importés",11.25, Classification.FOOD,true);

    ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(Arrays.asList(importedPerfumeBottle, perfumeBottle, migrainePills, importedChocolateBox)));

    Invoice invoice = new Invoice(shoppingCart, facturationSystemIsep);


    // USING JUNIT TESTS TO VERIFY INDIVIDUAL/TOTAL TAX VALUES AND TOTAL PRICES :

    @Test
    public void are_AllTestsValid() {
        // PRINTING FACTURATION SYSTEM USED :
        System.out.println("Now using: Système de facturation imposé par le sujet du TP FINAL de Clean Code."+"\n");

        // PRINTING RECEIPT :
        invoice.ticketDeCaisse();

        // TESTS :
        is_ShoppingCart_TotalTaxValue_6point70();
        is_ShoppingCart_Total_74point68();

        is_ImportedParfumeBottle_TotalPrice_32point19();
        is_ParfumeBottle_TotalPrice_20point89();
        is_MigrainePills_TotalPrice_9point75();
        is_ImportedChocolateBox_TotalPrice_11point85();

        is_ImportedParfumeBottle_taxValue_4point2();
        is_ParfumeBottle_taxValue_1point9();
        is_MigrainePills_taxValue_0();
        is_ImportedChocolateBox_taxValue_0point6();
    }


    // FINAL TESTS :
    @Test
    public void is_ShoppingCart_TotalTaxValue_6point70() {
        double expectTaxTotal = 6.70;
        assertEquals(expectTaxTotal, invoice.getTotalTax());
    }
    @Test
    public void is_ShoppingCart_Total_74point68() {
        double expectedTotal = 74.68;
        assertEquals(expectedTotal, invoice.getTotalPrice());
    }

    // PRODUCT'S FINAL VALUES
    @Test
    public void is_ImportedParfumeBottle_TotalPrice_32point19() {
        double expectedTaxValue = 32.19;
        assertEquals(expectedTaxValue,importedPerfumeBottle.getCostWithTaxes());
    }
    @Test
    public void is_ParfumeBottle_TotalPrice_20point89() {
        double expectedTaxValue = 20.89;
        assertEquals(expectedTaxValue,perfumeBottle.getCostWithTaxes());
    }
    @Test
    public void is_MigrainePills_TotalPrice_9point75() {
        double expectedTaxValue = 9.75;
        assertEquals(expectedTaxValue,migrainePills.getCostWithTaxes());
    }
    @Test
    public void is_ImportedChocolateBox_TotalPrice_11point85() {
        double expectedTaxValue = 11.85;
        assertEquals(expectedTaxValue,importedChocolateBox.getCostWithTaxes());
    }

    // PRODUCT'S TAX VALUES :
    @Test
    public void is_ImportedParfumeBottle_taxValue_4point2() {
        double expectedTaxValue = 4.2;
        assertEquals(expectedTaxValue,importedPerfumeBottle.getTaxValue());
    }
    @Test
    public void is_ParfumeBottle_taxValue_1point9() {
        double expectedTaxValue = 1.9;
        assertEquals(expectedTaxValue,perfumeBottle.getTaxValue());
    }
    @Test
    public void is_MigrainePills_taxValue_0() {
        double expectedTaxValue = 0;
        assertEquals(expectedTaxValue,migrainePills.getTaxValue());
    }
    @Test
    public void is_ImportedChocolateBox_taxValue_0point6() {
        double expectedTaxValue = 0.6;
        assertEquals(expectedTaxValue,importedChocolateBox.getTaxValue());
    }
}
