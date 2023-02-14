package com.example.javasomeinteviewbot.Commands;

import com.example.javasomeinteviewbot.Service.FilesService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuestionCommand implements Command {

    private final FilesService questionService;

    List<String> questionList;

    @PostConstruct
    private void setQuestionList(){
        questionList = questionService.getQuestions();
    }


    @Override
    public String getCommandName() {
        return "/question";
    }

    @Override
    public String getAnswer() {
        String response = questionList.get(ThreadLocalRandom.current().nextInt(0,questionList.size()));
        return response.replaceFirst("([?])","<tg-spoiler>")+"</tg-spoiler>";
    }
}
