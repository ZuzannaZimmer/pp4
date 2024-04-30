package pl.zzimmer.ecommerce.catalog;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HashMapProductStorage implements ProductStorage {

    public HashMapProductStorage() {
        this.products = new HashMap<>();
    }

    HashMap<String, Product> products;
    @Override
    public List<Product> allProducts() {
        return products.values().stream().collect(Collectors.toList());
    }

    @Override
    public void add(Product newProduct) {
        products.put(newProduct.getId(), newProduct);
    }

    @Override
    public Product getProductBy(String id) {
        return products.get(id);
    }
}
