package org.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public static String parseQueryString(String queryString) {
        if (queryString == null || queryString.isEmpty()) {
            return null;
        }

        String[] parts = queryString.split(" ");
        if (parts.length < 2) {
            return null;
        }

        String path = parts[1];
        int queryStart = path.indexOf('?');

        if (queryStart == -1) {
            return null;
        }

        return path.substring(queryStart + 1);
    }

    public static Map<String, String> parseQueryParams(String query) {
        Map<String, String> queryParams = new HashMap<>();
        if (query != null && !query.isEmpty()) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=", 2);
                if (kv.length == 2) {
                    queryParams.put(kv[0], kv[1]);
                }
            }
        }
        return queryParams;
    }

    public static String parseMethod(String input) {
        String method = null;
        if (input != null && !input.isEmpty()) {
            try {
                method = input.split(" ")[0];
            } catch (Exception e) {
                System.err.println("Parsing request method failed: " + e.getMessage());
            }
        }
        return method;
    }

    public static String parsePath(String input) {
        String fullPath = RequestParser.parseFullPath(input);
        String path = null;

        if (!fullPath.isEmpty()) {
            try {
                path = fullPath.split(" ")[1];
            } catch (Exception e) {
                System.err.println("Parsing path failed: " + e.getMessage());
            }
        }
        return path;
    }

    public static Map<String, String> parseRequestParams(String body) {
        if (body == null || body.isEmpty()) {
            return Collections.emptyMap();
        }

        String[] parts = body.split("=", 2);
        if (parts.length == 2) {
            return Collections.singletonMap(parts[0], parts[1]);
        }

        return Collections.emptyMap();
    }

    public static String parseFullPath(String fullPath) {
        if (fullPath == null || fullPath.isEmpty()) {
            return "/";
        }

        if (fullPath.contains("?")) {
            return fullPath.substring(0, fullPath.indexOf('?'));
        }

        return fullPath;
    }


    public static String parseBody(BufferedReader in) throws IOException {
        int contentLength = 0;
        String body = "";
        String requestLine;

        while ((requestLine = in.readLine()) != null && !requestLine.isEmpty()) {
            if (requestLine.toLowerCase().startsWith("content-length:")) {
                contentLength = Integer.parseInt(requestLine.split(":")[1].trim());
            }
        }

        if (contentLength > 0) {
            char[] bodyChars = new char[contentLength];
            int read = in.read(bodyChars);

            if (read != contentLength) {
                throw new IOException("Request body parsing failed, expected " + contentLength + " chars, got " + read);
            }
            body = new String(bodyChars);
        }

        return body;
    }

}
