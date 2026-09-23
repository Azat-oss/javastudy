package ru.trop.Timeserver;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    private static final int PORT = 7777;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер времени запущен на порту " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключён: " + clientSocket.getRemoteSocketAddress());

                try (PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream()), true)) {

                    String timeString = LocalDateTime.now().format(FORMATTER);
                    out.println(timeString);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    clientSocket.close();
                }
            }
        }
    }
}
