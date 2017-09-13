package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message replay = connection.receive();
                if (replay.getType() == MessageType.USER_NAME) {
                    if (!replay.getData().isEmpty() && !connectionMap.containsKey(replay.getData())) {
                        connectionMap.put(replay.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return replay.getData();
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String key: connectionMap.keySet()) {
                if (!userName.equals(key)) {
                    connection.send(new Message(MessageType.USER_ADDED, key));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message replay = connection.receive();
                if (replay.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT,
                            String.format("%s: %s", userName, replay.getData())));
                } else {
                    ConsoleHelper.writeMessage("Wrong type of message.");
                }
            }
        }

        @Override
        public void run() {
            super.run();
            ConsoleHelper.writeMessage(String.format("Было установлено соединение с удаленным адресом %s",
                    socket.getRemoteSocketAddress()));
            try (Connection connection = new Connection(socket)) {
                String clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);
                if (!clientName.equals(null)) {
                    connectionMap.remove(clientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
                }
                System.out.println("Соединение с сервером закрыто.");
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException t) {
                System.out.println(t);
            }
        }
    }


    public static void sendBroadcastMessage(Message message) {
        for (String key : connectionMap.keySet()) {
            try {
                connectionMap.get(key).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("Не удалось отправить сообщение %s", key));
            }
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
