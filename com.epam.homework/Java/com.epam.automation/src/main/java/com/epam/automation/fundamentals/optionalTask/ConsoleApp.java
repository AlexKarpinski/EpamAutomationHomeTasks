package com.epam.automation.fundamentals.optionalTask;

import java.util.*;

class ConsoleApp {

    private static ArrayList<Integer> arrOfNum = new ArrayList<>();

    static {
        System.out.println("Введите n чисел с консоли через пробел ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner = new Scanner(s);

        while (scanner.hasNextInt()) {
            arrOfNum.add(scanner.nextInt());
        }
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            printTask(choice);
        } while (scanner.hasNextLine());
    }

    private static void printMenu() {
        String task = "Пожалуйста, сделайте выбор: " + "\n" +
                "Введите 1, для проверки задания 1.1 (Найти самое короткое число. Вывести число и их длину.)" + "\n" +
                "Введите 2, для проверки задания 1.2 (Найти самое длинное число. Вывести число и их длину.)" + "\n" +
                "Введите 3, для проверки задания 2.1 (Вывести числа в порядке возрастания значений их длины.)" + "\n" +
                "Введите 4, для проверки задания 2.2 (Вывести числа в порядке убывания значений их длины.)" + "\n" +
                "Введите 5, для проверки задания 3.1 (Вывести на консоль те числа, длина которых больше средней длины по всем числам, а также длину.)" + "\n" +
                "Введите 6, для проверки задания 3.2 (Вывести на консоль те числа, длина которых меньше больше средней длины по всем числам, а также длину.)" + "\n" +
                "Введите 7, для проверки 7-ого задания(Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.)" + "\n" +
                "Введите 0, для выхода из программы.";
        System.out.println("\n" + task + "\n");
    }

    private static void exit() {
        System.exit(0);
    }

    private static void printTask(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Задание " + choice);
                printMinOfNumbers(arrOfNum);
                break;
            case 2:
                System.out.println("Задание " + choice);
                printMaxOfNumbers(arrOfNum);
                break;
            case 3:
                System.out.println("Задание " + choice);
                printNumbersGrowUpLength(arrOfNum);
                break;
            case 4:
                System.out.println("Задание " + choice);
                printNumbersGrowDownLength(arrOfNum);
                break;
            case 5:
                System.out.println("Задание " + choice);
                printNumbersMiddleLengthUp(arrOfNum);
                break;
            case 6:
                System.out.println("Задание " + choice);
                printNumbersMiddleLengthDown(arrOfNum);
                break;
            case 7:
                System.out.println("Задание " + choice);
                printNumberWithMinDifferentCount();
                break;
            case 0:
                exit();
            default:
                System.out.println("Неверный ввод");
                break;
        }
    }

    private static void printMinOfNumbers(ArrayList<Integer> list) {
        Collections.sort(list);
        int min = Integer.toString(list.get(0)).length();
        for (Integer integer : list) {
            if (min == Integer.toString(integer).length()) {
                System.out.println("Самые короткое число: " + integer + " длина числа: " + Integer.toString(list.get(0)).length());
            }
        }
    }

    private static void printMaxOfNumbers(ArrayList<Integer> list) {
        Collections.sort(list);
        Collections.reverse(list);
        int max = Integer.toString(list.get(0)).length();
        for (Integer integer : list) {
            if (max == Integer.toString(integer).length())
                System.out.println("Самое длинное число: " + integer + " длина числа: " + Integer.toString(list.get(0)).length());
        }
    }

    private static void printNumbersGrowUpLength(ArrayList<Integer> list) {
        Collections.sort(list);
        System.out.println("Числа в порядке возрастания длины: ");
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void printNumbersGrowDownLength(ArrayList<Integer> list) {
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println("Числа в порядке убывания длины: ");
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void printNumbersMiddleLengthUp(ArrayList<Integer> list) {
        Collections.sort(list);
        System.out.println("Средняя длина чисел: " + middleLength(list));
        System.out.println("Числа, длина которых больше средней: ");
        for (int i : list) {
            if (Integer.toString(i).length() > middleLength(list))
                System.out.println(i);
        }
    }

    private static int middleLength(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += Integer.toString(i).length();
        }
        return (int) Math.round((double) sum / list.size());
    }

    private static void printNumbersMiddleLengthDown(ArrayList<Integer> list) {
        Collections.sort(list);
        System.out.println("Средняя длина чисел: " + middleLength(list));
        System.out.println("Числа, длина которых меньше средней: ");
        for (int i : list) {
            if (Integer.toString(i).length() < middleLength(list))
                System.out.println(i);
        }
    }

    /**
     * @getArrayOfCountOfSizeDifferentNumbers - массив количества различных цифр в числе
     * @printNumberWithMinDifferentCount - вывод числа, в котором количество различных цифр минимально
     */
    private static void printNumberWithMinDifferentCount() {
        ArrayList<Integer> countOfSizeDifNumbers = getArrayOfCountOfSizeDifferentNumbers(arrOfNum);
        int minCount = Collections.min(countOfSizeDifNumbers);
        System.out.println("Число, в котором количество различных цифр минимально: " + arrOfNum.get(minCount));
    }

    /**
     * @getArrayOfCountOfSizeDifferentNumbers - массив количества различных цифр в числе
     */
    private static ArrayList<Integer> getArrayOfCountOfSizeDifferentNumbers(List<Integer> list) {
        ArrayList<Integer> sameNumbersCount = new ArrayList<>();
        for (int i : list) {
            ArrayList<Integer> charOflist = getListOfChars(i);
            Collections.sort(charOflist);
            int count = 1;
            for (int j = 0; j < charOflist.size() - 1; j++) {
                if (!Objects.equals(charOflist.get(j), charOflist.get(j + 1))) {
                    count++;
                }
            }
            sameNumbersCount.add(count);
        }
        return sameNumbersCount;
    }

    /**
     * @getListOfChars массив цифр в данном числе
     */
    private static ArrayList<Integer> getListOfChars(int numberOfArray) {
        ArrayList<Integer> list = new ArrayList<>();
        while (numberOfArray != 0) {
            list.add(numberOfArray % 10);
            numberOfArray = numberOfArray / 10;
        }
        Collections.reverse(list);
        return list;
    }
}