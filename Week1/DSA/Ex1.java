import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product("P101", "Mouse", 50, 399.99);
        Product p2 = new Product("P102", "Keyboard", 30, 799.00);
        Product p3 = new Product("P103", "Monitor", 20, 6500.00);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        inventory.updateProduct("P102", 40, 750.00);
        inventory.deleteProduct("P101");

        inventory.displayAllProducts();
    }
}

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Qty: " + quantity + ", Price: ₹" + price;
    }
}

class Inventory {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.productId, product);
        System.out.println("Added: " + product.productName);
    }

    public void updateProduct(String productId, int newQty, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.quantity = newQty;
            product.price = newPrice;
            System.out.println("Updated: " + product.productName);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public void deleteProduct(String productId) {
        if (products.remove(productId) != null) {
            System.out.println("Deleted product ID: " + productId);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public void displayAllProducts() {
        System.out.println("\nCurrent Inventory:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}
