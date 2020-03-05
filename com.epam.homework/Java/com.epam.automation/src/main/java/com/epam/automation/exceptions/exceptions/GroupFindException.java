package com.epam.automation.exceptions.exceptions;

public class GroupFindException extends Exception{

    public GroupFindException() {
        super("Такой группы не найдено");
    }
}