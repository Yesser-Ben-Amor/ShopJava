package org.example;

import java.util.Map;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepository orderRepository;

    public ShopService(ProductRepo productRepo, OrderRepository orderRepository) {
        this.productRepo = productRepo;
        this.orderRepository = orderRepository;
    }

    public void placeOrder(int orderId, Map<Integer, Integer> productsOrdered) {
        for (int artikelNr : productsOrdered.keySet()) {
            if (productRepo.getProduct(artikelNr).isEmpty()) {
                System.out.println("Bestellung abgelehnt: Produkt mit ArtikelNr " + artikelNr + " existiert nicht.");
                return;
            }
        }

        Order newOrder = new Order(orderId, productsOrdered);
        orderRepository.add(newOrder);
        System.out.println("Bestellung " + orderId + " erfolgreich aufgegeben.");
    }
}