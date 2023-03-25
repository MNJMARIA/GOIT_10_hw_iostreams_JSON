package org.example.task_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private List<String> lines = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private final String FILE_PATH = "C:\\Users\\armyl\\IdeaProjects\\GOIT 10\\src\\task_2\\file.txt";
    private final String USER_FILE_PATH = "C:\\Users\\armyl\\IdeaProjects\\goit_10_hw_maven\\src\\main\\java\\org\\example\\task_2\\user.json";
    private void readFile()
    {
        // Відкриття файлу file.txt та зчитування його рядків

        try (FileInputStream fis = new FileInputStream(FILE_PATH))
        {
            Scanner scanner = new Scanner(fis);
            scanner.nextLine(); // читаємо(пропускаємо) перший рядок "name age" (оскільки даних користувача тут немає)

            //читання та запис рядків у масив прочитаних рядків
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                lines.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void fillListOfUsers()
    {
        // Обробка рядків та додавання користувачів у список
        for (String line: lines) {
            String[] parts = line.split(" ");
            try {
                User user = new User(parts[0], Integer.parseInt(parts[1]));
                users.add(user); //додали в список
            } catch(NumberFormatException e) {
                System.err.println("Некоректні дані користувача у рядку: " + line);
            }
        }
    }
    public void clearUserFile()
    {
        // очищення файлу
        try (FileWriter writer = new FileWriter(USER_FILE_PATH)) {
            writer.write("");// очистити файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeListOfUsers()
    {
        readFile();
        fillListOfUsers();
        clearUserFile();

        // Запис списку користувачів у файл user.json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        try (FileOutputStream fos = new FileOutputStream(USER_FILE_PATH)) {
            fos.write(json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
