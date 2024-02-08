package edu.hogwarts.controller;

import java.util.ArrayList;

public interface Controller<T> {
    void create(T object);
    T get(int id);
    ArrayList<T> getAll();
    void update(int id, T object);
    void delete(int id);

}
