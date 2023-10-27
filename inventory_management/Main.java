package Mini_projects.inventory_management;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Adding products to the inventory
        inventoryManager.addProduct("Product1", 29.99, 50);
        inventoryManager.addProduct("Product2", 39.99, 30);

        // Retrieving and updating product quantity
        Product product1 = inventoryManager.getProduct("Product1");
        if (product1 != null) {
            System.out.println("Product: " + product1.getName() +
                    ", Price: $" + product1.getPrice() +
                    ", Quantity: " + product1.getQuantity());

            inventoryManager.updateProductQuantity("Product1", 40);

            System.out.println("Updated Quantity: " + product1.getQuantity());
        }

        // Removing a product from the inventory
        inventoryManager.removeProduct("Product2");
        Product product2 = inventoryManager.getProduct("Product2");
        if (product2 == null) {
            System.out.println("Product2 has been removed from the inventory.");
        }
    }
}
