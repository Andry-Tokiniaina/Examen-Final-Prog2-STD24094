package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GestionFrais {
    private List<Fees> fees;

    public GestionFrais(){
        this.fees = new ArrayList<>();
    }

    public void addFee(Fees fees) {
        this.fees.add(fees);
    }

    public List<Fees> getLateFees(List<Fees> fees, Instant t){
        List<Fees> l = new ArrayList<>();
        for(Fees fee : fees){
            if(fee.statut() == Statuts.LATE){
                l.add(fee);
            }
        }
        return l;
    }

    public double getTotalMissingFees(List<Fees> fees, Instant t){
        double total = 0;
        for(Fees fee : getLateFees(fees, t)){
            total+= fee.restToPayAt(t);
        }
        return total;
    }

    public double getTotalPaidByStudent(Student student, List<Fees> fees, Instant t){
        double total = 0;
        for(Fees fee : fees){
            total+= fee.getPaidedAt(t);
        }
        return total;
    }
}
