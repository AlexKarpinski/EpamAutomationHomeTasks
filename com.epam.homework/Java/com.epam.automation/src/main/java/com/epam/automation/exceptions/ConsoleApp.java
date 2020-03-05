package com.epam.automation.exceptions;

import com.epam.automation.exceptions.classes.Department;
import com.epam.automation.exceptions.classes.Group;
import com.epam.automation.exceptions.classes.Student;
import com.epam.automation.exceptions.classes.University;
import com.epam.automation.exceptions.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {
    private static University university = createUniversity();

    private static University createUniversity() {
        university = new University("БГУ");
        Department departmentOfHistory = new Department("Исторический");
        Department departmentOfMath = new Department("Математический");
        Department departmentOfPhysics = new Department("Физический");
        Group groupOfHistory1 = new Group("1");
        Group groupOfHistory2 = new Group("2");
        Group groupOfMath1 = new Group("1");
        Group groupOfMath2 = new Group("2");
        Group groupOfPhysics1 = new Group("1");
        Group groupOfPhysics2 = new Group("2");
        try {
            university.setDepartments(new ArrayList<>(Arrays.asList(departmentOfHistory, departmentOfMath, departmentOfPhysics)));
            departmentOfHistory.setGroups(new ArrayList<>(Arrays.asList(groupOfHistory1, groupOfHistory2)));
            departmentOfMath.setGroups(new ArrayList<>(Arrays.asList(groupOfMath1, groupOfMath2)));
            departmentOfPhysics.setGroups(new ArrayList<>(Arrays.asList(groupOfPhysics1, groupOfPhysics2)));
            groupOfHistory1.setSubjects(new ArrayList<>(Arrays.asList(Subject.THEWORLDHISTORY, Subject.HISTORYOFBELARUS, Subject.ANCIENTHISTORY)));
            groupOfHistory2.setSubjects(new ArrayList<>(Arrays.asList(Subject.THEWORLDHISTORY, Subject.HISTORYOFBELARUS, Subject.TEACHING)));
            groupOfMath1.setSubjects(new ArrayList<>(Arrays.asList(Subject.MATHANALYSIS, Subject.ANALYTIVGEOMETRY, Subject.MODERNMATH)));
            groupOfMath2.setSubjects(new ArrayList<>(Arrays.asList(Subject.MATHANALYSIS, Subject.ANALYTIVGEOMETRY, Subject.TEACHING)));
            groupOfPhysics1.setSubjects(new ArrayList<>(Arrays.asList(Subject.GENERALPHYSICS, Subject.HIGHERMATH, Subject.SOLIDSTATEPHYSICS)));
            groupOfPhysics2.setSubjects(new ArrayList<>(Arrays.asList(Subject.GENERALPHYSICS, Subject.HIGHERMATH, Subject.TEACHING)));
            university.addStudent(new Student("Попов Виктор Алексеевич"), departmentOfHistory, groupOfHistory1);
            university.addStudent(new Student("Алексеев Игорь Алексеевич"), departmentOfHistory, groupOfHistory1);
            university.addStudent(new Student("Иванов Игорь Олегович"), departmentOfHistory, groupOfHistory1);
            university.addStudent(new Student("Сидоров Григорий Ильич"), departmentOfHistory, groupOfHistory2);
            university.addStudent(new Student("Иванников Олег Олегович"), departmentOfHistory, groupOfHistory2);
            university.addStudent(new Student("Попов Виктор Алексеевич"), departmentOfHistory, groupOfHistory2);
            university.addStudent(new Student("Петько Роман Алексеевич"), departmentOfMath, groupOfMath1);
            university.addStudent(new Student("Сазановец Валерия Денисовна"), departmentOfMath, groupOfMath1);
            university.addStudent(new Student("Пухтеева Елизавета Сергеевна"), departmentOfMath, groupOfMath1);
            university.addStudent(new Student("Петько Иван Алексеевич"), departmentOfMath, groupOfMath2);
            university.addStudent(new Student("Лялькова Вальжина Игоревна"), departmentOfMath, groupOfMath2);
            university.addStudent(new Student("Гесть Андрей Вячеславович"), departmentOfMath, groupOfMath2);
            university.addStudent(new Student("Веренич Мария Александровна"), departmentOfPhysics, groupOfPhysics1);
            university.addStudent(new Student("Жбанов Владислав Петрович"), departmentOfPhysics, groupOfPhysics1);
            university.addStudent(new Student("Занько Юлиана Владимировна"), departmentOfPhysics, groupOfPhysics1);
            university.addStudent(new Student("Коротков Егор Владимирович"), departmentOfPhysics, groupOfPhysics2);
            university.addStudent(new Student("Лузан Тимофей Павлович"), departmentOfPhysics, groupOfPhysics2);
            university.addStudent(new Student("Сидоров Григорий Ильич"), departmentOfPhysics, groupOfPhysics2);
        } catch (UniversityHasNoDepartmentException | StudentHasNoSubjectException | DepartmentHasNoGroupException | GroupHasNoStudentException e) {
            e.printStackTrace();
        }
        return university;
    }

    /**
     * printMiddleRating() - метод выводит средний балл по всем предметам студента
     */
    private static void printMiddleRating() {
        try {
            for (Department department : university.getDepartments()) {
                for (Group group : department.getGroups()) {
                    for (Student student : group.getStudents()) {
                        try {
                            System.out.println(student.getName() + " " + student.getMapOfRatings() + " Средний балл " + student.middleRating());
                        } catch (PassExamException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (UniversityHasNoDepartmentException | DepartmentHasNoGroupException | GroupHasNoStudentException e) {
            e.printStackTrace();
        }
    }

    /**
     * printMiddleRatingInDepartmentInGroup() - метод выводит в консоль
     * средний балл по конкретному предмету в конкретной группе и на конкретном факультете
     */
    private static void printMiddleRatingInDepartmentInGroup() {
        String nameOfDepartment = choiceDepartment();
        String nameOfGroup = choiceGroup();
        Subject subjectName = choiceSubject();
        try {
            for (Department department : university.getDepartments()) {
                if (department.getName().equals(nameOfDepartment)) {
                    for (Group group : department.getGroups()) {
                        if (group.getName().equals(nameOfGroup)) {
                            try {
                                assert subjectName != null;
                                System.out.println("Факультет: " + department.getName() + ", группа: " + group.getName() +
                                        ", предмет: " + subjectName.getName() + ", средний балл: "
                                        + university.middleRatingInDepartmentInGroup(group, subjectName));
                            } catch (PassExamException | GroupHasNoStudentException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (UniversityHasNoDepartmentException | DepartmentHasNoGroupException e) {
            e.printStackTrace();
        }
    }

    /**
     * printMiddleRatingInUniversity() - метод выводит в консоль средний балл по предмету для всего университета
     */
    private static void printMiddleRatingInUniversity() {
        Subject subjectName = choiceSubject();
        try {
            assert subjectName != null;
            System.out.println("Средний балл по предмету: " + subjectName.getName() + " по всему университету равен: "
                    + university.middleRatingSubject(subjectName));
        } catch (PassExamException | DepartmentHasNoGroupException | UniversityHasNoDepartmentException e) {
            e.printStackTrace();
        }
    }

    private static Subject choiceSubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предмет (1 - Общая физика, 2 - Высшая математика, 3 - Физика твердого тела, 4 - Преподавателькая деятельноть, " +
                "5 - Математичекий анализ, 6 - Аналитичекая геометрия, 7 - Современная математика, " +
                "8 - История РБ, 9 - Всемирная история, 10 - История древности)");
        int subject = scanner.nextInt();
        Subject subjectName = null;
        switch (subject) {
            case 1:
                subjectName = Subject.GENERALPHYSICS;
                break;
            case 2:
                subjectName = Subject.HIGHERMATH;
                break;
            case 3:
                subjectName = Subject.SOLIDSTATEPHYSICS;
                break;
            case 4:
                subjectName = Subject.TEACHING;
                break;
            case 5:
                subjectName = Subject.MATHANALYSIS;
                break;
            case 6:
                subjectName = Subject.ANALYTIVGEOMETRY;
                break;
            case 7:
                subjectName = Subject.MODERNMATH;
                break;
            case 8:
                subjectName = Subject.HISTORYOFBELARUS;
                break;
            case 9:
                subjectName = Subject.THEWORLDHISTORY;
                break;
            case 10:
                subjectName = Subject.ANCIENTHISTORY;
                break;
            default:
                System.out.println("\nНеверный ввод\n");
                choiceSubject();
        }
        return subjectName;
    }

    private static String choiceDepartment() {
        String nameOfDepartment;
        Scanner scanner;
        do {
            System.out.println("\nВведите факультет(1 - Физический, 2 - Математический, 3 - Исторический)");
            scanner = new Scanner(System.in);
            nameOfDepartment = scanner.next();
            if (nameOfDepartment.equals("1")) {
                nameOfDepartment = "Физический";
                break;
            }
            if (nameOfDepartment.equals("2")) {
                nameOfDepartment = "Математический";
                break;
            }
            if (nameOfDepartment.equals("3")) {
                nameOfDepartment = "Исторический";
                break;
            }
        } while (true);
        return nameOfDepartment;
    }

    private static String choiceGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите группу(1, 2)");
        String nameOfGroup = scanner.next();
        while (!nameOfGroup.equals("1") && !nameOfGroup.equals("2")) {
            System.out.println("Неверный ввод");
            System.out.println("Введите группу (1, 2)");
            nameOfGroup = scanner.next();
        }
        return nameOfGroup;
    }

    void run() {
        try {
            for (Department department : university.getDepartments()) {
                for (Group group : department.getGroups()) {
                    for (Student student : group.getStudents()) {
                        try {
                            student.passExam();
                        } catch (RatingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (UniversityHasNoDepartmentException | DepartmentHasNoGroupException | GroupHasNoStudentException e) {
            e.printStackTrace();
        }
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
                printMiddleRating();
                break;
            case 2:
                printMiddleRatingInDepartmentInGroup();
                break;
            case 3:
                printMiddleRatingInUniversity();
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
                "Введите 1, для проверки задания 1 (Посчитать средний балл по всем предметам студента)" + "\n" +
                "Введите 2, для проверки задания 2 (Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете)" + "\n" +
                "Введите 3, для проверки задания 3 (Посчитать средний балл по предмету для всего университета)" + "\n" +
                "Введите 0, для выхода из программы";
        System.out.println("\n" + task + "\n");
    }

    private static void exit() {
        System.exit(0);
    }
}