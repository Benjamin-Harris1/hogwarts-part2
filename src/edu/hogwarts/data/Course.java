package edu.hogwarts.data;

import edu.generic.Student;
import edu.generic.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private Subject subject;
    private Teacher teacher;
    private DynamicArray students;
    private List<TeachingMaterial> teachingMaterials;

    public String toString(){
        return subject + ", teacher: " + teacher + ", students: " + students + ", materials: " + teachingMaterials;
    }

    public Course(Subject subject, Teacher teacher){
        this.subject = subject;
        this.teacher = teacher;
        this.students = new DynamicArray();
        this.teachingMaterials = new ArrayList<>();
    }

    public void addTeachingMaterial(TeachingMaterial teachingMaterial){
        this.teachingMaterials.add(teachingMaterial);
    }

    public void removeTeachingMaterial(TeachingMaterial teachingMaterial){
        this.teachingMaterials.remove(teachingMaterial);
    }

    public boolean addStudent(Student student){
        if (students.size() < 12) {
            students.add(student);
            return true;
        }
        return false;
    }

    public Subject getSubject(){
        return subject;
    }

    public void setSubject(Subject subject){
        this.subject = subject;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public DynamicArray getStudents(){
        return students;
    }

    public List<TeachingMaterial> getTeachingMaterials(){
        return teachingMaterials;
    }
}
