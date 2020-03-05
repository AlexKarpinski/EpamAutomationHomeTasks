package com.epam.automation.exceptions.exceptions;

public class StudentHasNoSubjectException extends Exception{

    public StudentHasNoSubjectException() {
        super("У студента должны быть предметы");
    }
}