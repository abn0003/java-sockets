package org.example.order;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderRepository {

    private static final Map<String, String> orderMap = new ConcurrentHashMap<>();

    public void save(String orderId) {
        orderMap.put(orderId, "CREATED");
    }

    public String find(String orderId) {
        return orderMap.getOrDefault(orderId, null);
    }
}
