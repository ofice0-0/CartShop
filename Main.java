import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Item[] catalog = {
            new PhysicalItem("item1", 49.99, 2.0),
            new PhysicalItem("item2", 199.99, 8.5),
            new PhysicalItem("item3", 29.99, 0.5),
            new DigitalItem("itemd1", 39.99, "https://store.example.com/dl/antivirus"),
            new DigitalItem("itemd2", 59.99, "https://store.example.com/dl/photoeditor"),
            new DigitalItem("itemd3", 14.99, "https://store.example.com/dl/javacourse")
        };

        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("Welcome to the Store!\n");

        while (choice != 4) {
            System.out.println("1. Browse Catalog");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number (1-4).\n");
                sc.next();
                continue;
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nCatalog:");
                    for (int i = 0; i < catalog.length; i++) {
                        Item it = catalog[i];
                        String type = (it instanceof PhysicalItem) ? "Physical" : "Digital";
                        String itemNumber = (i + 1) + ".";
                        String itemName = it.getName();
                        double itemPrice = it.getBasePrice();
                        System.out.println(itemNumber + " [" + type + "] " + itemName + " - $" + itemPrice);
                    }
                    System.out.println("0. Back to menu");

                    System.out.print("Pick an item to add (number): ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input.\n");
                        sc.next();
                        break;
                    }
                    int pick = sc.nextInt();

                    if (pick == 0)
                    {
                        break;
                    }
                    if (!(pick >= 1 && pick <= catalog.length))
                    {
                        System.out.println("That's not a valid option.");
                    }
                    
                    cart.addItem(catalog[pick - 1]);

                    System.out.println();
                    break;

                case 2:
                    cart.displayCart();
                    break;

                case 3:
                    cart.checkout();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, try 1-4.\n");
                    break;
            }
        }

        sc.close();
    }
}
