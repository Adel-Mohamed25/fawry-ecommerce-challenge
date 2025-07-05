package src.fawry.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        if (qty > product.getQuantity())
            throw new IllegalArgumentException("Requested qty exceeds stock for " + product.getName());
        items.add(new CartItem(product, qty));
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public double getSubtotal() {
        return items.stream()
                .mapToDouble(ci -> ci.product.getPrice() * ci.quantity)
                .sum();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}

