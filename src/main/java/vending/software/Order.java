package vending.software;

public class Order {

    private double currentlyInserted;
    private Product currentProduct;

    public Order() {
        this.currentlyInserted = 0;
        this.currentProduct = null;
    }
    public void insertMoney(double amount) {
        currentlyInserted += amount;
    }

    public void selectProduct(Product product) {
        this.currentProduct = product;
    }

    public boolean payed() {
        return currentlyInserted >= currentProduct.cost();
    }

    private void payForProduct() {
        currentlyInserted -= currentProduct.cost();
        currentProduct = null;
    }

    public Product payedProduct() {
        Product payedProduct = currentProduct;
        payForProduct();
        return payedProduct;
    }

    public double getChange() {
        double change = currentlyInserted;
        currentlyInserted = 0.0;
        return change;
    }
}
