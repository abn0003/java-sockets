package org.example.server;

import org.example.order.OrderController;
import org.example.util.Request;
import org.example.util.ResponseBuilder;

public class ServerRouter {

    private final OrderController orderController;

    public ServerRouter(OrderController orderController) {
        this.orderController = orderController;
    }

    public String handleRequest(Request request) {
        return switch (request.getPath()) {
            case "/order", "/orders" -> orderController.handleRequest(request);
            default -> ResponseBuilder.to404();
        };
    }

}
