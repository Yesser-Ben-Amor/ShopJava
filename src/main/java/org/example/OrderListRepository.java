package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderListRepository implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public boolean remove(int orderId) {
        return orders.removeIf(order -> order.orderId() == orderId);
    }

    @Override
    public Optional<Order> getById(int orderId) {
        return orders.stream()
                .filter(order -> order.orderId() == orderId)
                .findFirst();
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders);
    }
}