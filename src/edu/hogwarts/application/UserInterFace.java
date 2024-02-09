package edu.hogwarts.application;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.Comparator;
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

    public Comparator<HogwartsStudent> chooseStudentComparator(String sortField, String sortOrder) {
        Comparator<HogwartsStudent> comparator = (a, b) -> 0; // Ingen sortering

        switch(sortField.toLowerCase()) {
            case "firstname":
                comparator = (a, b) -> a.getFirstName().compareTo(b.getFirstName());
                break;
            case "lastname":
                comparator = (a, b) -> a.getLastName().compareTo(b.getLastName());
                break;
            case "house":
                comparator = (a, b) -> a.getHouse().getName().compareTo(b.getHouse().getName());
                break;
        }

        if ("desc".equalsIgnoreCase(sortOrder)) {
            Comparator<HogwartsStudent> finalComparator = comparator;
            comparator = (a, b) -> finalComparator.compare(b, a);
        }

        return comparator;
    }
    public Comparator<HogwartsTeacher> chooseTeacherComparator(String sortField, String sortOrder) {
        Comparator<HogwartsTeacher> comparator = (a, b) -> 0; // Ingen sortering

        switch(sortField.toLowerCase()) {
            case "firstname":
                comparator = (a, b) -> a.getFirstName().compareTo(b.getFirstName());
                break;
            case "lastname":
                comparator = (a, b) -> a.getLastName().compareTo(b.getLastName());
                break;
            case "house":
                comparator = (a, b) -> {
                    // Brugt ternary fordi Dumbledore ikke er knyttet et hus
                    String houseNameA = a.getHouse() != null ? a.getHouse().getName() : "";
                    String houseNameB = b.getHouse() != null ? b.getHouse().getName() : "";
                    return houseNameA.compareTo(houseNameB);
                };
                break;
        }

        if ("desc".equalsIgnoreCase(sortOrder)) {
            Comparator<HogwartsTeacher> finalComparator = comparator;
            comparator = (a, b) -> finalComparator.compare(b, a);
        }

        return comparator;
    }


    private void sortMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'firstname', 'lastname', or 'house' to sort:");
        String sortField = scanner.nextLine();
        System.out.println("Type 'asc' for ascending, or 'desc' for descending:");
        String sortOrder = scanner.nextLine();

        Comparator<HogwartsStudent> studentComparator = chooseStudentComparator(sortField, sortOrder);
        Comparator<HogwartsTeacher> teacherComparator = chooseTeacherComparator(sortField, sortOrder);
        List<HogwartsStudent> sortedStudents = studentController.getAllSorted(studentComparator);
        List<HogwartsTeacher> sortedTeachers = teacherController.getAllSorted(teacherComparator);

        printStudents(sortedStudents);
        printTeachers(sortedTeachers);
    }

    private void printTeachers(List<HogwartsTeacher> sortedTeachers) {
        String headerFormat = "| %-12s | %-12s | %-12s | %-12s |\n";
        System.out.format(headerFormat, "First Name", "Last Name", "House", "Role");
        System.out.println(new String(new char[50]).replace("\0", "-"));

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

    private void printStudents(List<HogwartsStudent> sortedStudents) {
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
    }
}
