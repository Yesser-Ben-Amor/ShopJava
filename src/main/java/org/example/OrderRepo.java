package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public Order getOrder(int orderId) {
        return orders.stream()
                .filter(order -> order.orderId() == orderId)
                .findFirst()
                .orElse(null);
    }
}
