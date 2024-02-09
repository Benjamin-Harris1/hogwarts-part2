package edu.hogwarts.controller;

import edu.hogwarts.data.HogwartsTeacher;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TeacherController implements Controller<HogwartsTeacher> {
    private Map<Integer, HogwartsTeacher> teachers = new HashMap<>();
    private int nextId = 1; // Hver teacher får et ID


    @Override
    public void create(HogwartsTeacher teacher) {
        teacher.setId(nextId);
        teachers.put(teacher.getId(), teacher);
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
    public List<HogwartsTeacher> getAllSorted(Comparator<HogwartsTeacher> comparator){
        List<HogwartsTeacher> list = new ArrayList<>(teachers.values());
        list.sort(comparator);
        return list;
    }

    @Override
    public void update(int id, HogwartsTeacher teacher) {
        if (teachers.containsKey(id)) {
            teacher.setId(id);
            teachers.put(id, teacher);   
        } else {
            System.out.println("Teacher with ID: " + id + " doesn't exist");
        }
    }

    @Override
    public void delete(int id) {
        teachers.remove(id);
    }

    @Override
    public List<HogwartsTeacher> getAllFiltered(Predicate<HogwartsTeacher> predicate) {
        return teachers.values().stream().filter(predicate).collect(Collectors.toList());
    }
}
