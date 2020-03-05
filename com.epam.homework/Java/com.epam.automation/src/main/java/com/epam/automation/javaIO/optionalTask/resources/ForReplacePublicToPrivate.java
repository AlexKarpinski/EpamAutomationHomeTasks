package com.epam.automation.javaIO.optionalTask.resources;

public class ForReplacePublicToPrivate {
    public int id;
    public String surname;
    public String name;
    public String patronymic;
    public int dateOfBirthday;
    public String address;
    private String phoneNumber;
    private String department;
    private String course;
    private String group;
    private int getId() {
        return id;
    }

   public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    private void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    private int getDateOfBirthday() {
        return dateOfBirthday;
    }

    private void setDateOfBirthday(int dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    private String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    private String getCourse() {
        return course;
    }

    private void setCourse(String course) {
        this.course = course;
    }

    private String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }
}
