package com.epam.automation.exceptions.exceptions;

public class DepartmentFindException extends Exception {

    public DepartmentFindException() {
        super("Такого факультета не найдено");
    }
}