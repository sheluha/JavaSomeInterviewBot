package com.example.javasomeinteviewbot.Commands;

import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command{
    @Override
    public String getCommandName() {
        return "/help";
    }

    @Override
    public String getAnswer() {
        return "This is help command";
    }
}
