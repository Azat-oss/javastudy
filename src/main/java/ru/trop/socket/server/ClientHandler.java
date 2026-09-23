package ru.trop.socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    final Socket socket;
    final NetworkServer networkServer;
    PrintWriter writer;
    String name;

    public ClientHandler(Socket socket, NetworkServer networkServer) {
        this.socket = socket;
        this.networkServer = networkServer;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            writer.println("Введите ваше имя: ");
            name = reader.readLine();
            if (name == null || name.isBlank()) {
                name = "Аноним";
            }

            System.out.printf("%s вошел в чат%n", name);
            networkServer.broadcast("[СИСТЕМА] %s вошел в чат".formatted(name), this);

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("/exit")) {
                    break;
                }

                String message = "%s: %s".formatted(name, line);
                System.out.println(message);
                networkServer.broadcast(message, this);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            networkServer.removeClient(this);

            try {

                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            if (name != null) {
                System.out.printf("%s покинул чат%n", name);
                networkServer.broadcast("%s покинул чат".formatted(name), this);
            }
        }
    }

    public void send(String message) {
        writer.println(message);
    }

}
