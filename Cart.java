import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    // Add a product to the cart
    public void addProduct(Product product) {
        items.add(product);
        System.out.println(product.getName() + " has been added to your cart.");
    }

    // Remove a product from the cart by ID
    public void removeProduct(int id) {
        boolean found = false;
        for (Product product : items) {
            if (product.getId() == id) {
                items.remove(product);
                System.out.println(product.getName() + " has been removed from your cart.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product with ID " + id + " not found in the cart.");
        }
    }

    // View all items in the cart
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart contains:");
            for (Product product : items) {
                System.out.println(product);
            }
        }
    }

    // Calculate the total price of the cart
    public double calculateTotal() {
        double total = 0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }
}
