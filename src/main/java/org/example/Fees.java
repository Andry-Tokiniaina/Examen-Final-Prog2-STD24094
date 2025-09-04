package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Fees {
    private int id;
    private String label;
    private double amount;
    private Instant deadline;
    private Student student;
    private List<Paiement> paiements;
    private Statuts statut;

    public Fees(int id, String label, double amount, Instant deadline, Student student) {
        this.id = id;
        this.label = label;
        this.amount = amount;
        this.deadline = deadline;
        this.student = student;
        this.paiements = new ArrayList<>();
        this.statut = Statuts.IN_PROGRESS;
    }

    public void addPaiement(Paiement paiement) {
        this.paiements.add(paiement);
    }

    public double getAmount() {
        return amount;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public double getPaidedAt(Instant date) {
        double somme = 0;
        for (Paiement p : paiements) {
            if(p.getDatePaiement().isBefore(date)) {
                somme+=p.getValue();
            }
        }
        return somme;
    }

    public Statuts statut(){
        if(this.deadline.isAfter(Instant.now()) && getPaidedAt(Instant.now())<this.amount){
            return Statuts.IN_PROGRESS;
        }
        if(getPaidedAt(this.deadline) < this.amount){
            return Statuts.LATE;
        }
        if(getPaidedAt(Instant.now()) > this.amount){
            return Statuts.OVERPAID;
        }
        return Statuts.PAID;
    }

    public double restToPayAt(Instant date){
        return getPaidedAt(date)-this.amount;
    }
}
