package edu.hogwarts.controller;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface Controller<T> {
    void create(T object);
    T get(int id);
    List<T> getAll();
    List<T> getAllSorted(Comparator<T> comparator);
    void update(int id, T object);
    void delete(int id);
    List<T> getAllFiltered(Predicate<T> predicate);
}
