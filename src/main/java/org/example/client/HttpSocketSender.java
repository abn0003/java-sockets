package org.example.client;

import org.example.util.RequestParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpSocketSender {

    private final String hostName;
    private final int portNumber;

    public HttpSocketSender(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public String send(String input) {
        String response = null;
        try (
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), false);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            out.write(input);
            out.flush();

            response = RequestParser.parseBody(in);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return response;
    }
}
