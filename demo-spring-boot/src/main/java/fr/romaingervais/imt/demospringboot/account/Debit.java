package fr.romaingervais.imt.demospringboot.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("debits")
public class Debit {
    @Id
    private Long id;

    private double montant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Debit debit = (Debit) o;

        if (Double.compare(debit.getMontant(), getMontant()) != 0) return false;
        return getId() != null ? getId().equals(debit.getId()) : debit.getId() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        temp = Double.doubleToLongBits(getMontant());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
