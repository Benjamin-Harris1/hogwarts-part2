package edu.hogwarts.application;

import edu.generic.Teacher;
import edu.hogwarts.data.*;

import java.time.LocalDate;


public class Application {
    public static void main(String[] args){
        initApp();
    }

    private static void initApp(){

        // Opret dynamic arrays
        DynamicArray students = new DynamicArray();
        DynamicArray teachers = new DynamicArray();


        // Opret instanser af house
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", new String[]{"red", "gold"});
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", new String[]{"blue", "silver"});
        House slytherin = new House("Slytherin", "Salazar Slytherin", new String[]{"green", "silver"});
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", new String[]{"yellow", "black"});

        // Opret students
        HogwartsStudent harry = new HogwartsStudent("Harry Potter", 1991, 1997, false, gryffindor, true, new String[]{"Quidditch"});
        HogwartsStudent ron = new HogwartsStudent("Ron Weasley", 1991, 1997, false, gryffindor, false, new String[]{"Quidditch"});
        HogwartsStudent hermione = new HogwartsStudent("Hermione Granger", 1991, 1997, false, gryffindor, false, new String[]{});
        HogwartsStudent draco = new HogwartsStudent("Draco Malfoy", 1991, 1997, false, slytherin, false, new String[]{"Quidditch"});
        HogwartsStudent neville = new HogwartsStudent("Neville Longbottom", 1991, 1997, false, gryffindor, false, new String[]{});
        HogwartsStudent luna = new HogwartsStudent("Luna Lovegood", 1991, 1997, false, ravenclaw, false, new String[]{});
        HogwartsStudent ginny = new HogwartsStudent("Ginny Weasley", 1992, 1998, false, gryffindor, false, new String[]{"Quidditch"});
        HogwartsStudent cedric = new HogwartsStudent("Cedric Diggory", 1989, 1995, false, hufflepuff, true, new String[]{"Quidditch"});
        HogwartsStudent cho = new HogwartsStudent("Cho Chang", 1990, 1996, false, ravenclaw, false, new String[]{"Quidditch"});
        HogwartsStudent pansy = new HogwartsStudent("Pansy Parkinson", 1991, 1997, false, slytherin, false, new String[]{});
        HogwartsStudent seamus = new HogwartsStudent("Seamus Finnigan", 1991, 1997, false, gryffindor, false, new String[]{});
        HogwartsStudent dean = new HogwartsStudent("Dean Thomas", 1991, 1997, false, gryffindor, false, new String[]{});
        HogwartsStudent padma = new HogwartsStudent("Padma Patil", 1991, 1997, false, ravenclaw, false, new String[]{});
        HogwartsStudent parvati = new HogwartsStudent("Parvati Patil", 1991, 1997, false, gryffindor, false, new String[]{});
        HogwartsStudent lavender = new HogwartsStudent("Lavender Brown", 1991, 1997, false, gryffindor, false, new String[]{});
        HogwartsStudent gregory = new HogwartsStudent("Gregory Goyle", 1991, 1997, false, slytherin, false, new String[]{});
        HogwartsStudent vincent = new HogwartsStudent("Vincent Crabbe", 1991, 1997, false, slytherin, false, new String[]{});

        // Tilføj students til dynamic array
        students.add(hermione);
        students.add(ron);
        students.add(draco);
        students.add(neville);
        students.add(luna);
        students.add(ginny);
        students.add(cedric);
        students.add(cho);
        students.add(pansy);
        students.add(seamus);
        students.add(dean);
        students.add(padma);
        students.add(parvati);
        students.add(lavender);
        students.add(gregory);
        students.add(vincent);

        // print students
        System.out.println("Students:");
        for (int i = 0; i < students.size(); i++){
            HogwartsStudent student = (HogwartsStudent) students.get(i);
            //System.out.println(student.getFullName() + " from " + student.getHouse().getName() + " which has the colors " + String.join(" and ", student.getHouse().getColors()));
            System.out.println(student);
        }
        System.out.println("Antal studerende: " + students.size());
        System.out.println("Array størrelse: " + students.getCapacity());


        // Opret teachers
        HogwartsTeacher slughorn = new HogwartsTeacher("Horace E. Slughorn", EmpType.PROFESSOR, LocalDate.parse("1990-01-01"), null, slytherin, true);
        HogwartsTeacher snape = new HogwartsTeacher("Severus Snape", EmpType.PROFESSOR, LocalDate.parse("1990-01-01"), null, slytherin, true);
        // Tilføj teachers til array
        teachers.add(slughorn);
        teachers.add(snape);
        // print teachers
        System.out.println("Teachers:");
        for (int i = 0; i < teachers.size(); i++){
            Teacher teacher = (Teacher) teachers.get(i);
            //System.out.println(teacher.getFullName() + ", employment type: " + teacher.getEmploymentType() + ", employment start: " + teacher.getEmploymentStart());
            System.out.println(teacher);
        }


        // Test yearGroup
        YearGroup yearGroup1991 = new YearGroup(1991, LocalDate.parse("1991-01-05"));
        // Tilføjer students til yearGroup
        yearGroup1991.addStudent(harry);
        yearGroup1991.addStudent(ron);
        yearGroup1991.addStudent(hermione);
        // printer yeargroup
        System.out.println("Year Group: " + yearGroup1991.getSchoolYear());
        System.out.println("Start of school year: " + yearGroup1991.getBeginningOfSchoolYear());
        System.out.println("Number of students: " + yearGroup1991.getNumberOfStudents());
        for (int i = 0; i < yearGroup1991.getNumberOfStudents(); i++){
            HogwartsStudent student = yearGroup1991.getStudent(i);
            System.out.println("- " + student.getFullName() + " from " + student.getHouse().getName());
        }


        // Opretter potions fag
        Subject potions = new Subject("Potions", 6, false);
        // Opretter potions kursus med Horace Slughorn som teacher
        Course potionsSixthYear = new Course(potions, slughorn);
        // Tilføjer students til course
        for (int i = 0; i < students.size(); i++){
            HogwartsStudent student = (HogwartsStudent) students.get(i);//
            potionsSixthYear.addStudent(student);
        }
        // printer students på courset
        for (int i = 0; i < potionsSixthYear.getStudents().size(); i++){
            HogwartsStudent student = (HogwartsStudent) potionsSixthYear.getStudents().get(i);
            System.out.println("Potions 6 student: " + student.getFullName() + " from " + student.getHouse().getName());
        }
        //System.out.println(potionsSixthYear);

        // Opretter forskellige teaching materials
        TextBook potionmaking = new TextBook("Advanced Potion-Making", false, true, false, "edu.hogwarts.data.Course-book", "Advanced Potion-Making", "Libatius Borage", "Merge Books", 1946);
        Tool cauldron = new Tool("Cauldron", true, true, true, "Steel", "A standard potion-making cauldron");
        Tool silverKnife = new Tool("Silver Knife", true, true, false, "Silver", "A knife for cutting ingredients");
        Ingredient ingredient1 = new Ingredient("Boomslang Skin", false, true, true, "Boomslang", 0.5, "ounces");
        Ingredient ingredient2 = new Ingredient("Bicorn Horn", true, false, true, "Bicorn", 0.2, "ounces");
        // Tilføjer teaching materials til potion 6 course
        potionsSixthYear.addTeachingMaterial(potionmaking);
        potionsSixthYear.addTeachingMaterial(cauldron);
        potionsSixthYear.addTeachingMaterial(silverKnife);
        potionsSixthYear.addTeachingMaterial(ingredient1);
        potionsSixthYear.addTeachingMaterial(ingredient2);
        // Printer detaljer om course, tilknyttede teachers, students og teaching materials
        System.out.println("edu.hogwarts.data.Course: " + potionsSixthYear.getSubject().getName());
        System.out.println("edu.generic.Teacher: " + potionsSixthYear.getTeacher().getFullName());
        System.out.println("Students:");
        for (int i = 0; i < potionsSixthYear.getStudents().size(); i++){
            HogwartsStudent student = (HogwartsStudent) potionsSixthYear.getStudents().get(i);
            System.out.println("- " + student.getFullName() +  " from " + student.getHouse().getName());
        }

        System.out.println("Teaching materials:");
        for (TeachingMaterial teachingMaterial : potionsSixthYear.getTeachingMaterials()){
            System.out.println("- " + teachingMaterial.getName());
        }


    }
}