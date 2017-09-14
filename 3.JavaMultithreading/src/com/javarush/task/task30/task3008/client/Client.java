package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        System.out.println("Введитье адрес сервера");
        return ConsoleHelper.readString();

    }

    protected int getServerPort() {
        System.out.println("Введитье порт сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        System.out.println("Введитье имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            e.printStackTrace();
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
            if (clientConnected == true) {
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");

            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
            while (clientConnected) {
                String text = ConsoleHelper.readString();
                if (text.equals("exit")) {
                    break;
                }
                if (shouldSendTextFromConsole()) {
                    sendTextMessage(text);
                }

            }
        }

    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("Участник с именем %s присоединился к чату.", userName));
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("Участник с именем %s покинул к чат.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();

            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            boolean check = true;
            while (check) {
                Message replay = connection.receive();
                if (replay.getType() == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                } else if (replay.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    check = false;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message serverReplay = connection.receive();
                if (serverReplay.getType() == MessageType.TEXT) {
                    processIncomingMessage(serverReplay.getData());
                } else if (serverReplay.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(serverReplay.getData());
                }  else if (serverReplay.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(serverReplay.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            String serverAdress = getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket socket = new Socket(serverAdress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException t) {
                notifyConnectionStatusChanged(false);
            }
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
