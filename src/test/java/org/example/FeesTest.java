package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class FeesTest {
    Fees fee1, fee2, fee3, fee4;
    Paiement paiement1, paiement2, paiement3, paiement4;
    Groupe groupe1;
    Student student;

    @BeforeEach
    void setUp() {
         groupe1 = new Groupe(1, "k3");
         student = new Student("STD24001", "RAKOTOZANANY", "Toky",
                Instant.parse("2024-10-01T08:00:00Z"), groupe1 );
         fee1 = new Fees(1, "schooling",
                318_000.00d, Instant.parse("2025-01-01T08:00:00Z"), student);
         fee2 = new Fees(2, "participation fees",
                20_000.00d, Instant.parse("2025-02-27T10:00:00Z"), student);
         fee3 = new Fees( 3,"entrance fee to a party",
                10_000.00d, Instant.parse("2025-03-23T10:00:00Z"), student);
         fee4 = new Fees(4, "re-selection exam",
                60_000.00d, Instant.parse("2025-10-15T12:00:00Z"), student);
         paiement1 = new Paiement(1, 300_000.00d,
                Instant.parse("2024-09-10T08:00:00Z"), fee1);
         paiement2 = new Paiement(2, 18_000.00d,
                Instant.parse("2024-09-25T10:00:00Z"), fee1);
         paiement3 = new Paiement(3, 22_000.00d,
                Instant.parse("2025-02-20T10:00:00Z"), fee2);
         paiement4 = new Paiement(4, 5_000,
                Instant.parse("2025-03-22T10:00:00Z"), fee3);
    }

    @Test
    void testStatusPAID(){
        assertEquals(Statuts.PAID, fee1.statut());
    }
    @Test
    void testStautsOVERPAID(){
        assertEquals(Statuts.OVERPAID, fee2.statut());
    }
    @Test
    void testStatutsLATE(){
        assertEquals(Statuts.LATE, fee3.statut());
    }
    @Test
    void testStatutsIN_PROGRESS(){
        assertEquals(Statuts.IN_PROGRESS, fee4.statut());
    }

}