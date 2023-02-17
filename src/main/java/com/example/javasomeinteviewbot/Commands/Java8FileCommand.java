package com.example.javasomeinteviewbot.Commands;

import org.springframework.stereotype.Component;

@Component
public class Java8FileCommand extends AbstractGetQuestionsFromFileCommand{
    @Override
    protected String getFilename() {
        return "java8.txt";
    }

    @Override
    public String getCommandName() {
        return "/java8";
    }
}
