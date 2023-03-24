package org.example.task_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    public void readFile()
    {
        final String FILE_PATH = "C:\\Users\\armyl\\IdeaProjects\\GOIT 10\\src\\task_1\\file.txt";
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNextLine()) {
                String phoneNumber = scanner.nextLine();
                if (isValidPhoneNumber(phoneNumber)) {
                    System.out.println(phoneNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Вираз для першого формату "(xxx) xxx-xxxx"
        String pattern1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        // Вираз для другого формату "xxx-xxx-xxxx"
        String pattern2 = "\\d{3}-\\d{3}-\\d{4}";

        // Перевірка номера телефону на відповідність одному з форматів
        return phoneNumber.matches(pattern1 + "|" + pattern2);
    }
}
