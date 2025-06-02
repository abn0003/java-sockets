package org.example.server;

import org.example.util.Request;
import org.example.util.RequestMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpSocketReceiver {

    private final ServerRouter serverRouter;

    public HttpSocketReceiver(ServerRouter serverRouter) {
        this.serverRouter = serverRouter;
    }

    public void handle(ServerSocket serverSocket) {
        try (
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), false);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String requestLine = in.readLine();
            if (requestLine != null) {
                System.out.println("received request: " + requestLine + " " + new Date());

                Request request = RequestMapper.from(requestLine, in);
                String response = serverRouter.handleRequest(request);

                out.write(response);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
