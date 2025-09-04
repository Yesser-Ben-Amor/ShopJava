package org.example;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void add(Order order);
    boolean remove(int orderId);
    Optional<Order> getById(int orderId);
    List<Order> getAll();
}