package com.epam.automation.exceptions.classes;

import com.epam.automation.exceptions.Subject;
import com.epam.automation.exceptions.exceptions.*;

import java.util.List;
import java.util.Map;

public class University {
    private String name;
    private List<Department> departments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() throws UniversityHasNoDepartmentException {
        if (departments == null) {
            throw new UniversityHasNoDepartmentException("В университете должны быть студенты");
        }
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public University(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }

    public double middleRatingSubject(Subject subject) throws PassExamException, DepartmentHasNoGroupException, UniversityHasNoDepartmentException {
        int sum = 0;
        int count = 0;
        for (Department department : getDepartments()) {
            for (Group group : department.getGroups()) {
                try {
                    for (Student student : group.getStudents()) {
                        for (Map.Entry<Subject, Integer> entry : student.getMapOfRatings().entrySet()) {
                            if (entry.getKey().equals(subject)) {
                                sum += entry.getValue();
                                count++;
                            }
                        }
                    }
                } catch (GroupHasNoStudentException e) {
                    e.printStackTrace();
                }
            }
        }
        if (count == 0) throw new PassExamException("Студенты не сдавали экзамен по данному предмету: " + subject);
        double value = (double) sum / count;
        value = value * 10;
        int i = (int) Math.round(value);
        return (double) i / 10;
    }

    public double middleRatingInDepartmentInGroup(Group group, Subject subject) throws PassExamException, GroupHasNoStudentException {
        int count = 0;
        int sum = 0;
        for (Student student : group.getStudents()) {
            for (Map.Entry<Subject, Integer> entry : student.getMapOfRatings().entrySet()) {
                if (entry.getKey().equals(subject)) {
                    sum += entry.getValue();
                    count++;
                }
            }
        }
        if (count == 0) throw new PassExamException("Студенты не сдавали экзамен по данному предмету: " + subject);
        double value = (double) sum / count;
        value = value * 10;
        int i = (int) Math.round(value);
        return (double) i / 10;
    }

    public void addStudent(Student student, Department department, Group group) throws UniversityHasNoDepartmentException, GroupHasNoStudentException, StudentHasNoSubjectException, DepartmentHasNoGroupException {
        boolean isHasDepartment = getDepartments().contains(department);
        if ((department == null) && !isHasDepartment) {
            throw new UniversityHasNoDepartmentException("Такого факультета нет");
        }
        assert department != null;
        department.addStudent(student, group);
        setStudentSubject();
    }

    private void setStudentSubject() throws StudentHasNoSubjectException, DepartmentHasNoGroupException, UniversityHasNoDepartmentException, GroupHasNoStudentException {
        for (Department department : getDepartments()) {
            for (Group group : department.getGroups()) {
                group.setStudentsSubject();
            }
        }
    }
}