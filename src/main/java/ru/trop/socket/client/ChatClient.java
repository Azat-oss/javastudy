package ru.trop.socket.client;

import java.io.*;
import java.net.Socket;

public class ChatClient implements AutoCloseable, Runnable {
    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;
    private final Thread serverReadingThread;

    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        serverReadingThread = new Thread(() -> {
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        serverReadingThread.setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println("Starting client...");

        serverReadingThread.start();

        try {
            var consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                writer.println(userInput);

                if (userInput.equalsIgnoreCase("/exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }
}