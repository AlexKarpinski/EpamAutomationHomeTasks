package com.epam.automation.exceptions.exceptions;

public class GroupHasNoStudentException extends Exception{

    public GroupHasNoStudentException() {
        super("В группе должны быть студенты");
    }
}