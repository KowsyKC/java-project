package Mini_projects.inventory_management;

import java.util.HashMap;
import java.util.Map;

class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        inventory.put(name, product);
    }

    public Product getProduct(String name) {
        return inventory.get(name);
    }

    public void updateProductQuantity(String name, int newQuantity) {
        Product product = inventory.get(name);
        if (product != null) {
            product.quantity = newQuantity;
        }
    }

    public void removeProduct(String name) {
        inventory.remove(name);
    }
}
