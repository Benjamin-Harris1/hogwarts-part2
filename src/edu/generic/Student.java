package edu.generic;


public class Student extends Person {
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;


    public String toString(){
        return "Student{" + "name=" + super.toString() + ", enrollmentYear=" + enrollmentYear + ", graduationYear=" + graduationYear + ", graduated=" + graduated + ", ";
    }

    public Student(String firstName, String middleName, String lastName, int enrollmentYear, int graduationYear, boolean graduated){
        super(firstName, middleName, lastName);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public Student(String fullName, int enrollmentYear, int graduationYear, boolean graduated){
        super(fullName);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public Student(){

    }


    public int getEnrollmentYear(){
        return enrollmentYear;
    }
    public void setEnrollmentYear(int enrollmentYear){
        this.enrollmentYear = enrollmentYear;
    }

    public int getGraduationYear(){
        return graduationYear;
    }
    public void setGraduationYear(int graduationYear){
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated(){
        return graduated;
    }

    public void setGraduated(boolean graduated){
        this.graduated = graduated;
    }

}