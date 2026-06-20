package daa.ex_1;
import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.productId, product);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = products.get(productId);

        if(product != null) {
            product.quantity = quantity;
            product.price = price;
        } else {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public void displayProducts() {
        for(Product product : products.values()) {
            product.display();
        }
    }
}