package com.example.javasomeinteviewbot.Commands;

import com.example.javasomeinteviewbot.Service.FilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Slf4j
public abstract class AbstractGetQuestionsFromFileCommand implements Command{

    @Autowired
    private FilesService questionService;

    protected List<String> questionList;

    AbstractGetQuestionsFromFileCommand(){

    }

    private void setQuestionList(){
        questionList = questionService.getQuestions(getFilename());
    }

    protected abstract String getFilename();

    public abstract String getCommandName();

    public String getAnswer() {
        if(questionList==null){
            setQuestionList();
        }
        String response = questionList.get(ThreadLocalRandom.current().nextInt(0,questionList.size()));
        log.info(response);
        return response.replaceFirst("([?])","? <tg-spoiler>")+"</tg-spoiler>";
    }
}
