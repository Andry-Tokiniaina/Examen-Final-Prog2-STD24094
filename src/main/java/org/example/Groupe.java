package org.example;

import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private final int id;
    private final String name;
    private List<Student> students;

    public Groupe(int id, String nom) {
        this.id = id;
        this.name = nom;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }
}
