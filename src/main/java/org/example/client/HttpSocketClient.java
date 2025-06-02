package org.example.client;

import org.example.util.RequestBuilder;

import java.util.UUID;

public class HttpSocketClient {

    private static final String HOST_NAME = "localhost";
    private static final int PORT = 8082;

    public static void main(String[] args) {

        HttpSocketSender client = new HttpSocketSender(HOST_NAME, PORT);

        //post order
        String orderId = UUID.randomUUID().toString();
        String postOrderReq = RequestBuilder.toPost("/orders", HOST_NAME, "uuid=" + orderId);
        String postOrdersResp = client.send(postOrderReq);
        System.out.println("--- POST Response ---");
        System.out.println(postOrdersResp);

        //get order
        String getOrders = RequestBuilder.toGet("/orders?uuid=" + orderId, HOST_NAME);
        String getOrdersResp = client.send(getOrders);
        System.out.println("--- GET Response ---");
        System.out.println(getOrdersResp);
    }
}
