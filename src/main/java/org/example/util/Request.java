package org.example.util;

public class Request {
    private String method;
    private String requestLine;
    private String path;
    private String body;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRequestLine() {
        return requestLine;
    }

    public void setRequestLine(String requestLine) {
        this.requestLine = requestLine;
    }
}
