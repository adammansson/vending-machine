package vending.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<String, Product> productMap;

    public Inventory() {
        this.productMap = new HashMap<>();
        productMap.put("00", new Product(5.0, "Snack"));
        productMap.put("01", new Product(10.0, "Drink"));
    }

    public Product getProductById(String id) throws ProductParseException {
        if (!productMap.containsKey(id)) throw new ProductParseException("Product not found");
        return productMap.get(id);
    }
}
