package com.epam.automation.javaIO.optionalTask;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ConsoleApp {
    private static final String FILENAME = ".\\src/\\avaIO\\optionalTask\\resources\\IO.txt";
    private static final String PUBLIC = "public";
    private static final String PRIVATE = "private";
    private static final String CLASSREPLACEPUBLICTOPRIVATE = ".\\src\\javaIO\\optionalTask\\resources\\ForReplacePublicToPrivate.java";
    private static final String CLASSREVERSE = ".\\src\\javaIO\\optionalTask\\resources\\ForReverse.java";
    private static final String REVERSECLASS = ".\\src\\javaIO\\optionalTask\\resources\\FileWithReverseContent";
    private static final String CLASSFORUPPERCASE = ".\\src\\javaIO\\optionalTask\\resources\\ForUpperCase.java";

    private static void sortContentInFile() {
        try (FileWriter fileWriter = new FileWriter(FILENAME);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME))) {
            getFileWithRandomNumbers(fileWriter, 20);
            fileWriter.close();
            List<String> list = new ArrayList<>();
            bufferedReader.lines().sorted(Comparator.comparingInt(Integer::parseInt)).forEach(list::add);
            for (String i : list) {
                bufferedWriter.write(i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getFileWithRandomNumbers(FileWriter fileWriter, int count) {
        for (int i = 0; i < count; i++) {
            try {
                fileWriter.write(ThreadLocalRandom.current().nextInt(-100, 100) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void replacePublicToPrivate() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CLASSREPLACEPUBLICTOPRIVATE))) {
            String textLine;
            List<String> list = new ArrayList<>();
            while ((textLine = bufferedReader.readLine()) != null) {
                list.add(textLine);
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(CLASSREPLACEPUBLICTOPRIVATE))) {
                for (String line : list) {
                    bufferedWriter.append(line.replace(PUBLIC, PRIVATE)).append(System.lineSeparator());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeReverseContent() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CLASSREVERSE));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(REVERSECLASS))) {
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                for (int i = textLine.length() - 1; i >= 0; i--) {
                    bufferedWriter.write(textLine.charAt(i));
                }
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeReplaceUpperCaseContent() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CLASSFORUPPERCASE))) {
            List<String> list = new ArrayList<>();
            String[] content;
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                content = textLine.split(" ");
                list.addAll(Arrays.asList(content));
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(CLASSFORUPPERCASE))) {
                for (String word : list) {
                    bufferedWriter.write(upperCaseTwoFirstChars(word));
                    if (word.endsWith(";") || word.endsWith("{")) {
                        bufferedWriter.write("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String upperCaseTwoFirstChars(String word) {
        StringTokenizer stringTokenizer = new StringTokenizer(word);
        StringBuilder stringBuilder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            String line = stringTokenizer.nextToken();
            if (line.length() > 2) {
                stringBuilder.append(line.toLowerCase()).append(" ");
            } else {
                stringBuilder.append(line + " ");
            }
        }
        return stringBuilder.toString();
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

    private static void printTask(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Проверьте файл resources\\IO.txt");
                sortContentInFile();
                break;
            case 2:
                System.out.println("Проверьте java файл resources\\ForReplacePublicToPrivate.java");
                replacePublicToPrivate();
                break;
            case 3:
                System.out.println("Проверьте файл resources\\FileWithReverseContent");
                writeReverseContent();
                break;
            case 4:
                System.out.println("Проверьте java файл resources\\ForUpperCase.java");
                writeReplaceUpperCaseContent();
                break;
            case 0:
                exit();
            default:
                System.out.println("Неверный ввод");
                break;
        }
    }

    private static void printMenu() {
        String task = "Пожалуйста, сделайте выбор: " + "\n" +
                "Введите 1, для проверки задания 1 (Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию)" + "\n" +
                "Введите 2, для проверки задания 2 (Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private)" + "\n" +
                "Введите 3, для проверки задания 3 (Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки)" + "\n" +
                "Введите 4, для проверки задания 4 (Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными)" + "\n" +
                "Введите 0, для выхода из программы";
        System.out.println("\n" + task + "\n");
    }

    private static void exit() {
        System.exit(0);
    }
}