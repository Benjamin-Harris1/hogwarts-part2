package edu.hogwarts.data;

import java.time.LocalDate;

public class YearGroup{
    private int schoolYear;
    private LocalDate beginningOfSchoolYear;
    private DynamicArray students;

    public YearGroup(int schoolYear, LocalDate beginningOfSchoolYear){
        this.schoolYear = schoolYear;
        this.beginningOfSchoolYear = beginningOfSchoolYear;
        this.students = new DynamicArray();
    }

    public int getSchoolYear(){
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear){
        this.schoolYear = schoolYear;
    }

    public LocalDate getBeginningOfSchoolYear(){
        return beginningOfSchoolYear;
    }

    public void setBeginningOfSchoolYear(LocalDate beginningOfSchoolYear){
        this.beginningOfSchoolYear = beginningOfSchoolYear;
    }

    public void addStudent(HogwartsStudent student){
        this.students.add(student);
    }

    public int getNumberOfStudents(){
        return this.students.size();
    }

    public HogwartsStudent getStudent(int index){
        return (HogwartsStudent)this.students.get(index);
    }

}