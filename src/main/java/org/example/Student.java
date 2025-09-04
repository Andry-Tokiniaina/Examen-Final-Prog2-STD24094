package org.example;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private String firstName;
    private Instant EnterDate;
    private Map<Integer, Groupe> historiqueGroupes;
    private Groupe group;
    private List<Fees> fees;

    public Student(String id, String name, String firstName, Instant EnterDate, Groupe group) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.EnterDate = EnterDate;
        this.historiqueGroupes = new HashMap<>();
        this.group = group;
        this.group.addStudent(this);
    }

    public List<Fees> getFees() {
        return fees;
    }

    public void changeGroup(Groupe groupe) {
        this.group.removeStudent(this);
        this.group = groupe;
        this.group.addStudent(this);
    }

    public void addFees(Fees fees) {
        this.fees.add(fees);
    }
}
