package org.example.server;

import org.example.order.OrderController;
import org.example.order.OrderRepository;
import org.example.order.OrderService;

import java.io.IOException;
import java.net.ServerSocket;

public class HttpSocketServer {

    private static final int PORT = 8082;

    public static void main(String[] args) {

        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(orderRepository);
        OrderController orderController = new OrderController(orderService);
        ServerRouter serverRouter = new ServerRouter(orderController);
        HttpSocketReceiver receiver = new HttpSocketReceiver(serverRouter);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                receiver.handle(serverSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
