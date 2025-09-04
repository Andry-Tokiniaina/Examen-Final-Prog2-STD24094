package org.example;

import java.time.Instant;

public class Paiement {
    private int id;
    private double amount;
    private Instant datePaiement;

    public Paiement(int id, double value, Instant datePaiement, Fees fees) {
        this.id = id;
        this.amount = value;
        this.datePaiement = datePaiement;
        fees.addPaiement(this);
    }

    public double getValue() {
        return this.amount;
    }

    public Instant getDatePaiement() {
        return this.datePaiement;
    }
}
