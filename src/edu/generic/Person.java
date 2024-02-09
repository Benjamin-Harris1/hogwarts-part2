package edu.generic;

public class Person {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;

    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Person(String fullName){
        setFullName(fullName);
    }

    public String toString(){
        if (middleName != null) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getMiddleName(){
        return middleName;
    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public boolean hasMiddleName(){
        return middleName != null;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFullName(){
        if (hasMiddleName()){
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    public void setFullName(String fullName){
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        if (parts.length == 3){
            middleName = parts[1];
            lastName = parts[2];
        } else if (parts.length == 2){
            middleName = null;
            lastName = parts[1];
        } else {
            middleName = null;
        }
    }
}
