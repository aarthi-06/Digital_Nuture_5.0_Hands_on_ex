package daa.ex_1;

public class Test {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(101, "Laptop", 10, 55000));
        inventory.addProduct(new Product(102, "Mouse", 50, 500));
        inventory.addProduct(new Product(103, "Keyboard", 25, 1200));

        inventory.displayProducts();

        inventory.updateProduct(102, 40, 450);

        inventory.deleteProduct(103);

        System.out.println("After update and delete:");

        inventory.displayProducts();
    }
}