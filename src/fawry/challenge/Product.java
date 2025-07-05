package src.fawry.challenge;

public abstract class Product {
    protected final String name;
    protected final double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    /** Returns true if the product is expired. Non‑perishable items default to false. */
    public boolean isExpired() { return false; }

    /** Decrease quantity when purchased. */
    public void decreaseQuantity(int amount) {
        if (amount > quantity)
            throw new IllegalArgumentException("Not enough stock for " + name);
        quantity -= amount;
    }
}
