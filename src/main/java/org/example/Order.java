package org.example;

import java.util.Map;

public record Order(int orderId, Map<Integer, Integer> products) {}