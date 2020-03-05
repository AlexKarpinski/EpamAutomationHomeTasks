package com.epam.automation.classes.mainTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class StudentList {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1084899, "Бакина", "Виталия", "Викторовна", 2000, "Минск", "+375291234576", "Физический", "4", "2"));
        students.add(new Student(1084435, "Силициум", "Иван", "Петрович", 1999, "Минск", "+375291234756", "Физический", "3", "2"));
        students.add(new Student(1081355, "Попова", "Анастасия", "Ивановна", 2001, "Москва", "+375291233333", "Физический", "3", "2"));
        students.add(new Student(1086844, "Адвокат", "Виктория", "Алексеевна", 2000, "Киев", "+375297654321", "Физический", "4", "3"));
        students.add(new Student(1086877, "Семенов", "Виктор", "Павлович", 2001, "ФПМИ", "3", "2"));
        students.add(new Student(1548752, "Иванова", "Алиса", "Степановна", 1998, "ФПМИ", "3", "2"));
        students.add(new Student(1082134, "Орлова", "Анна", "Сергеевна", 1999, "Логойск", "+375298010027", "Физический", "4", "3"));
    }

    static void printListOfStudentsOfDepartments() {
        String department;
        do {
            System.out.println("Введите факультет(1 - Физический или 2 - ФПМИ)");
            Scanner scanner = new Scanner(System.in);
            department = scanner.next();
            if (department.equals("1")) {
                department = "Физический";
                break;
            }
            if (department.equals("2")) {
                department = "ФПМИ";
                break;
            }
        } while (true);

        int count = 0;
        System.out.println("Список студентов факультета - " + department + ":");
        for (Student student : students) {
            if (student.getDepartment().equals(department)) {
                System.out.println(student);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Таких студентов не найдено");
        }
    }

    static void printListOfStudentsOfDepartmentAndOfGroup() {
        students.sort(Comparator.comparing(Student::getDepartment));
        students.sort(Comparator.comparing(Student::getCourse));
        System.out.println("Список студентов, отсортированный по факультетам и курсам:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    static void printListOfStudentsOver1999() {
        System.out.println("Введите год рождения");
        Scanner scanner = new Scanner(System.in);
        int yearOfBirthday = scanner.nextInt();
        int count = 0;
        System.out.println("Список студентов, которые родились после " + yearOfBirthday + "года:");
        for (Student student : students) {
            if (student.getYearOfBirthday() > yearOfBirthday) {
                System.out.println(student);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Таких студентов не найдено");
        }
    }

    static void printListOfStudentsOfGroup() {
        String department;
        Scanner scanner;
        do {
            System.out.println("Введите факультет(1 - Физический или 2 - ФПМИ)");
            scanner = new Scanner(System.in);
            department = scanner.next();
            if (department.equals("1")) {
                department = "Физический";
                break;
            }
            if (department.equals("2")) {
                department = "ФПМИ";
                break;
            }
        } while (true);
        System.out.println("Введите курс(1, 2, 3, 4)");
        String course = scanner.next();
        while (!course.equals("1") && !course.equals("2") && !course.equals("3") && !course.equals("4")) {
            System.out.println("Неверный ввод");
            System.out.println("Введите курс(1, 2, 3, 4)");
            course = scanner.next();
        }
        System.out.println("Введите группу(1, 2, 3)");
        String group = scanner.next();
        while (!group.equals("1") && !group.equals("2") && !group.equals("3")) {
            System.out.println("Неверный ввод");
            System.out.println("Введите группу (1, 2, 3)");
            group = scanner.next();
        }
        int count = 0;
        for (Student student : students) {
            if (student.getDepartment().equals(department) && student.getCourse().equals(course) && student.getGroup().equals(group)) {
                System.out.println("Студент, " + student.getDepartment() + " факультет, " + student.getCourse() + " курса, " + student.getGroup() + " группы " + student);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Таких студентов не найдено");
        }
    }
}
