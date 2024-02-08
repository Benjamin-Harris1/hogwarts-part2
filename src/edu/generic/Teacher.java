package edu.generic;

import edu.hogwarts.data.EmpType;

import java.time.LocalDate;

public class Teacher extends Person {
    private EmpType employmentType;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public String toString(){
        return "Teacher{" + "name=" + super.toString() + ", employment type=" + employmentType;
    }

    public Teacher(String firstName, String middleName, String lastName, EmpType employmentType, LocalDate employmentStart, LocalDate employmentEnd){
        super(firstName, middleName, lastName);
        this.employmentType = employmentType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher(String fullName, EmpType employmentType, LocalDate employmentStart, LocalDate employmentEnd){
        super(fullName);
        this.employmentType = employmentType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher(){

    }

    public EmpType getEmploymentType(){
        return employmentType;
    }

    public void setEmploymentType(EmpType employmentType){
        this.employmentType = employmentType;
    }

    public LocalDate getEmploymentStart(){
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart){
        this.employmentStart = employmentStart;
    }
    public LocalDate getEmploymentEnd(){
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd){
        this.employmentEnd = employmentEnd;
    }
}