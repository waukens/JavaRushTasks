package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
    public static void main(String[] args) {
        int socketPort = ConsoleHelper.readInt();
        try (ServerSocket ss = new ServerSocket(socketPort); ) {
        ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                    Socket socket = ss.accept();
                    new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Oops!");
        } finally {

        }

    }
}
