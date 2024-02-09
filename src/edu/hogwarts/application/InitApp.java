package edu.hogwarts.application;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.data.*;

import java.time.LocalDate;

public class InitApp {
    private StudentController studentController;
    private TeacherController teacherController;

    public InitApp(StudentController studentController, TeacherController teacherController){
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void initializeStudents(){

        //  Opretter houses
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", new String[]{"red", "gold"});
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", new String[]{"blue", "silver"});
        House slytherin = new House("Slytherin", "Salazar Slytherin", new String[]{"green", "silver"});
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", new String[]{"yellow", "black"});

        // Opretter students
        studentController.create(new HogwartsStudent("Harry James Potter", 1991, 1997, false, gryffindor, true, new String[]{"Quidditch"}));
        studentController.create(new HogwartsStudent("Ron Weasley", 1991, 1997, false, gryffindor, false, new String[]{"Quidditch"}));
        studentController.create(new HogwartsStudent("Hermione Granger", 1991, 1997, false, gryffindor, false, new String[]{}));
        studentController.create(new HogwartsStudent("Draco Malfoy", 1991, 1997, false, slytherin, false, new String[]{"Quidditch"}));
        studentController.create(new HogwartsStudent("Neville Longbottom", 1991, 1997, false, gryffindor, false, new String[]{}));
        studentController.create(new HogwartsStudent("Luna Lovegood", 1991, 1997, false, ravenclaw, false, new String[]{}));
        studentController.create(new HogwartsStudent("Ginny Weasley", 1992, 1998, false, gryffindor, false, new String[]{"Quidditch"}));
        studentController.create(new HogwartsStudent("Cedric Diggory", 1989, 1995, false, hufflepuff, true, new String[]{"Quidditch"}));
        studentController.create(new HogwartsStudent("Cho Chang", 1990, 1996, false, ravenclaw, false, new String[]{"Quidditch"}));
        studentController.create(new HogwartsStudent("Pansy Parkinson", 1991, 1997, false, slytherin, false, new String[]{}));
        studentController.create(new HogwartsStudent("Seamus Finnigan", 1991, 1997, false, gryffindor, false, new String[]{}));
        studentController.create(new HogwartsStudent("Dean Thomas", 1991, 1997, false, gryffindor, false, new String[]{}));
        studentController.create(new HogwartsStudent("Padma Patil", 1991, 1997, false, ravenclaw, false, new String[]{}));
        studentController.create(new HogwartsStudent("Parvati Patil", 1991, 1997, false, gryffindor, false, new String[]{}));
        studentController.create(new HogwartsStudent("Lavender Brown", 1991, 1997, false, gryffindor, false, new String[]{}));
        studentController.create(new HogwartsStudent("Gregory Goyle", 1991, 1997, false, slytherin, false, new String[]{}));
        studentController.create(new HogwartsStudent("Vincent Crabbe", 1991, 1997, false, slytherin, false, new String[]{}));

    }

    public void initializeTeachers(){
                //  Opretter houses
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", new String[]{"red", "gold"});
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", new String[]{"blue", "silver"});
        House slytherin = new House("Slytherin", "Salazar Slytherin", new String[]{"green", "silver"});
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", new String[]{"yellow", "black"});


        // Opretter teachers
        teacherController.create(new HogwartsTeacher("Horace E. Slughorn", EmpType.PROFESSOR, LocalDate.parse("1990-01-01"), null, slytherin, false));
        teacherController.create(new HogwartsTeacher("Albus Dumbledore", EmpType.HEADMASTER, LocalDate.parse("1990-01-01"), null, gryffindor, false));
        teacherController.create(new HogwartsTeacher("Minerva McGonagall", EmpType.HEAD_OF_GRYFFINDOR, LocalDate.parse("1990-01-01"), null, gryffindor, true));
        teacherController.create(new HogwartsTeacher("Severus Snape", EmpType.HEAD_OF_SLYTHERIN, LocalDate.parse("1990-01-01"), null, slytherin, true));
        teacherController.create(new HogwartsTeacher("Filius Flitwick", EmpType.HEAD_OF_RAVENCLAW, LocalDate.parse("1990-01-01"), null, ravenclaw, true));
        teacherController.create(new HogwartsTeacher("Pomona Sprout", EmpType.HEAD_OF_HUFFLEPUFF, LocalDate.parse("1990-01-01"), null, hufflepuff, true));
    }

    // public void initializeCourse(){
        
    //     //  Opretter houses
    //     House gryffindor = new House("Gryffindor", "Godric Gryffindor", new String[]{"red", "gold"});
    //     House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", new String[]{"blue", "silver"});
    //     House slytherin = new House("Slytherin", "Salazar Slytherin", new String[]{"green", "silver"});
    //     House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", new String[]{"yellow", "black"});

    //     // Slughorn skal bruges til potions faget længere nede.
    //     HogwartsTeacher slughorn = new HogwartsTeacher("Horace E. Slughorn", EmpType.PROFESSOR, LocalDate.parse("1990-01-01"), null, slytherin, true);
    //     teacherController.create(slughorn);

    //     // Opretter potions fag
    //     Subject potions = new Subject("Potions", 6, false);

    //     // Opretter potions kursus med Horace Slughorn som teacher
    //     Course potionsSixthYear = new Course(potions, slughorn);

    //     // Opretter forskellige teaching materials
    //     TextBook potionmaking = new TextBook("Advanced Potion-Making", false, true, false, "edu.hogwarts.data.Course-book", "Advanced Potion-Making", "Libatius Borage", "Merge Books", 1946);
    //     Tool cauldron = new Tool("Cauldron", true, true, true, "Steel", "A standard potion-making cauldron");
    //     Tool silverKnife = new Tool("Silver Knife", true, true, false, "Silver", "A knife for cutting ingredients");
    //     Ingredient ingredient1 = new Ingredient("Boomslang Skin", false, true, true, "Boomslang", 0.5, "ounces");
    //     Ingredient ingredient2 = new Ingredient("Bicorn Horn", true, false, true, "Bicorn", 0.2, "ounces");

    //     // Tilføjer teaching materials til potion 6 course
    //     potionsSixthYear.addTeachingMaterial(potionmaking);
    //     potionsSixthYear.addTeachingMaterial(cauldron);
    //     potionsSixthYear.addTeachingMaterial(silverKnife);
    //     potionsSixthYear.addTeachingMaterial(ingredient1);
    //     potionsSixthYear.addTeachingMaterial(ingredient2);
    // }
}
