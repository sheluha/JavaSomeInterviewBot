package com.example.javasomeinteviewbot.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class FilesService implements QuestionsService{

    private final Path fileDirectory = Paths.get("files");

    @Override
    public List<String> getQuestions(){
        Path path = fileDirectory.resolve("core.txt");
        String fileContent;
        try {
            fileContent = String.join("\n", Files.readAllLines(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] questions = fileContent.split("\\[к оглавлению]\\(#java-core\\)");
        return Arrays.asList(questions);

    }
}
