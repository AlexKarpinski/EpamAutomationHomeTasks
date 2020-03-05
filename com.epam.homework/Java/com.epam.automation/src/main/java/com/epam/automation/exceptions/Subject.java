package com.epam.automation.exceptions;

public enum Subject {

    THEWORLDHISTORY("Всемирная история"),
    HISTORYOFBELARUS("История РБ"),
    ANCIENTHISTORY("История древности"),
    MATHANALYSIS("Математичекий анализ"),
    ANALYTIVGEOMETRY("Аналитичекая геометрия"),
    MODERNMATH("Современная математика"),
    GENERALPHYSICS("Общая физика"),
    HIGHERMATH("Высшая математика"),
    SOLIDSTATEPHYSICS("Физика твердого тела"),
    TEACHING("Преподавателькая деятельноть");

    private String name;

    public String getName() {
        return name;
    }

    Subject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }
}
