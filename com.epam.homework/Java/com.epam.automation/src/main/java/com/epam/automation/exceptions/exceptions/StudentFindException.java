package com.epam.automation.exceptions.exceptions;

public class StudentFindException  extends Exception{

    public StudentFindException() {
        super("Такого студента не найдено");
    }
}