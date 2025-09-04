package org.example;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Groupe groupe1 = new Groupe(1, "k3");
        Student student = new Student("STD24001", "RAKOTOZANANY", "Toky",
                Instant.parse("2024-10-01T08:00:00Z"), groupe1 );
        Fees fee1 = new Fees(1, "schooling",
                318_000.00d, Instant.parse("2025-01-01T08:00:00Z"), student);
        Fees fee2 = new Fees(2, "participation fees",
                20_000.00d, Instant.parse("2025-02-27T10:00:00Z"), student);
        Fees fee3 = new Fees( 3,"entrance fee to a party",
                10_000.00d, Instant.parse("2025-03-23T10:00:00Z"), student);
        Fees fee4 = new Fees(4, "re-selection exam",
                60_000.00d, Instant.parse("2025-10-15T12:00:00Z"), student);
        Paiement paiement1 = new Paiement(1, 300_000.00d,
                Instant.parse("2024-09-10T08:00:00Z"), fee1);
        Paiement paiement2 = new Paiement(2, 18_000.00d,
                Instant.parse("2024-09-25T10:00:00Z"), fee1);
        Paiement paiement3 = new Paiement(3, 22_000.00d,
                Instant.parse("2025-02-20T10:00:00Z"), fee2);
        Paiement paiement4 = new Paiement(4, 5_000,
                Instant.parse("2025-03-22T10:00:00Z"), fee3);

        System.out.println(fee1.statut());
        System.out.println(fee2.statut());
        System.out.println(fee3.statut());
        System.out.println(fee4.statut());
    }
}