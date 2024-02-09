package edu.hogwarts.data;

import edu.generic.Teacher;

import java.time.LocalDate;

public class HogwartsTeacher extends Teacher implements HogwartsPerson {
    private House house;
    private boolean headOfHouse;

    public String toString(){
        return super.toString() + ", " + house + ", is head of house=" + headOfHouse + "}";
    }

    public HogwartsTeacher(String firstName, String middleName, String lastName, EmpType employmentType, LocalDate employmentStart, LocalDate employmentEnd, House house, boolean headOfHouse) {
        super(firstName, middleName, lastName, employmentType, employmentStart, employmentEnd);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }
    public HogwartsTeacher(String fullName, EmpType employmentType, LocalDate employmentStart, LocalDate employmentEnd, House house, boolean headOfHouse) {
        super(fullName, employmentType, employmentStart, employmentEnd);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public House getHouse(){
        return house;
    }

    public void setHouse(House house){
        this.house = house;
    }

    public boolean isHeadOfHouse(){
        return headOfHouse;
    }

    public void setHeadofHouse(boolean headOfHouse){
        this.headOfHouse = headOfHouse;
    }
}