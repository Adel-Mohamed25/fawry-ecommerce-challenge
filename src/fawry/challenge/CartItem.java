package src.fawry.challenge;

public class CartItem {
    
    public final Product product;
    public final int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
