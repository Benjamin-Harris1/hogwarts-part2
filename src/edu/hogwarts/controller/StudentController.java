package edu.hogwarts.controller;

import edu.hogwarts.data.HogwartsStudent;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentController implements Controller<HogwartsStudent> {
    private Map<Integer, HogwartsStudent> students = new HashMap<>();
    private int nextId = 1; // Hver student får et ID

    @Override
    public void create(HogwartsStudent student) {
        student.setId(nextId);
        students.put(student.getId(), student);
        nextId++; // Inkrementér ID for hver create.
    }

    @Override
    // Måske nextId istedet her, da student ikke har en id attribut?
    public HogwartsStudent get(int id) {
        return students.get(id);
    }

    @Override
    public List<HogwartsStudent> getAll() {
        return new ArrayList<>(students.values());
    }

    // Måske gør denne generisk til både students og teachers???
    public List<HogwartsStudent> getAllSorted(Comparator<HogwartsStudent> comparator){
        List<HogwartsStudent> list = new ArrayList<>(students.values());
        list.sort(comparator);
        return list;
    }

    @Override
    public void update(int id, HogwartsStudent student) {
        if (students.containsKey(id))  {
            student.setId(id);
            students.put(id, student);
        } else {
            System.out.println("Student with ID " + id + " doesn't exist");
        }
    } 

    @Override
    public void delete(int id) {
        students.remove(id);
    }

    @Override
    public List<HogwartsStudent> getAllFiltered(Predicate<HogwartsStudent> predicate) {
        return students.values().stream().filter(predicate).collect(Collectors.toList());
    }
}
