package edu.hogwarts.application;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.data.HogwartsStudent;
import edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;

public class UserInterFace {
    private StudentController studentController;
    private TeacherController teacherController;

    public UserInterFace(StudentController studentController, TeacherController teacherController){
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void getAllStudents(){
        System.out.println("List of all students:");
        ArrayList<HogwartsStudent> students = studentController.getAll();
        for (HogwartsStudent student : students){
            System.out.println(student.toString());
        }
    }

    public void getAllTeachers(){
        System.out.println("List of all teachers:");
        ArrayList<HogwartsTeacher> teachers = teacherController.getAll();
        for (HogwartsTeacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }
}
