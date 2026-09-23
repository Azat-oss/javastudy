package ru.trop.Timeserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 7777;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

            String timeFromServer = reader.readLine();
            if (timeFromServer != null) {
                System.out.println("Время с сервера: " + timeFromServer);
            }
        }
    }
}
