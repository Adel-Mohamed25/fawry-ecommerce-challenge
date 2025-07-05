package src.fawry.challenge;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private double balance;
    private final ShoppingCart cart = new ShoppingCart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public ShoppingCart getCart() { return cart; }

    public void checkout() throws Exception {
        if (cart.isEmpty()) throw new Exception("Cart is empty!");

        // Check availability & expiry
        for (CartItem ci : cart.getItems()) {
            Product p = ci.product;
            if (p.isExpired()) throw new Exception("Product expired: " + p.getName());
            if (ci.quantity > p.getQuantity()) throw new Exception("Out of stock: " + p.getName());
        }

        double subtotal = cart.getSubtotal();

        List<Shippable> toShip = new ArrayList<>();
        for (CartItem ci : cart.getItems()) {
            if (ci.product instanceof Shippable)
                toShip.add((Shippable) ci.product);
        }

        double shippingFees = toShip.isEmpty() ? 0.0 : ShippingService.ship(toShip);
        double total = subtotal + shippingFees;

        if (balance < total) throw new Exception("Insufficient balance!");

        // Deduct quantities & balance
        for (CartItem ci : cart.getItems()) {
            ci.product.decreaseQuantity(ci.quantity);
        }
        balance -= total;

        // Print receipt
        System.out.println("\n===== Checkout Summary =====");
        System.out.printf("Subtotal:       %.2f%n", subtotal);
        System.out.printf("Shipping Fees:  %.2f%n", shippingFees);
        System.out.printf("Total Paid:     %.2f%n", total);
        System.out.printf("New Balance:    %.2f%n", balance);
        System.out.println("============================\n");
    }
}
