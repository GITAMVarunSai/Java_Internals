import java.util.ArrayList;

class Product {
    private int productID;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(int productID, String name, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Calculate total value of product (price * quantity)
    public double totalValue() {
        return price * quantity;
    }

    // Getters for searching
    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    // Display product details
    public void displayProduct() {
        System.out.printf("ID: %d | Name: %s | Price: %.2f | Quantity: %d | Total Value: %.2f\n", 
                          productID, name, price, quantity, totalValue());
    }
}

class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    // Add product to inventory
    public void addProduct(Product product) {
        products.add(product);
    }

    // Display all products
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        System.out.println("Inventory List:");
        for (Product product : products) {
            product.displayProduct();
        }
    }

    // Calculate total inventory value
    public double totalInventoryValue() {
        double total = 0;
        for (Product product : products) {
            total += product.totalValue();
        }
        return total;
    }

    // Method Overloading: Search product by ID
    public Product searchProduct(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }

    // Method Overloading: Search product by Name
    public Product searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}

// Main Class
public class InventoryManager {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        inventory.addProduct(new Product(101, "Laptop", 75000, 5));
        inventory.addProduct(new Product(102, "Smartphone", 30000, 10));
        inventory.addProduct(new Product(103, "Tablet", 20000, 7));

        // Display all products
        inventory.displayAllProducts();

        // Calculate and display total inventory value
        System.out.printf("\nTotal Inventory Value: %.2f\n", inventory.totalInventoryValue());

        // Search for a product by ID
        int searchID = 102;
        Product foundByID = inventory.searchProduct(searchID);
        if (foundByID != null) {
            System.out.println("\nProduct found by ID:");
            foundByID.displayProduct();
        } else {
            System.out.println("\nProduct with ID " + searchID + " not found.");
        }

        // Search for a product by Name
        String searchName = "Laptop";
        Product foundByName = inventory.searchProduct(searchName);
        if (foundByName != null) {
            System.out.println("\nProduct found by Name:");
            foundByName.displayProduct();
        } else {
            System.out.println("\nProduct with name '" + searchName + "' not found.");
        }
    }
}




//output

Inventory List:
ID: 101 | Name: Laptop | Price: 75000.00 | Quantity: 5 | Total Value: 375000.00
ID: 102 | Name: Smartphone | Price: 30000.00 | Quantity: 10 | Total Value: 300000.00
ID: 103 | Name: Tablet | Price: 20000.00 | Quantity: 7 | Total Value: 140000.00

Total Inventory Value: 815000.00

Product found by ID:
ID: 102 | Name: Smartphone | Price: 30000.00 | Quantity: 10 | Total Value: 300000.00

Product found by Name:
ID: 101 | Name: Laptop | Price: 75000.00 | Quantity: 5 | Total Value: 375000.00
