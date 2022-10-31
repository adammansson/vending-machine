package vending.software;

import vending.inventory.Product;

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

    public double remaining() {
        return currentProduct.price() - currentlyInserted;
    }

    public void payForProduct() {
        currentlyInserted -= currentProduct.price();
        currentProduct = null;
    }

    public Product dispenseProduct() {
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
