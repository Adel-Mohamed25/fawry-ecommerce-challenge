package src.fawry.challenge;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Sample products
        Cheese cheese = new Cheese("Cheddar Cheese", 120.0, 10, 0.5, LocalDate.now().plusDays(5));
        TV tv = new TV("Samsung 55\" TV", 18000.0, 3, 12.0);
        MobileCard card = new MobileCard("Vodafone 100EGP Card", 100.0, 50);

        // Customer
        Customer customer = new Customer("Adel", 20000.0);

        // Build cart
        customer.getCart().addItem(cheese, 2);
        customer.getCart().addItem(tv, 1);
        customer.getCart().addItem(card, 3);

        // Checkout
        try {
            customer.checkout();
        } catch (Exception ex) {
            System.err.println("Checkout failed: " + ex.getMessage());
        }
    }
}