package org.example.util;

public class ResponseBuilder {

    public static String to200(String body) {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 200 OK\r\n");
        response.append("Content-Type: text/plain\r\n");
        response.append("Content-Length: ").append(body.length()).append("\r\n");
        response.append("\r\n");
        response.append(body);
        return response.toString();
    }

    public static String to404() {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 404 Not Found\r\n");
        response.append("Content-Length: 0\r\n");
        response.append("\r\n");
        return response.toString();
    }
}
