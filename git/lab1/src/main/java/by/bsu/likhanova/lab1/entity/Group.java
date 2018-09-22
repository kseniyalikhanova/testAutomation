package by.bsu.likhanova.lab1.entity;

import java.util.LinkedList;

public class Group {
    private String name;
    private LinkedList<Student> groupStudents;

    public Group(String name) {
        this.name = name;
        this.groupStudents = new LinkedList<Student>();
    }

    public Group(String name, LinkedList<Student> groupStudents) {
        this.name = name;
        this.groupStudents = groupStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Student> getGroupStudents() {
        return groupStudents;
    }

    public void setGroupStudents(LinkedList<Student> groupStudents) {
        this.groupStudents.addAll(groupStudents);
    }
}
