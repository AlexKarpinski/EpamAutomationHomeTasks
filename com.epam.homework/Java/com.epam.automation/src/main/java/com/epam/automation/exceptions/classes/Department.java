package com.epam.automation.exceptions.classes;

import com.epam.automation.exceptions.exceptions.DepartmentHasNoGroupException;
import com.epam.automation.exceptions.exceptions.GroupHasNoStudentException;

import java.util.List;

public class Department {
    private String name;
    private List<Group> groups;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() throws DepartmentHasNoGroupException {
        if (groups == null) {
            throw new DepartmentHasNoGroupException("На факультете должны быть группы");
        }
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }

    void addStudent(Student student, Group group) throws GroupHasNoStudentException, DepartmentHasNoGroupException {
        boolean isHasGroup = getGroups().contains(group);
        if (group == null && !isHasGroup) {
            throw new GroupHasNoStudentException();
        } else {
            assert group != null;
            group.addStudent(student);
        }
    }
}