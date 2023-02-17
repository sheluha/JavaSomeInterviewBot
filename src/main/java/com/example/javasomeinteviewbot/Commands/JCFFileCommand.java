package com.example.javasomeinteviewbot.Commands;

import org.springframework.stereotype.Component;

@Component
public class JCFFileCommand extends AbstractGetQuestionsFromFileCommand {

    @Override
    protected String getFilename() {
        return "jcf.txt";
    }

    @Override
    public String getCommandName() {
        return "/collections";
    }
}
//    private final FilesService questionService;
//
//    private List<String> questionList;
//
//    @PostConstruct
//    private void setQuestionList(){
//        questionList = questionService.getQuestions("jcf.txt");
//    }
//
//    @Override
//    public String getCommandName() {
//        return "/collections";
//    }
//
//    @Override
//    public String getAnswer() {
//        String response = questionList.get(ThreadLocalRandom.current().nextInt(0,questionList.size()));
//        System.out.println(response);
//        return response.replaceFirst("([?])","? <tg-spoiler>")+"</tg-spoiler>";
//    }
