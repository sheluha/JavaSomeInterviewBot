package com.example.javasomeinteviewbot.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class FilesService implements QuestionsService{

    private final Path fileDirectory = Paths.get("files");

    @Override
    public List<String> getQuestions(String filename){
        Path path = fileDirectory.resolve(filename);
        String fileContent;
        try {
            fileContent = String.join("\n", Files.readAllLines(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] questionsArray = fileContent.split("QUESTIONEND");

        log.info("FILE READED !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return Arrays.asList(questionsArray);

    }
}
