package com.epam.automation.fundamentals.mainTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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

    /**
     * 1 - Приветствовать любого пользователя при вводе его имени через командную строку.
     */
    private static void hello() {
        System.out.print("Введите ваше имя, пожалуйста ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Привет " + name);
    }

    /**
     * 2 - Отобразить в окне консоли аргументы командной строки в обратном порядке.
     */
    private static void printReverseOfArgs() {
        System.out.println("Введите аргументы командной строки через пробел ");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listOfArgs = new ArrayList<>();
        String args = scanner.nextLine();
        scanner = new Scanner(args);
        while (scanner.hasNext()) {
            listOfArgs.add(scanner.next());
        }
        Collections.reverse(listOfArgs);
        System.out.println("Аргументы командной строки в обратном порядке");
        for (String arg : listOfArgs) {
            System.out.print(arg + " ");
        }
    }

    /**
     * 3 - Вывести заданное количество случайных чисел без перехода на новую строку
     */
    private static void printRandomNumbers() {
        System.out.println("Введите количество случайных чисел ");
        Scanner scanner = new Scanner(System.in);
        int numOfRandNum = scanner.nextInt();
        Random random = new Random();
        for (int i = 0; i < numOfRandNum; i++) {
            System.out.print(random.nextInt() + " ");
        }
    }

    /**
     * 4 - Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и
     * вывести результат на консоль.
     */
    private static void printMultiplicationOfArgs() {
        System.out.println("Введите n чисел через пробел ");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        String s = scanner.nextLine();
        scanner = new Scanner(s);
        while (scanner.hasNextInt()) {
            listOfNumbers.add(scanner.nextInt());
        }
        long multiplication = 1;
        for (Integer listOfNumber : listOfNumbers) {
            multiplication = multiplication * listOfNumber;
        }
        System.out.println("Multiplication = " + multiplication);
    }

    /**
     * 5 - Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
     * Осуществить проверку корректности ввода чисел.
     */
    private static void printNumberOfMonth() {
        System.out.print("Введите номер месяца ");
        Scanner scanner = new Scanner(System.in);
        int numOfMonth = scanner.nextInt();
        switch (numOfMonth) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Введен неверный номер месяца");
                break;
        }
    }

    private static void printTask(int choice) {
        switch (choice) {
            case 1:
                hello();
                break;
            case 2:
                printReverseOfArgs();
                break;
            case 3:
                printRandomNumbers();
                break;
            case 4:
                printMultiplicationOfArgs();
                break;
            case 5:
                printNumberOfMonth();
                break;
            case 0:
                exit();
            default:
                System.out.println("Неверный ввод");
                break;
        }
    }

    private static void exit() {
        System.exit(0);
    }

    private static void printMenu() {
        String task = "Пожалуйста, сделайте выбор: " + "\n" +
                "Введите 1, для проверки задания 1 (Приветствовать любого пользователя)" + "\n" +
                "Введите 2, для проверки задания 2 (Аргументы командной строки в обратном порядке)" + "\n" +
                "Введите 3, для проверки задания 3 (Вывести заданное количество случайных чисел без перехода на новую строку)" + "\n" +
                "Введите 4, для проверки задания 4 (Подсчитать произведение аргументов командной строки)" + "\n" +
                "Введите 5, для проверки задания 5 (Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.)" + "\n" +
                "Введите 0, для выхода из программы.";
        System.out.println("\n" + task + "\n");
    }
}