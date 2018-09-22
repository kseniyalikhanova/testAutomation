package by.bsu.likhanova.lab1.datareader;

import by.bsu.likhanova.lab1.entity.Group;
import by.bsu.likhanova.lab1.entity.Student;
import by.bsu.likhanova.lab1.validator.MarkValidator;
import by.bsu.likhanova.lab1.validator.StudentNameValidator;

import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public void closeScanner() {
        scanner.close();
    }

    public LinkedList<Student> readNameStudent(Group group) {
        System.out.println("Enter the student name and surname from the " + group.getName() + " group " +
                " and press Enter. If you want to finish input, then enter exit.");
        LinkedList<Student> students = new LinkedList<Student>();
        String nameStudent;
        while (true) {
            nameStudent = scanner.nextLine().trim()
                    .replaceAll("\\s+", " ");
            if (StudentNameValidator.validateLine(nameStudent)) {
                String[] name = nameStudent.split(" ");
                Student student = new Student(name[0], name[1]);
                students.add(student);
                System.out.println("Continue input.");
            } else if (nameStudent.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Incorrect data. Enter the student name and surname again.");
            }
        }
        return students;
    }

    public LinkedList<Integer> readMarks(Student student) {
        LinkedList<Integer> marks = new LinkedList<Integer>();
        String mark;
        System.out.println("Enter the mark of " + student.getName() + " " + student.getSurname() +
                " and press Enter. If you want to finish input, then enter exit.");
        while (true) {
            mark = scanner.next();
            if (MarkValidator.validateLine(mark)) {
                marks.addLast(Integer.parseInt(mark));
                System.out.println("Continue input.");
            } else if (mark.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Incorrect data. Enter the mark in range [1-10].");
            }
        }
        return marks;
    }

}
