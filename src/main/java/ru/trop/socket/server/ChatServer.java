package ru.trop.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class ChatServer implements NetworkServer, AutoCloseable, Runnable {
    private final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();
    private final ServerSocket socket;

    public ChatServer(int port) throws IOException {
        socket = new ServerSocket(port);
    }

    @Override
    public void run() {
        System.out.println("Starting server...");

        try (var pool = Executors.newCachedThreadPool()) {
            while (!Thread.interrupted()) {
                Socket clientSocket = socket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);

                System.out.println("Новое подключение");

                clients.add(clientHandler);
                pool.execute(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void broadcast(String message, ClientHandler source) {
        for (ClientHandler client : clients) {
            if (client != source) {
                client.send(message);
            }
        }
    }

    @Override
    public void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }
}