package com.epam.automation.fundamentals.optionalTaskMatrix;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class ConsoleApp {
    private static int[][] matrix;
    private static Scanner scanner;
    private static int SIZEOFMATRIX;
    private static ArrayList<Integer> listOfNumbers = new ArrayList<>();

    static {
        System.out.println("Введите размерность матрицы");
        scanner = new Scanner(System.in);
        SIZEOFMATRIX = scanner.nextInt();
        matrix = new int[SIZEOFMATRIX][SIZEOFMATRIX];
        System.out.println("Матрица: ");
        for (int i = 0; i < SIZEOFMATRIX; i++) {
            for (int j = 0; j < SIZEOFMATRIX; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(-100, 101);
                System.out.print(matrix[i][j] + "\t");
                listOfNumbers.add(matrix[i][j]);
            }
            System.out.println();
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
                "Введите 1, для проверки задания 1 (Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.)" + "\n" +
                "Введите 2, для проверки задания 2 (Найти и вывести наибольшее число возрастающих элементов матрицы, идущих подряд.)" + "\n" +
                "Введите 0, для выхода из программы.";
        System.out.println("\n" + task + "\n");
    }

    private static void exit() {
        System.exit(0);
    }

    private static void printSortMatrix() {
        System.out.println("Введите номер k - столбца ");
        int k = scanner.nextInt() - 1;
        List<int[]> matrixList = Arrays.asList(matrix);
        matrixList.sort(Comparator.comparingInt(a2 -> a2[k]));
        for (int i = 0; i < SIZEOFMATRIX; i++) {
            for (int j = 0; j < SIZEOFMATRIX; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int getCountOfMaxGrowUpNumbers(ArrayList<Integer> elementsOfMatrix) {
        int count = 1;
        ArrayList<Integer> listOfCountGrowUpNumbers = new ArrayList<>();
        ArrayList<Integer> listOfIndex = new ArrayList<>();
        for (int i = 0; i < elementsOfMatrix.size() - 1; i++) {
            if (elementsOfMatrix.get(i) < elementsOfMatrix.get(i + 1)) {
                count++;
                listOfCountGrowUpNumbers.add(count);
            } else count = 1;
        }
        System.out.println(listOfIndex);
        return Collections.max(listOfCountGrowUpNumbers);
    }

    private static void printTask(int choice) {
        switch (choice) {
            case 1:
                printSortMatrix();
                break;
            case 2:
                System.out.println("Наибольшее количесвто возрастающих элементов в матрице: " + getCountOfMaxGrowUpNumbers(listOfNumbers));
                break;
            case 0:
                exit();
            default:
                System.out.println("Неверный ввод");
                break;
        }
    }
}


