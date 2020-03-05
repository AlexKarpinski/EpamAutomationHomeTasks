package com.epam.automation.exceptions.classes;

import com.epam.automation.exceptions.Subject;
import com.epam.automation.exceptions.exceptions.PassExamException;
import com.epam.automation.exceptions.exceptions.RatingException;
import com.epam.automation.exceptions.exceptions.StudentHasNoSubjectException;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private String name;
    private final HashMap<Subject, Integer> mapOfRatings = new HashMap<>();
    private List<Subject> subjects = new ArrayList<>();
    private boolean isPassExams = false;

    public Student(String name) {
        this.name = name;
    }

    void setSubjects(List<Subject> subjects) throws StudentHasNoSubjectException {
        if (subjects == null) throw new StudentHasNoSubjectException();
        else this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setPassExams() {
        isPassExams = true;
    }

    public HashMap<Subject, Integer> getMapOfRatings() {
        return mapOfRatings;
    }

    public void passExam() throws RatingException {
        for (Subject subject : subjects) {
            int rating = ThreadLocalRandom.current().nextInt(0, 10);
            if (rating < 0 || rating > 10) throw new RatingException();
            mapOfRatings.put(subject, rating);
        }
        setPassExams();
    }

    public double middleRating() throws PassExamException {
        double middleRating;
        if (isPassExams) {
            int sum = 0;
            for (Map.Entry<Subject, Integer> entry : mapOfRatings.entrySet()) {
                sum += entry.getValue();
            }
            double value = (double) sum / mapOfRatings.size();
            value = value * 10;
            int i = (int) Math.round(value);
            middleRating = (double) i / 10;
        } else throw new PassExamException("Студенты не сдавали экзамены");
        return middleRating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(mapOfRatings, student.mapOfRatings) &&
                Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mapOfRatings, subjects);
    }
}