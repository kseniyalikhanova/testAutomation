package by.bsu.likhanova.lab1.entity;

import java.util.LinkedList;

public class Student {
    private String name;
    private String surname;
    private LinkedList<Integer> marks;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        marks = new LinkedList<Integer>();
    }

    Student(String name, String surname, LinkedList<Integer> marks) {
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LinkedList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(LinkedList<Integer> marks) {
        this.marks.addAll(marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", marks=" + marks +
                '}';
    }
}
