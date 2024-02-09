package edu.hogwarts.application;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.List;
import java.util.Scanner;

public class UserInterFace {
    private StudentController studentController;
    private TeacherController teacherController;

    public UserInterFace(StudentController studentController, TeacherController teacherController){
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("q")) {
            System.out.println("Press 'f' for filtering, 's' for sorting, 'q' to exit..");
            input = scanner.nextLine();

            switch(input) {
                case "f":
                    //filterMenu();
                    break;
                case "s":
                    sortMenu();
                    break;
                case "q":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }

        }
    }

    private void sortMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'firstname', 'lastname', or 'house' to sort:");
        String sortField = scanner.nextLine();
        System.out.println("Type 'asc' for ascending, or 'desc' for descending:");
        String sortOrder = scanner.nextLine();

        List<HogwartsStudent> sortedStudents;
        List<HogwartsTeacher> sortedTeachers;

        switch(sortField.toLowerCase()) {
            case "firstname":
                if ("asc".equalsIgnoreCase(sortOrder)) {
                    sortedStudents = studentController.getAllSorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()));
                    sortedTeachers = teacherController.getAllSorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()));
                } else {
                    sortedStudents = studentController.getAllSorted((a, b) -> b.getFirstName().compareTo(a.getFirstName()));
                    sortedTeachers = teacherController.getAllSorted((a, b) -> b.getFirstName().compareTo(a.getFirstName()));
                }
                break;
            case "lastname":
                if ("asc".equalsIgnoreCase(sortOrder)) {
                    sortedStudents = studentController.getAllSorted((a, b) -> a.getLastName().compareTo(b.getLastName()));
                    sortedTeachers = teacherController.getAllSorted((a, b) -> a.getLastName().compareTo(b.getLastName()));
                } else {
                    sortedStudents = studentController.getAllSorted((a, b) -> b.getLastName().compareTo(a.getLastName()));
                    sortedTeachers = teacherController.getAllSorted((a, b) -> b.getLastName().compareTo(a.getLastName()));
                }
                break;
            case "house":
                if ("asc".equalsIgnoreCase(sortOrder)) {
                    sortedStudents = studentController.getAllSorted((a, b) -> a.getHouse().getName().compareTo(b.getHouse().getName()));
                    sortedTeachers = teacherController.getAllSorted((a, b) -> a.getHouse().getName().compareTo(b.getHouse().getName()));
                } else {
                    sortedStudents = studentController.getAllSorted((a, b) -> b.getHouse().getName().compareTo(a.getHouse().getName()));
                    sortedTeachers = teacherController.getAllSorted((a, b) -> b.getHouse().getName().compareTo(a.getHouse().getName()));
                }
                break;
            default:
                System.out.println("Invalid sort field");
                return;
        }

            printSorted(sortedStudents, sortedTeachers);
    }

    private void printSorted(List<HogwartsStudent> sortedStudents, List<HogwartsTeacher> sortedTeachers) {
        String headerFormat = "| %-12s | %-12s | %-12s | %-12s |\n";
        System.out.format(headerFormat, "First Name", "Last Name", "House", "Role");
        System.out.println(new String(new char[50]).replace("\0", "-"));

        for (HogwartsStudent student : sortedStudents) {
            String rowFormat = "| %-12s | %-12s | %-12s | %-12s |\n";
            System.out.format(rowFormat,
                    student.getFirstName(),
                    student.getLastName(),
                    student.getHouse().getName(), // Antager at getHouse() returnerer et objekt, der har en getName() metode.
                    "Student");
        }
        for (HogwartsTeacher teacher : sortedTeachers) {
            String rowFormat = "| %-12s | %-12s | %-12s | %-12s |\n";
            // Ternary bruges her, da nogle lærere måske ikke er knyttet til et hus
            String houseName = teacher.getHouse() != null ? teacher.getHouse().getName() : "None";
            System.out.format(rowFormat,
                    teacher.getFirstName(),
                    teacher.getLastName(),
                    houseName,
                    "Teacher");
        }
    }

}
