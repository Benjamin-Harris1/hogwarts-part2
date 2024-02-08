package edu.hogwarts.data;

import edu.generic.Student;

public class HogwartsStudent extends Student implements HogwartsPerson{
    private House house;
    private boolean prefect;
    private String[] teams;

    public String toString(){
        return super.toString() + house + ", prefect=" + prefect + ", teams=" + String.join(", ", teams) + "}";
    }

    public HogwartsStudent(String firstName, String middleName, String lastName, int enrollmentYear, int graduationYear, boolean graduated, House house, boolean prefect, String[] teams){
        super(firstName, middleName, lastName, enrollmentYear, graduationYear, graduated);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent(String fullName, int enrollmentYear, int graduationYear, boolean graduated, House house, boolean prefect, String[] teams){
        super(fullName, enrollmentYear, graduationYear, graduated);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent(){

    }

    public House getHouse(){
        return house;
    }

    public void setHouse(House house){
        this.house = house;
    }

    public boolean isPrefect(){
        return prefect;
    }

    public void setPrefect(boolean prefect){
        this.prefect = prefect;
    }

    public String[] getTeams(){
        return teams;
    }

    public void setTeams(String[] teams){
        this.teams = teams;
    }
}