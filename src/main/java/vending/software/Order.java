package vending.software;

import vending.product.Product;

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
        return currentProduct.cost() - currentlyInserted;
    }

    public void payForProduct() {
        currentlyInserted -= currentProduct.cost();
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
