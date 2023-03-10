package com.example.javasomeinteviewbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class JavaSomeInteviewBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        var context =  SpringApplication.run(JavaSomeInteviewBotApplication.class, args);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(context.getBean(TelegramBot.class));

    }

}
