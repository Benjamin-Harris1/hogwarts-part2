package edu.hogwarts.controller;

import edu.hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeacherController implements Controller<HogwartsTeacher> {
    private Map<Integer, HogwartsTeacher> teachers = new HashMap<>();
    private int nextId = 1; // Hver teacher får et ID


    @Override
    public void create(HogwartsTeacher teacher) {
        teachers.put(nextId, teacher);
        System.out.println("Teacher created with ID: " + nextId);
        nextId++; // Inkrementér ID for hver create.
    }

    @Override
    public HogwartsTeacher get(int id) {
        return teachers.get(id);
    }

    @Override
    public ArrayList<HogwartsTeacher> getAll() {
        return new ArrayList<>(teachers.values());
    }

    @Override
    public void update(int id, HogwartsTeacher teacher) {

    }

    @Override
    public void delete(int id) {
        teachers.remove(id);
    }
}
