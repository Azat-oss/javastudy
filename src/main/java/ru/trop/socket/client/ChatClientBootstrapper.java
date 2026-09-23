package ru.trop.socket.client;

public class ChatClientBootstrapper {
    public static void main(String[] args) throws Exception {
        try (var client = new ChatClient("localhost", 55556)) {
            client.run();
        }
    }
}
