package by.bsu.likhanova.lab1.runner;

import by.bsu.likhanova.lab1.datareader.ConsoleReader;
import by.bsu.likhanova.lab1.entity.Group;
import by.bsu.likhanova.lab1.entity.Student;
import by.bsu.likhanova.lab1.logic.GradePointAverage;


import java.util.LinkedList;

public class Lab1Runner {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        Group group = new Group("WEB");
        LinkedList<Student> students = new LinkedList<Student>();
        students.addAll(consoleReader.readNameStudent(group));
        for (Student student : students) {
            student.setMarks(consoleReader.readMarks(student));
        }
        group.setGroupStudents(students);
        for (Student student : students) {
            System.out.println("Grade point average of " + student.getName() + " " + student.getSurname() +
                    " is " + GradePointAverage.getStudentGPA(student) + ".");
        }
        System.out.println("Grade point average of " + group.getName() + " group is "
                + GradePointAverage.getGroupGPA(group) + ".");

        consoleReader.closeScanner();
    }
}
