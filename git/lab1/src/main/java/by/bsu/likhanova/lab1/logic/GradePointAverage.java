package by.bsu.likhanova.lab1.logic;

import by.bsu.likhanova.lab1.entity.Group;
import by.bsu.likhanova.lab1.entity.Student;

import java.util.LinkedList;

public class GradePointAverage {
    public static int getStudentGPA(Student student) {
        LinkedList<Integer> marks = student.getMarks();
        int gpa = 0;
        if (!marks.isEmpty()) {
            int sum = 0;
            for (Integer mark : marks) {
                sum += mark;
            }
            gpa = sum / marks.size();
        } else {
            gpa = -1;
        }
        return gpa;
    }

    public static int getGroupGPA(Group group) {
        LinkedList<Student> students = group.getGroupStudents();
        int gpa = 0;
        if (!students.isEmpty()) {
            int sum = 0;
            for (Student student : students) {
                sum += getStudentGPA(student);
            }
            gpa = sum / students.size();
        } else {
            gpa = -1;
        }
        return gpa;
    }
}
