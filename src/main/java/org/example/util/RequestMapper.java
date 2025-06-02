package org.example.util;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestMapper {

    public static Request from(String request, BufferedReader in) throws IOException {
        Request req = new Request();
        req.setMethod(RequestParser.parseMethod(request));
        req.setRequestLine(request);
        req.setPath(RequestParser.parsePath(request));
        req.setBody(RequestParser.parseBody(in));
        return req;
    }
}
