package org.example.util;

public class RequestBuilder {

    public static String toPost(String path, String host, String param) {
        StringBuilder sb = new StringBuilder();
        sb.append("POST ").append(path).append(" HTTP/1.1\r\n");
        sb.append("Host: ").append(host).append("\r\n");
        sb.append("Content-Length: ").append(param.length()).append("\r\n");
        sb.append("Content-Type: application/x-www-form-urlencoded\r\n");
        sb.append("\r\n");
        sb.append(param);
        return sb.toString();
    }

    public static String toGet(String path, String host) {
        StringBuilder sb = new StringBuilder();
        sb.append("GET ").append(path).append(" HTTP/1.1\r\n");
        sb.append("Host: ").append(host).append("\r\n");
        sb.append("\r\n");
        return sb.toString();
    }

}
