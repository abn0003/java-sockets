package org.example.order;

import org.example.util.Request;
import org.example.util.RequestParser;
import org.example.util.ResponseBuilder;

import java.util.Map;


public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public String handleRequest(Request request) {

        String method = request.getMethod();
        String path = request.getPath();

        if (method == null || method.isEmpty()) {
            return ResponseBuilder.to404();
        } else if (method.equals("GET")) {
            if ("/orders".equals(path)) {
                String query = RequestParser.parseQueryString(request.getRequestLine());
                Map<String, String> queryParams = RequestParser.parseQueryParams(query);
                String orderId = queryParams.get("uuid");
                String responseBody = orderService.findOrder(orderId);

                return ResponseBuilder.to200(responseBody);
            } else {
                return ResponseBuilder.to404();
            }

        } else if (method.equals("POST")) {
            if ("/orders".equals(path)) {
                Map<String, String> requestParams = RequestParser.parseRequestParams(request.getBody());
                String orderId = requestParams.get("uuid");
                orderService.createOrder(orderId);

                String responseBody = "Order " + orderId + " created \n";
                return ResponseBuilder.to200(responseBody);
            } else {
                return ResponseBuilder.to404();
            }
        } else {
            return ResponseBuilder.to404();
        }
    }
}
