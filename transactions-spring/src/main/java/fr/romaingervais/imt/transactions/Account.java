package fr.romaingervais.imt.transactions;

public class Account {
    private String accountId;
    private double total;

    public Account(String accountId, double total) {
        this.accountId = accountId;
        this.total = total;
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
