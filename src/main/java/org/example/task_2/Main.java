package org.example.task_2;

public class Main {
    public static void main(String[] args)  {
        FileHandler fileHandler = new FileHandler();
        fileHandler.clearUserFile();
        fileHandler.writeListOfUsers();
        //TODO очистку файла перед запуском і записом користувачів(може треба flush, close)
    }
}
