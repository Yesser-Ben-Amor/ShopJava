package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int artikelNr) {
        return products.removeIf(product -> product.artikelNr() == artikelNr);
    }

    public Optional<Product> getProduct(int artikelNr) {
        return products.stream()
                .filter(product -> product.artikelNr() == artikelNr)
                .findFirst();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}