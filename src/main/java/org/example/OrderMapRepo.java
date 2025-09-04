package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderMapRepo implements OrderRepository {
    private final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public void add(Order order) {
        orders.put(order.orderId(), order);
    }

    @Override
    public boolean remove(int orderId) {
        return orders.remove(orderId) != null;
    }

    @Override
    public Optional<Order> getById(int orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }

    @Override
    public List<Order> getAll() {
        return List.copyOf(orders.values());
    }
}
