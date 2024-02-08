package edu.hogwarts.data;

import edu.generic.Person;

public class DynamicArray{

    private Person[] array;
    private int size;
    private int growSize;
    private int INITIAL_SIZE = 10;

    public DynamicArray(){
        array = new Person[INITIAL_SIZE];
        size = 0;
        growSize = 10;
    }

    public void add(Person object){
        if (size == array.length) {
            grow();
        }
        array[size] = object;
        size++;
    }

    public int getCapacity(){
        return array.length;
    }

    public int size(){
        return size;
    }

    public void remove(){
        size--;
        if(canShrink()){
            shrink();
        }
    }

    public void remove(int index){
        if (index >= 0 && index < size){
            for (int i = index; i < size - 1; i++){
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            remove();
        } else {
            System.out.println("Ugyldigt indeks: " + index);
        }
    }

    public void clear(){
        size = 0;
        while (canShrink()) {
            shrink();
        }
    }

    public Person get(int index){
        if (index >= 0 && index < size) {
            //System.out.println("Indeks " + index + ": "+ array[index]);
            return array[index];
        } else {
            System.out.println("Ugyldigt indeks: " + index);
            return null;
        }
    }
    public void set(int index, Person object){
        if (index >= 0 && index < size) {
            array[index] = object;
            System.out.println("Indsat " + object + " på " + index );
        } else {
            System.out.println("Ugyldigt indeks: " + index);
        }
    }

    private void grow(){
        Person[] newArray = new Person[array.length + growSize];

        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean canShrink(){
        return array.length > size && (array.length - size) > growSize && (array.length - growSize) >= INITIAL_SIZE;
    }

    public void shrink(){
        int newSize = array.length - growSize;
        Person[] newArray = new Person[newSize];

        for (int i = 0; i < newSize; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

}