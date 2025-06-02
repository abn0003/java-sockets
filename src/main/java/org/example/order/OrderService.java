package org.example.order;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(String orderId) {
        if (orderId != null) {
            orderRepository.save(orderId);
        }
    }

    public String findOrder(String orderId) {
        String order = orderRepository.find(orderId);
        if (order != null) {
            return "Order " + orderId + " found";
        } else {
            return "Order " + orderId + " not found";
        }
    }
}
