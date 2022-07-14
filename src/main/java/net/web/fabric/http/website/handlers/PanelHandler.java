package net.web.fabric.http.website.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class PanelHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        OutputStream os = exchange.getResponseBody();
        String username = Arrays.getID(exchange.getRemoteAddress().getAddress());
        String response;
        if (username == null || username.equals("null")) {
            response = "<!DOCTYPE html><html><head><title>login</title><meta http-equiv = \"refresh\" content = \"0.1; url = /\" /></head><body><p>error redirecting</p></body></html>";
        } else {
            response = "Entered panel as " + username;
        }
        exchange.sendResponseHeaders(200, response.length());
        os.write(response.getBytes());
        os.close();
    }
}

