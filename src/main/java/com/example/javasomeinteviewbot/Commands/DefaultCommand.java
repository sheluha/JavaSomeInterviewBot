package com.example.javasomeinteviewbot.Commands;

public class DefaultCommand implements Command{
    @Override
    public String getCommandName() {
        return "";
    }

    @Override
    public String getAnswer() {
        return "Wrong command";
    }
}
