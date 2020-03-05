package com.epam.automation.classes.mainTask;

import java.util.Scanner;

class ConsoleApp {

    void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            printTask(choice);
        } while (scanner.hasNextLine());
    }

    private static void printTask(int choice) {
        switch (choice) {
            case 1:
                StudentList.printListOfStudentsOfDepartments();
                break;
            case 2:
                StudentList.printListOfStudentsOfDepartmentAndOfGroup();
                break;
            case 3:
                StudentList.printListOfStudentsOver1999();
                break;
            case 4:
                StudentList.printListOfStudentsOfGroup();
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Неверный ввод");
                break;
        }
    }

    private static void printMenu() {
        String task = "Пожалуйста, сделайте выбор: " + "\n" +
                "Введите 1, для проверки задания 1 (Вывести список студентов заданного факультета.)" + "\n" +
                "Введите 2, для проверки задания 2 (Вывести списки студентов для каждого факультета и курса.)" + "\n" +
                "Введите 3, для проверки задания 3 (Вывести список студентов, родившихся после заданного года.)" + "\n" +
                "Введите 4, для проверки задания 4 (Вывести список учебной группы.)" + "\n" +
                "Введите 0, выхода из программы";
        System.out.println("\n" + task + "\n");
    }

    private static void exit() {
        System.exit(0);
    }
}

