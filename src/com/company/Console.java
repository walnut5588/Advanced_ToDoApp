package com.company;

import java.util.List;
import java.util.Scanner;

public class Console {
    private static final String GREEN = "\u001b[32m";
    private static final String RED = "\u001b[31m";
    private static final String YELLOW = "\u001b[33m";
    private static final String RESET = "\u001b[0m";
    private static final Scanner scanner = new Scanner(System.in);

    public static void info(String s) {
        System.out.println(GREEN + "Info: " + RESET + s);
    }

    public static void error(String s) {
        System.out.println(RED + "Error: " + RESET + s);
    }

    public static void warning(String s) {
        System.out.println(YELLOW + "Warning: " + RESET + s);
    }

    public static void listTodos(List<Todo> todos) {
        int i = 1;
        if (!todos.isEmpty()) {
            for (Todo todo :
                    todos) {
                System.out.println("----- " + i + ". -----");
                System.out.println("Name: " + todo.getName());
                System.out.println("Description: " + todo.getDescription());
                if (todo.isFinished()) {
                    System.out.println("It's finished! :)");
                } else {
                    System.out.println("In progress...");
                }
                ++i;
            }
        } else {
            Console.warning("Your Todo list is empty!");
        }
    }

    public static int getInt() {
        int input = 0;
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            error("Please use numbers!");
        }
        return input;
    }

    public static String getString(String s) {
        System.out.print(s + ": ");
        return scanner.nextLine();
    }
}