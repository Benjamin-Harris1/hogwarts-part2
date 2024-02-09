package edu.hogwarts.application;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.List;

public class UserInterFace {
    private StudentController studentController;
    private TeacherController teacherController;

    public UserInterFace(StudentController studentController, TeacherController teacherController){
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void printTable(){
        String headerFormat = "| %-12s | %-12s | %-12s | %-10s | %-12s |\n";
        String rowFormat = "| %-12s | %-12s | %-12s | %-10s | %-12s |\n";

        // Print table header
        System.out.format(headerFormat, "First Name", "Middle Name", "Last Name", "House", "Role");
        System.out.println(new String(new char[70]).replace("\0", "-"));

        List<HogwartsStudent> students = studentController.getAll();
        List<HogwartsTeacher> teachers = teacherController.getAll();

        // Printer students
        for (HogwartsStudent student : students){
            System.out.format(rowFormat,
            student.getFirstName(),
            student.getMiddleName(),
            student.getLastName(),
            student.getHouse().getName(),
            "Student");
        }

        // Printer teachers
        for (HogwartsTeacher teacher : teachers){
            System.out.format(rowFormat,
            teacher.getFirstName(),
            teacher.getMiddleName(),
            teacher.getLastName(),
            teacher.getHouse().getName(),
            "Teacher"
            
            );
        }
    }
}
