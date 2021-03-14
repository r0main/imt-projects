package fr.romaingervais.imt.demospringboot.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("accounts")
public class Account implements Persistable<String> {

    @Id
    private String accountId;

    private double total;

    @Transient
    boolean isNew = false;

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
}
