package edu.hogwarts.controller;

import edu.hogwarts.data.HogwartsStudent;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentController implements Controller<HogwartsStudent> {
    private Map<Integer, HogwartsStudent> students = new HashMap<>();
    private int nextId = 1; // Hver student får et ID

    @Override
    public void create(HogwartsStudent student) {
        students.put(nextId, student);
        System.out.println("Student created with ID: " + nextId);
        nextId++; // Inkrementér ID for hver create.
    }

    @Override
    public HogwartsStudent get(int id) {
        return students.get(id);
    }

    @Override
    public ArrayList<HogwartsStudent> getAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void update(int id, HogwartsStudent student) {

    }
    @Override
    public void delete(int id) {
        students.remove(id);
    }
}
