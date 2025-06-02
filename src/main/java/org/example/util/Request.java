package org.example.util;

public class Request {
    private String method; // = RequestParser.parseMethod(requestLine);
    private String requestLine;// = RequestParser.extractPath(requestLine);
    private String path; //= RequestParser.parsePath(fullPath);
    private String body; //= RequestParser.readRequestBody(in);

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
