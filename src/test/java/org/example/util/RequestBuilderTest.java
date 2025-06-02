package org.example.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestBuilderTest {

    @DisplayName("Given valid parameters When toPost Then build correct POST request")
    @Test
    void toPost() {
        String expected =
                "POST /orders HTTP/1.1\r\n" +
                        "Host: localhost\r\n" +
                        "Content-Length: 6\r\n" +
                        "Content-Type: application/x-www-form-urlencoded\r\n" +
                        "\r\n" +
                        "uuid=1";

        String actualRequest = RequestBuilder.toPost("/orders", "localhost", "uuid=1");
        System.out.println(actualRequest);

        assertEquals(expected, actualRequest);
    }

    @DisplayName("Given valid parameters When toGet Then build correct GET request")
    @Test
    void toGet() {
        String expected =
                "GET /orders HTTP/1.1\r\n" +
                        "Host: localhost\r\n" +
                        "\r\n";

        String actualRequest = RequestBuilder.toGet("/orders", "localhost");

        assertEquals(expected, actualRequest);
    }
}