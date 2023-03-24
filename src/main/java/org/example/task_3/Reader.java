package org.example.task_3;

import org.example.task_2.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    List<String> lines = new ArrayList<>();
    List<String> words = new ArrayList<>();
    public void readFile()
    {
        final String FILE_PATH = "C:\\Users\\armyl\\IdeaProjects\\GOIT 10\\src\\task_3\\words.txt";
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public void createListOfWords()
    {
        for (String line: lines) {
            String[] parts = line.split(" ");
            try {
                String word = (parts[0], parts[1]);
                words.add(word); //додали в список
            } catch(NumberFormatException e) {
                System.err.println("Некоректні дані користувача у рядку: " + line);
            }
    }*///TODO розділення рядків на лова(записати слова в список)
    //TODO інше завдання
}
