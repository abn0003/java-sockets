package org.example.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RequestParserTest {

    @DisplayName("Given GET with query parameter When parseQueryString Then parse query string")
    @Test
    void parseQueryString() {
        String queryString = "GET /orders?uuid=be622398-cfca-4263-bcae-28dfd4d5d1c2 HTTP/1.1";
        String expected = "uuid=be622398-cfca-4263-bcae-28dfd4d5d1c2";
        String actual = RequestParser.parseQueryString(queryString);

        assertEquals(expected, actual);
    }

    @DisplayName("Given query string When parseQueryParams Then parse query params to map")
    @Test
    void parseQueryParams() {
        String expectedKey = "uuid";
        String expectedValue = "be622398-cfca-4263-bcae-28dfd4d5d1c2";
        String queryParamString = "uuid=be622398-cfca-4263-bcae-28dfd4d5d1c2";

        Map<String, String> stringStringMap = RequestParser.parseQueryParams(queryParamString);

        assertTrue(stringStringMap.containsKey(expectedKey));
        assertTrue(stringStringMap.containsValue(expectedValue));
    }

    @DisplayName("Given GET request When parseMethod Then correct method is parsed")
    @Test
    void parseMethod() {
        String request = "GET /orders?uuid=be622398-cfca-4263-bcae-28dfd4d5d1c2 HTTP/1.1";
        String actual = RequestParser.parseMethod(request);

        assertEquals("GET", actual);
    }

    @DisplayName("Given GET request When parsePath Then correct path is parsed")
    @Test
    void parsePath() {
        String request = "GET /orders?uuid=be622398-cfca-4263-bcae-28dfd4d5d1c2 HTTP/1.1";
        String actual = RequestParser.parsePath(request);

        assertEquals("/orders", actual);
    }

    @DisplayName("Given request params When parseRequestParams Then correct params are parsed")
    @Test
    void parseRequestParams() {
        String requestBody = "uuid=1";

        Map<String, String> stringStringMap = RequestParser.parseRequestParams(requestBody);

        assertTrue(stringStringMap.containsKey("uuid"));
        assertTrue(stringStringMap.containsValue("1"));
    }

    @DisplayName("Given GET request When parseFullPath Then correct path is parsed")
    @Test
    void parseFullPath() {
        String request = "GET /orders?uuid=be622398-cfca-4263-bcae-28dfd4d5d1c2 HTTP/1.1";
        String actual = RequestParser.parseFullPath(request);

        assertEquals("GET /orders", actual);
    }
}