package com.epam.automation.exceptions.classes;

import com.epam.automation.exceptions.Subject;
import com.epam.automation.exceptions.exceptions.GroupHasNoStudentException;
import com.epam.automation.exceptions.exceptions.StudentHasNoSubjectException;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() throws GroupHasNoStudentException {
        if (students == null) {
            throw new GroupHasNoStudentException();
        }
        return students;
    }

    private List<Subject> getSubjects() throws StudentHasNoSubjectException {
        if (subjects == null) {
            throw new StudentHasNoSubjectException();
        }
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + students +
                ", subjects=" + subjects +
                '}';
    }

    void addStudent(Student student) throws GroupHasNoStudentException {
        if (student == null) {
            throw new GroupHasNoStudentException();
        } else students.add(student);
    }

    void setStudentsSubject() throws StudentHasNoSubjectException, GroupHasNoStudentException {
        for (Student studentI : getStudents()) {
            studentI.setSubjects(getSubjects());
        }
    }
}