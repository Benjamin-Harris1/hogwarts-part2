package edu.hogwarts.data;

public class House{
    private String name;
    private String founder;
    private String[] colors;

    public String toString(){
        return "house=" + name +  ", founder=" + founder + ", colors=" + String.join(",", colors);
    }

    public House(String name, String founder, String[] colors){
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House(){

    }

    public String getName(){
        return name;
    }

    public String getFounder(){
        return founder;
    }

    public String[] getColors(){
        return colors;
    }

}