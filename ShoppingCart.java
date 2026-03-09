import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> cartItems;
    private double totalAmount;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
        totalAmount = 0.0;
    }

    public void addItem(Item item) {
        cartItems.add(item);
        System.out.println(">> Added \"" + item.getName() + "\" to cart.");
    }

    public void removeItem(Item item) {
        if (cartItems.remove(item)) {
            System.out.println(">> Removed \"" + item.getName() + "\" from cart.");
        } else {
            System.out.println(">> Item not found in cart.");
        }
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\nYour Cart:");
        for (int i = 0; i < cartItems.size(); i++) {
            Item cur = cartItems.get(i);
            System.out.println((i + 1) + ". " + cur.getName() + " - $" + cur.calculateFinalPrice());
        }
        System.out.println();
    }

    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty, nothing to checkout.");
            return;
        }

        totalAmount = 0;
        System.out.println("\nReceipt:");
        for (Item item : cartItems) {
            double price = item.calculateFinalPrice();
            totalAmount += price;
            System.out.println("- " + item.getName() + " : $" + price);
            if (item instanceof DigitalItem) {
                System.out.println("  Download: " + ((DigitalItem) item).getDownloadLink());
            }
        }
        System.out.println("Total: $" + totalAmount);
        System.out.println("Thanks for your purchase!\n");

        cartItems.clear();
        totalAmount = 0;
    }

    public int getItemCount() {
        return cartItems.size();
    }
}
