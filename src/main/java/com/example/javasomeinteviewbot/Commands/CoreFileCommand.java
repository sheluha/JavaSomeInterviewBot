package com.example.javasomeinteviewbot.Commands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CoreFileCommand extends AbstractGetQuestionsFromFileCommand {

    @Override
    protected String getFilename() {
        return "core.txt";
    }

    @Override
    public String getCommandName() {
        return "/core";
    }
}
