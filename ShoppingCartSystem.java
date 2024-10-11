import java.util.Scanner;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        boolean running = true;

        // Example products
        Product[] products = {
            new Product(1, "Laptop", 800.00),
            new Product(2, "Smartphone", 500.00),
            new Product(3, "Headphones", 100.00),
            new Product(4, "Keyboard", 40.00),
            new Product(5, "Mouse", 20.00)
        };

        while (running) {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;

                case 2:
                    System.out.print("Enter the Product ID to add: ");
                    int addId = sc.nextInt();
                    boolean foundAdd = false;

                    for (Product product : products) {
                        if (product.getId() == addId) {
                            cart.addProduct(product);
                            foundAdd = true;
                            break;
                        }
                    }

                    if (!foundAdd) {
                        System.out.println("Invalid Product ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the Product ID to remove: ");
                    int removeId = sc.nextInt();
                    cart.removeProduct(removeId);
                    break;

                case 4:
                    cart.viewCart();
                    break;

                case 5:
                    double total = cart.calculateTotal();
                    System.out.println("Total cost: $" + total);
                    System.out.println("Thank you for shopping with us!");
                    running = false; // Exits after checkout
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        sc.close();
    }
}
