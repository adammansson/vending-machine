package vending.state;

import vending.inventory.Product;

public interface State {
    void insertMoney(double amount);
    void selectProduct(Product product);
    void dispenseProduct();
    void abortOrder();
}
