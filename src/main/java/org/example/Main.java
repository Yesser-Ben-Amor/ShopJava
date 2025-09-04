package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();

        // Hier kannst du wählen welche Implementation verwendet wird:

        // Option 1: OrderListRepo (List-based)
        OrderRepository orderRepo = new OrderListRepository();

        // Option 2: OrderMapRepo (Map-based) - einfach die Zeile oben auskommentieren und diese verwenden
        // OrderRepository orderRepo = new OrderMapRepo();

        ShopService shopService = new ShopService(productRepo, orderRepo);

        // Produkte hinzufügen
        productRepo.addProduct(new Product(1, "Laptop", 999.99, 10));
        productRepo.addProduct(new Product(2, "Maus", 29.99, 50));
        productRepo.addProduct(new Product(3, "Tastatur", 79.99, 30));

        // Bestellungen aufgeben
        shopService.placeOrder(1001, Map.of(1, 1, 2, 2)); // 1x Laptop, 2x Maus
        shopService.placeOrder(1002, Map.of(3, 1, 2, 1)); // 1x Tastatur, 1x Maus

        // Test mit nicht existierendem Produkt
        shopService.placeOrder(1003, Map.of(1, 1, 99, 1)); // Produkt 99 existiert nicht
    }
}