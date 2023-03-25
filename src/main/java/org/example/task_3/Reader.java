package org.example.task_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Reader {
    private List<String> lines = new ArrayList<>();
    private List<String> wordsList = new ArrayList<>();
    private Map<String, Integer> result = new HashMap<>();
    private void readFile()
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
    private void createListOfWords()
    {
        for (String line: lines) {
            String[] parts = line.split(" ");
            wordsList.addAll(Arrays.asList(parts));
        }
    }
    public void countTheFrequencyOfWords()
    {
        readFile();
        createListOfWords();

        for(String word: wordsList)
        {
            if(!result.containsKey(word))
            {
                //якщо слова немає записати і сказати, що його кількість 1
                result.put(word, 1);
            }
            else
            {
                //якщо ж це слово вже є в результаті,
                // тоді дізнатись його кількість(value) і додати 1
                int count = result.get(word);
                result.put(word, count + 1);
            }
        }

        // Entry є вкладеним інтерфейсом в Java-колекції Map,
        // який представляє одну пару ключ-значення в мапі.
        for(Map.Entry<String, Integer> entry : result.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
