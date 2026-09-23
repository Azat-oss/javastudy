package ru.trop.socket.server;

public interface NetworkServer {
    void broadcast(String message, ClientHandler source);

    void removeClient(ClientHandler clientHandler);
}
