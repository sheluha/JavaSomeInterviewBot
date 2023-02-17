package com.example.javasomeinteviewbot.Commands;

import org.springframework.stereotype.Component;

@Component
public class ConcurrentFileCommand extends AbstractGetQuestionsFromFileCommand{
    @Override
    protected String getFilename() {
        return "concurrency.txt";
    }

    @Override
    public String getCommandName() {
        return "/concurrency";
    }
}
