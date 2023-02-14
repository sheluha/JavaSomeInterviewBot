package com.example.javasomeinteviewbot;

import com.example.javasomeinteviewbot.Commands.Command;
import com.example.javasomeinteviewbot.Commands.DefaultCommand;
import com.example.javasomeinteviewbot.Config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    private final Map<String, Command> commandMap;

    public TelegramBot(BotConfig botConfig, List<Command> list) {
        this.botConfig = botConfig;
        this.commandMap = list.stream().collect(Collectors.toMap(Command::getCommandName, Function.identity()));
    }

    @Override
    public void onUpdateReceived(Update update) {
        Command command = commandMap.getOrDefault(update.getMessage().getText(),new DefaultCommand());
        SendMessage response = new SendMessage(update.getMessage().getChatId().toString(),command.getAnswer());
        response.enableHtml(true);
        try {
            execute(response);
        } catch (TelegramApiException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }
    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

}
