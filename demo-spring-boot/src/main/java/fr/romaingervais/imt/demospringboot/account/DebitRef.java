package fr.romaingervais.imt.demospringboot.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("account_debit")
public class DebitRef {

    @Id
    @Column("debit_id")
    private Long debitId;

    public DebitRef(Long debitId) {
        this.debitId = debitId;
    }

    public Long getDebitId() {
        return debitId;
    }

    public void setDebitId(Long debitId) {
        this.debitId = debitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DebitRef debitRef = (DebitRef) o;

        return getDebitId() != null ? getDebitId().equals(debitRef.getDebitId()) : debitRef.getDebitId() == null;
    }

    @Override
    public int hashCode() {
        return getDebitId() != null ? getDebitId().hashCode() : 0;
    }
}
