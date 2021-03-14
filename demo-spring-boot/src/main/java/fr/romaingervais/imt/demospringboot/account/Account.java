package fr.romaingervais.imt.demospringboot.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("accounts")
public class Account implements Persistable<String> {
    @Id
    private String accountId;

    private double total;

    @Transient
    private boolean isNew = false;

    @MappedCollection(idColumn = "account_id")
    Set<DebitRef> debits = new HashSet<>();

    public void addDebit(Debit debit) {
        debits.add(new DebitRef(debit.getId()));
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String getId() {
        return accountId;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
