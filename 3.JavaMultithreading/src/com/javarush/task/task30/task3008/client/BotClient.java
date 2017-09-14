package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", (int)(Math.random() * 100));
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            Date time = Calendar.getInstance().getTime();
            System.out.println(message);
            String[] parts = message.split(": ");
            if (parts.length == 2) {
                switch (parts[1]) {
                    case "дата":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("d.MM.YYYY").format(time)));
                        break;
                    case "день":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("d").format(time)));
                        break;
                    case "месяц":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("MMMM").format(time)));
                        break;
                    case "год":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("YYYY").format(time)));
                        break;
                    case "время":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("H:mm:ss").format(time)));
                        break;
                    case "час":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("H").format(time)));
                        break;
                    case "минуты":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("m").format(time)));
                        break;
                    case "секунды":
                        sendTextMessage(String.format("Информация для %s: %s", parts[0], new SimpleDateFormat("s").format(time)));
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
