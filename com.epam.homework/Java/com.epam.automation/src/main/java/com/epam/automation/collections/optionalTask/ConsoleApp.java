package com.epam.automation.collections.optionalTask;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ConsoleApp {
    private static String fileName = ".\\src\\collections\\optionalTask\\Believer.pub";

    void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            printTask(choice);
        } while (scanner.hasNextLine());
    }

    private static void writeSortContentInFile(String fileName) {
        try (Scanner content = new Scanner(new java.io.File(fileName))) {
            List<String> reverseContent = new ArrayList<>();
            while (content.hasNextLine()) {
                reverseContent.add(content.nextLine());
            }
            Collections.reverse(reverseContent);
            try (FileWriter writer = new FileWriter(fileName)) {
                for (String lineOfContent : reverseContent) {
                    writer.write(lineOfContent + System.getProperty("line.separator"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printNumberWithReverseChars() {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        String numb = scanner.nextLine();
        int number = Integer.parseInt(numb);
        Stack<Integer> stack = StackOfChars(number);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    private static Stack<Integer> StackOfChars(int number) {
        Stack<Integer> stack = new Stack<>();
        while (number != 0) {
            stack.push(number % 10);
            number = number / 10;
        }
        Collections.reverse(stack);
        return stack;
    }

    private static void printSortPoem() {
        String POEM = "Я вас любил: любовь еще, быть может,\n" +
                "В душе моей угасла не совсем;\n" +
                "Но пусть она вас больше не тревожит;\n" +
                "Я не хочу печалить вас ничем.\n" +
                "Я вас любил безмолвно, безнадежно,\n" +
                "То робостью, то ревностью томим;\n" +
                "Я вас любил так искренно, так нежно,\n" +
                "Как дай вам бог любимой быть другим.\n";
        System.out.println("Начальный вид:\n" + POEM);
        List<String> listPoem = Arrays.asList(POEM.split("\n"));
        listPoem.sort(Comparator.comparingInt(String::length));
        System.out.println("Сортировка:");
        for (String line : listPoem) {
            System.out.println(line);
        }
    }

    /**
     * (1)перестановка отрицательных элементов в начало,(2) а положительных в конец
     */
    private static void sortElements() {
        final int sizeList = ThreadLocalRandom.current().nextInt(2, 20);
        final List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < sizeList; i++) {
            numbers.add(ThreadLocalRandom.current().nextInt(-100, 101));
        }
        System.out.println(numbers);
        int element;
        for (int i = 0; i < sizeList; i++) {
            if (numbers.get(i) < 0) {           //(1)
                element = numbers.get(i);
                numbers.remove(i);
                numbers.add(0, element);
            } else if (numbers.get(i) > 0) {    //(2)
                element = numbers.get(i);
                numbers.remove(i);
                numbers.add(element);
            }
        }
        System.out.println(numbers);
    }

    private static void printSortedContent(String fileName) {
        try (Scanner content = new Scanner(new java.io.File(fileName))) {
            List<String> lines = new ArrayList<>();
            while (content.hasNextLine()) lines.add(content.nextLine());
            System.out.println("Начальнве данные:\n");
            for (String line : lines) System.out.println(line);
            lines.sort((o1, o2) -> o2.length() - o1.length());
            System.out.println("\nСортировка:\n");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printTask(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Задание " + choice);
                writeSortContentInFile(fileName);
                System.out.println("Проверьте файл");
                break;
            case 2:
                System.out.println("Задание " + choice);
                printNumberWithReverseChars();
                break;
            case 3:
                System.out.println("Задание " + choice);
                printSortPoem();
                break;
            case 4:
                System.out.println("Задание " + choice);
                sortElements();
                break;
            case 0:
                exit();
            default:
                printSortedContent(fileName);
                break;
        }
    }

    private static void exit() {
        System.exit(0);
    }

    private static void printMenu() {
        String task = "Пожалуйста, сделайте выбор: " + "\n" +
                "Введите 1, для проверки задания 1 (Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.)" + "\n" +
                "Введите 2, для проверки задания 2 (Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.)" + "\n" +
                "Введите 3, для проверки задания 3 (Занести стихотворение в список. Провести сортировку по возрастанию длин строк.)" + "\n" +
                "Введите 4, для проверки задания 4 (Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка." + "\n" +
                "Введите 5, для проверки задания 5 (Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.)" + "\n" +
                "Введите 0, для выхода из программы.";
        System.out.println("\n" + task + "\n");
    }
}







