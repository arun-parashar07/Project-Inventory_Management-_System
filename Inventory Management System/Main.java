import java.util.*;

// CLASS 1: Product
// This class represents a single product in the inventory.

class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    // Constructor to initialize a product
    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters (to read values)
    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // Setters (to update values)
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    // To display product info in a readable way
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Qty: " + quantity + ", Price: " + price;
    }
}

// CLASS 2: InventoryManager
// This class manages the entire inventory.
// Contains methods for CRUD operations.

class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add a product to inventory
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getId())) {
            System.out.println("Product with ID " + product.getId() + " already exists!");
        } else {
            inventory.put(product.getId(), product);
            System.out.println("Product added successfully.");
        }
    }

    // Remove a product by ID
    public void removeProduct(int id) {
        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    // Update product quantity or price
    public void updateProduct(int id, int newQuantity, double newPrice) {
        Product product = inventory.get(id);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    // Search product by ID
    public void searchProduct(int id) {
        Product product = inventory.get(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    // Display all products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    // Calculate total value of inventory (Quantity × Price)
    public void calculateTotalValue() {
        double total = 0;
        for (Product product : inventory.values()) {
            total += product.getQuantity() * product.getPrice();
        }
        System.out.println("Total Inventory Value: " + total);
    }
}

// CLASS 3: Main
// This is the entry point of the program.


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        while (true) {
            System.out.println("\n--- Inventory Management System---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Search Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Calculate Total Value");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    manager.addProduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    id = scanner.nextInt();
                    manager.removeProduct(id);
                    break;

                case 3:
                    System.out.print("Enter Product ID to update: ");
                    id = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    qty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    price = scanner.nextDouble();
                    manager.updateProduct(id, qty, price);
                    break;

                case 4:
                    System.out.print("Enter Product ID to search: ");
                    id = scanner.nextInt();
                    manager.searchProduct(id);
                    break;

                case 5:
                    manager.displayInventory();
                    break;

                case 6:
                    manager.calculateTotalValue();
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
