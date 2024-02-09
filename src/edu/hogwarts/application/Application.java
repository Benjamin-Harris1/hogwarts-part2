package edu.hogwarts.application;

import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.controller.StudentController;

public class Application {
    private StudentController studentController;
    private TeacherController teacherController;
    private UserInterFace userInterface;
    private InitApp initApp;

    public Application(){
        studentController = new StudentController();
        teacherController = new TeacherController();
        userInterface = new UserInterFace(studentController, teacherController);
        initApp = new InitApp(studentController, teacherController);
    }

    public void start(){
        initApp = new InitApp(studentController, teacherController);
        initApp.initializeStudents();
        initApp.initializeTeachers();
        //initApp.displayData();
        userInterface.start();
    }
    public static void main(String[] args){
        Application app = new Application();
        app.start();
    }
}